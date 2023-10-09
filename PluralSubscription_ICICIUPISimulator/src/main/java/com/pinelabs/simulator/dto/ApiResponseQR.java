package com.pinelabs.simulator.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ApiResponseQR {
    public String subMerchantId;
    public String merchantId;
    public String terminalId;
    public String success;
    public String message;
    public String merchantTranId;
    public String Amount;
    public String refId;
    public String SignedQRData;
    public String ActCode;
}
