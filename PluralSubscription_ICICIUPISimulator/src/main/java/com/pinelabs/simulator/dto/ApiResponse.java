
package com.pinelabs.simulator.dto;

import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class ApiResponse {
    public String response;
    public String subMerchantId;
    public String merchantId;
    public String terminalId;
    public String success;
    public String message;
    public String merchantTranId;
    public String Amount;
    public String BankRRN;
//    private String umn;
}
