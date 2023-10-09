package com.pinelabs.simulator.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinelabs.simulator.dao.SimulatorMandatesDao;
import com.pinelabs.simulator.dto.*;
import com.pinelabs.simulator.entity.SimulatorMandatesTable;
import com.pinelabs.simulator.helper.EncryptionDecryptionHelper;
import com.pinelabs.simulator.mapper.MandateMapper;
import com.pinelabs.simulator.util.Constants;
import com.pinelabs.simulator.util.SimulatorUtils;
import com.pinelabs.simulator.validator.CustomValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


@Service
public class MandateService {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    EncryptionDecryptionHelper encryptionDecryptionHelper;

    @Autowired
    CustomValidator customValidator;
    @Autowired
    CallbackService callbackService;

    @Autowired
    SimulatorMandatesDao simulatorMandatesDao;

    @Autowired
    MandateMapper mandateMapper;

    private TaskScheduler taskScheduler;

    Logger logger = LoggerFactory.getLogger(MandateService.class);



    public EncryptedRequest handleMandateApi(String request) throws Exception {
        if(request.equals("{}")) return null;

        logger.info("inside of method handleMandateApi");
        MandateRequest createMandateRequest;

        // decrypt request pkt
        try {
            EncryptedRequest encryptedRequest = objectMapper.readValue(request, EncryptedRequest.class);
            String payload = encryptionDecryptionHelper.decryptData(encryptedRequest);
            createMandateRequest = objectMapper.readValue(payload, MandateRequest.class);
        } catch (Exception e) {
            logger.error("something went wrong, error: {}", e.getMessage());
            return null;
        }

        switch (createMandateRequest.getRequestType()){
            case "C":
                return createMandate(createMandateRequest);
            case "R":
                return revokeMandate(createMandateRequest);
            default:
                return null;
        }
    }

    private EncryptedRequest revokeMandate(MandateRequest createMandateRequest) throws Exception {
        logger.info("inside method revokeMandate");
        ApiResponse apiResponse;

        // handle request
        apiResponse = handleRevokeMandateRequest(createMandateRequest);
        try{
            SimulatorMandatesTable simulatorMandatesTable = mandateMapper.mapSimulatorMandatesTable(createMandateRequest, apiResponse);
            simulatorMandatesDao.save(simulatorMandatesTable);
        } catch (Exception e){
            logger.error("error while saving table SimulatorMandatesTable, error: {}", e.getMessage());
        }

        // schedule callback
        scheduleCallbackForRevokeMandate(createMandateRequest, apiResponse);

        // send response
        String apiResponseJson = objectMapper.writeValueAsString(apiResponse);
        EncryptedRequest encryptedResponse = encryptionDecryptionHelper.encryptRequest(apiResponseJson);
        encryptedResponse.setRequestId(UUID.randomUUID().toString());

        return encryptedResponse;
    }

