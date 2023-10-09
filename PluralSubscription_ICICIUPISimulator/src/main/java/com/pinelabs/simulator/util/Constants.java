package com.pinelabs.simulator.util;

public interface Constants {
    // We are using a Block cipher(CBC mode)
    String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5PADDING";
    // We are using a Block cipher(ECB mode)
    String RSA_CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
    String AES = "AES";
    String PUBLIC_KEY = "/customkey.pem";
    String PRIVATE_KEY = "/pubkey.pem";
    int SIXTEEN_DIGIT = 16;
    int TEN = 10;
    String RSA = "RSA";
    int KEY_SIZE_1024 = 1024;
    String CREATE_MANDATE = "createMandate";
    String EXECUTE_MANDATE = "executeMandate";
    String MANDATE_NOTIFICATION = "mandateNotification";
    String GET_TXN_STATUS = "getTransactionStatus";
    String GET_TXN_STATUS_BY_TYPE = "getTransactionStatusByCriteria";
    String FAILURE_RESPONSE_CODE = "8006";
    String DECRYPTION_FAILED = "Decryption Failed";
    String TRANSACTION_SUCCESSFUL = "Transaction Successful";
    String SUCCESS = "SUCCESS";
    String AT_CHAR = "@";
    String UPI = "UPI";
    String HYPHEN = " - ";
    String IS_VALID = "IS_VALID";
    String MISSING_REQUIRED_FIELD = "MISSING_REQUIRED_FIELD";
    String MISSING_REQUIRED_FIELD_UMN = "MISSING_REQUIRED_FIELD_UMN";
    String RECURRING = "RECURRING";
    String FAILURE = "FAILURE";
    String DATE_SHOULD_NOT_BE_LESS_THAN_CURRENT_DATE = "COLLECT_BY_DATE_SHOULD_BE_GREATER_THAN_CURRENT_DATE_OR_EQUAL_TO_CURRENT_DATE";
    String VALIDITY_END_DATE_SHOULD_NOT_BE_LESS_THAN_VALIDITY_START_DATE = "VALIDITY_END_DATE_SHOULD_NOT_BE_LESS_THAN_VALIDITY_START_DATE";

    String PAYEE_VPA = "pinelabstest@icici";
    String EXECUTE_MANDATE_RESPONSE_CODE_DESCRIPTION = "SIMULATOR CALLBACK FOR TESTING";

    String CALLBACK_SUCCESS_RESPONSE_CODE = "U91";
    String EXECUTE_MANDATE_CALLBACK_SUCCESS_STATUS = "SUCCESS";
    String DEFAULT_MOBILE = "0000000000";
    String DEFAULT_VPA = "met@icici";
    String DEFAULT_PAYER_NAME = "Manvi";
    String SUCCESS_RESPONSE_CODE = "92";

}
