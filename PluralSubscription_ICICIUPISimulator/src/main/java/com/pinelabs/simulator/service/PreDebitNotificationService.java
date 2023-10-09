package com.pinelabs.simulator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinelabs.simulator.dto.ApiResponse;
import com.pinelabs.simulator.dto.EncryptedRequest;
import com.pinelabs.simulator.dto.NotificationRequest;
import com.pinelabs.simulator.helper.EncryptionDecryptionHelper;
import com.pinelabs.simulator.util.Constants;
import com.pinelabs.simulator.util.SimulatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreDebitNotificationService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EncryptionDecryptionHelper encryptionDecryptionHelper;

    private final Logger logger = LoggerFactory.getLogger(PreDebitNotificationService.class);

    public EncryptedRequest preDebitNotification(String encryptedPreDebitNotificationRequest) throws Exception {
        logger.info("inside method preDebitNotification with payload: {}", encryptedPreDebitNotificationRequest);

        logger.info("decrypt request");
        EncryptedRequest encryptedRequest = objectMapper.readValue(encryptedPreDebitNotificationRequest, EncryptedRequest.class);
        String decryptedPreDebitNotificationRequest = encryptionDecryptionHelper.decryptData(encryptedRequest);
        NotificationRequest notificationRequest = objectMapper.readValue(decryptedPreDebitNotificationRequest, NotificationRequest.class);

        logger.info("handle PreDebitNotification");
        ApiResponse apiResponse = handlePreDebitNotification(notificationRequest);

        logger.info("send response for PreDebitNotification");
        String response = objectMapper.writeValueAsString(apiResponse);
        return encryptionDecryptionHelper.encryptRequest(response);
    }

    private ApiResponse handlePreDebitNotification(NotificationRequest request) {
        ApiResponse apiResponse = ApiResponse.builder()
                .Amount(request.amount)
                .merchantId(request.merchantId)
                .subMerchantId(request.subMerchantId)
                .merchantTranId(request.merchantTranId)
                .terminalId(request.terminalId)
                .response(Constants.SUCCESS_RESPONSE_CODE)
                .BankRRN(SimulatorUtils.generateBankRRN())
                .success("true")
                .message("Transaction Successful")
                .build();
        return apiResponse;
    }
}
