package com.pinelabs.simulator.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class NotificationRequest {
    public String merchantId;
    public String subMerchantId;
    public String terminalId;
    public String merchantName;
    public String subMerchantName;
    public String payerVa;
    public String amount;
    public String note;
    public String executionDate;
    public String merchantTranId;
    public String mandateSeqNo;
    public String key;
    public String value;

}
