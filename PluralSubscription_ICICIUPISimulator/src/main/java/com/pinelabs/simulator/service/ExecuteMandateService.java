package com.pinelabs.simulator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinelabs.simulator.dto.*;
import com.pinelabs.simulator.helper.EncryptionDecryptionHelper;
import com.pinelabs.simulator.util.Constants;
import com.pinelabs.simulator.util.SimulatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class ExecuteMandateService {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CallbackService callbackService;

    @Autowired
    private EncryptionDecryptionHelper encryptionDecryptionHelper;

    private final Logger logger = LoggerFactory.getLogger(ExecuteMandateService.class);

    public EncryptedRequest executeMandate(String encryptedRequest) throws Exception {
        logger.info("inside method executeMandate with request: {}", encryptedRequest);

        logger.info("decrypting payload");
        EncryptedRequest encryptedRequest1 = objectMapper.readValue(encryptedRequest, EncryptedRequest.class);
        String executeMandateRequestString = encryptionDecryptionHelper.decryptData(encryptedRequest1);

        logger.info("handling ExecuteMandate request");
        ExecuteMandateRequest executeMandateRequest = objectMapper.readValue(executeMandateRequestString, ExecuteMandateRequest.class);
        ApiResponse apiResponse = handlerExecuteMandate(executeMandateRequest);

        logger.info("scheduling callback");
        scheduleCallback(executeMandateRequest, apiResponse);

        logger.info("sending the response");
        String response = objectMapper.writeValueAsString(apiResponse);
        return encryptionDecryptionHelper.encryptRequest(response);
    }

    private void scheduleCallback(ExecuteMandateRequest request, ApiResponse response) {
        Timer timer = new Timer();
        CallbackObject callbackObject = CallbackObject.builder()
                .BankRRN(response.getBankRRN())
                .terminalId(response.getTerminalId())
                .merchantId(response.getMerchantId())
                .PayerName(Constants.DEFAULT_PAYER_NAME)
                .PayerVA(Constants.DEFAULT_VPA)
                .UMN(request.UMN)
                .PayerMobile(Constants.DEFAULT_MOBILE)
                .TxnStatus(Constants.EXECUTE_MANDATE_CALLBACK_SUCCESS_STATUS)
                .ResponseCode(Constants.CALLBACK_SUCCESS_RESPONSE_CODE)
                .RespCodeDescription(Constants.EXECUTE_MANDATE_RESPONSE_CODE_DESCRIPTION)
                .TxnCompletionDate(SimulatorUtils.generateCompletionDate())
                .TxnInitDate(SimulatorUtils.generateCompletionDate())
                .PayerAmount(response.getAmount())
                .subMerchantId(response.getSubMerchantId())
                .merchantTranId(response.getMerchantTranId())
                .PayeeVPA(Constants.PAYEE_VPA)
                .build();

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // send callback object to inbound service
                try {
                    String callback = objectMapper.writeValueAsString(callbackObject);
                    EncryptedRequest encryptedRequest = encryptionDecryptionHelper.encryptRequest(callback);
                    String encryptedCallback = objectMapper.writeValueAsString(encryptedRequest);
                    callbackService.sendCallbackToInbound(encryptedCallback);

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
        timer.schedule(timerTask, 1000);
    }

    private ApiResponse handlerExecuteMandate(ExecuteMandateRequest request) {
        return ApiResponse.builder()
                .terminalId(request.terminalId)
                .Amount(request.amount)
                .subMerchantId(request.subMerchantId)
                .merchantId(request.merchantId)
                .merchantTranId(request.merchantTranId)
                .BankRRN(SimulatorUtils.generateBankRRN())
                .response("92")
                .message("Transaction Successful")
                .success("true")
                .build();
    }
}