    private void scheduleCallbackForRevokeMandate(MandateRequest request, ApiResponse response) {
        CallbackObject callbackObject = CallbackObject.builder()
                .BankRRN(response.getBankRRN())
                .terminalId(response.getTerminalId())
                .merchantId(response.getMerchantId())
                .PayerName(Constants.DEFAULT_PAYER_NAME)
                .PayerVA(request.getPayerVa())
                .UMN(SimulatorUtils.generateUMN())
                .PayerMobile(Constants.DEFAULT_MOBILE)
                .TxnStatus("REVOKE-SUCCESS")
                .ResponseCode("U91")
                .RespCodeDescription("SIMULATOR CALLBACK FOR TESTING")
                .TxnCompletionDate(SimulatorUtils.generateCompletionDate())
                .TxnInitDate(SimulatorUtils.generateCompletionDate())
                .PayerAmount(response.getAmount())
                .subMerchantId(response.getSubMerchantId())
                .merchantTranId(response.getMerchantTranId())
                .PayeeVPA(Constants.PAYEE_VPA)
                .build();

        Runnable runnable = () -> {
            try {
                String callback = objectMapper.writeValueAsString(callbackObject);
                EncryptedRequest encryptedRequest = encryptionDecryptionHelper.encryptRequest(callback);
                String encryptedCallback = objectMapper.writeValueAsString(encryptedRequest);
                callbackService.sendCallbackToInbound(encryptedCallback);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        taskScheduler = new ConcurrentTaskScheduler(service);
        taskScheduler.schedule(runnable, Date.from(Instant.now().plusMillis(10000)));
        logger.info("callback scheduled for revoke mandate");
    }

    private ApiResponse handleRevokeMandateRequest(MandateRequest request) {
        ApiResponse apiResponse = ApiResponse.builder().build();
        apiResponse.setResponse("92");
        apiResponse.setAmount(request.amount);
        apiResponse.setBankRRN(SimulatorUtils.generateBankRRN());
        apiResponse.setMessage("Transaction Successful");
        apiResponse.setTerminalId(request.terminalId);
        apiResponse.setMerchantId(request.merchantId);
        apiResponse.setSubMerchantId(request.subMerchantId);
        apiResponse.setSuccess("true");
        apiResponse.setMerchantTranId(request.merchantTranId);
        return apiResponse;
    }

    private EncryptedRequest createMandate(MandateRequest createMandateRequest) throws Exception {
        logger.info("inside method createMandate");
        ApiResponse apiResponse;

        // handle request
        apiResponse = handleCreateMandateRequest(createMandateRequest);
        try{
            SimulatorMandatesTable simulatorMandatesTable = mandateMapper.mapSimulatorMandatesTable(createMandateRequest, apiResponse);
            simulatorMandatesDao.save(simulatorMandatesTable);
        } catch (Exception e){
            logger.error("error while saving table SimulatorMandatesTable, error: {}", e.getMessage());
        }

        // schedule callback
        scheduleCallbackForCreateMandate(createMandateRequest, apiResponse);

        // send response
        String apiResponseJson = objectMapper.writeValueAsString(apiResponse);
        EncryptedRequest encryptedResponse = encryptionDecryptionHelper.encryptRequest(apiResponseJson);
        encryptedResponse.setRequestId(UUID.randomUUID().toString());

        return encryptedResponse;

    }

    private void scheduleCallbackForCreateMandate(MandateRequest request, ApiResponse response) {
        CallbackObject callbackObject = CallbackObject.builder()
                .BankRRN(response.getBankRRN())
                .terminalId(response.getTerminalId())
                .merchantId(response.getMerchantId())
                .PayerName("Manvi")
                .PayerVA("met@icici")
                .UMN(SimulatorUtils.generateUMN())
                .PayerMobile("0000000000")
                .TxnStatus("CREATE-SUCCESS")
                .ResponseCode("U91")
                .RespCodeDescription("SIMULATOR CALLBACK FOR TESTING")
                .TxnCompletionDate(SimulatorUtils.generateCompletionDate())
                .TxnInitDate(SimulatorUtils.generateCompletionDate())
                .PayerAmount(response.Amount)
                .subMerchantId(response.subMerchantId)
                .merchantTranId(response.merchantTranId)
                .PayeeVPA("pinelabstest@icici")
                .build();

        Runnable runnable = () -> {
            try {
                String callback = objectMapper.writeValueAsString(callbackObject);
                EncryptedRequest encryptedRequest = encryptionDecryptionHelper.encryptRequest(callback);
                String encryptedCallback = objectMapper.writeValueAsString(encryptedRequest);
                callbackService.sendCallbackToInbound(encryptedCallback);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        taskScheduler = new ConcurrentTaskScheduler(service);
        taskScheduler.schedule(runnable, Date.from(Instant.now().plusMillis(10000)));
        logger.info("callback scheduled");
    }

    private ApiResponse handleCreateMandateRequest(MandateRequest request) {
        ApiResponse apiResponse = ApiResponse.builder().build();
        apiResponse.setResponse("92");
        apiResponse.setAmount(request.amount);
        apiResponse.setBankRRN(SimulatorUtils.generateBankRRN());
        apiResponse.setMessage("Transaction Successful");
        apiResponse.setTerminalId(request.terminalId);
        apiResponse.setMerchantId(request.merchantId);
        apiResponse.setSubMerchantId(request.subMerchantId);
        apiResponse.setSuccess("true");
        apiResponse.setMerchantTranId(request.merchantTranId);

        return apiResponse;
    }


    public EncryptedRequest createMandateQR(String request) throws Exception {
        logger.info("inside of method createMandate");
        ApiResponseQR apiResponse = new ApiResponseQR();

        try {
            // decrypt request pkt
            EncryptedRequest encryptedRequest = objectMapper.readValue(request, EncryptedRequest.class);
            logger.info("sending request for decryption");
            String payload = encryptionDecryptionHelper.decryptData(encryptedRequest);
            logger.info("decryption successful, payload: {}", payload);

            // handle request
            MandateRequest createMandateRequest = objectMapper.readValue(payload, MandateRequest.class);
            apiResponse = handleCreateMandateQRRequest(createMandateRequest);

            // schedule callback
            // TODO
//            scheduleCallbackForQR(createMandateRequest, apiResponse);

            // send response
            String apiResponseJson = objectMapper.writeValueAsString(apiResponse);
            EncryptedRequest encryptedResponse = encryptionDecryptionHelper.encryptRequest(apiResponseJson);
            encryptedResponse.setRequestId(UUID.randomUUID().toString());

            return encryptedResponse;
        } catch (Exception e) {
            logger.error("something went wrong");
            return encryptionDecryptionHelper.encryptRequest(objectMapper.writeValueAsString(apiResponse));
        }
    }

    private ApiResponseQR handleCreateMandateQRRequest(MandateRequest request) {
        ApiResponseQR apiResponse = new ApiResponseQR();
        apiResponse.setAmount(request.amount);
        apiResponse.setMessage("Transaction Successful");
        apiResponse.setTerminalId(request.terminalId);
        apiResponse.setMerchantId(request.merchantId);
        apiResponse.setSubMerchantId(request.subMerchantId);
        apiResponse.setSuccess("true");
        apiResponse.setMerchantTranId(request.merchantTranId);
        apiResponse.setActCode("92");
        apiResponse.setRefId("EZM"+SimulatorUtils.generateBankRRN());
        apiResponse.setSignedQRData(SimulatorUtils.generateQRData(request, apiResponse));
        return apiResponse;
    }

    private void scheduleCallbackForQR(MandateRequest request, ApiResponseQR response) {
        CallbackObject callbackObject = CallbackObject.builder()
                .BankRRN(SimulatorUtils.generateBankRRN())
                .terminalId(response.getTerminalId())
                .merchantId(response.getMerchantId())
                .PayerName("Manvi")
                .PayerVA("met@icici")
                .UMN(SimulatorUtils.generateUMN())
                .PayerMobile("0000000000")
                .TxnStatus("CREATE-SUCCESS")
                .ResponseCode("U91")
                .RespCodeDescription("SIMULATOR CALLBACK FOR TESTING")
                .TxnCompletionDate(SimulatorUtils.generateCompletionDate())
                .TxnInitDate(SimulatorUtils.generateCompletionDate())
                .PayerAmount(response.Amount)
                .subMerchantId(response.subMerchantId)
                .merchantTranId(response.merchantTranId)
                .PayeeVPA("pinelabstest@icici")
                .build();

        Runnable runnable = () -> {
            try {
                String callback = objectMapper.writeValueAsString(callbackObject);
                EncryptedRequest encryptedRequest = encryptionDecryptionHelper.encryptRequest(callback);
                String encryptedCallback = objectMapper.writeValueAsString(encryptedRequest);
                callbackService.sendCallbackToInbound(encryptedCallback);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        taskScheduler = new ConcurrentTaskScheduler(service);
        taskScheduler.schedule(runnable, Date.from(Instant.now().plusMillis(10000)));
        logger.info("callback scheduled");
    }
}


