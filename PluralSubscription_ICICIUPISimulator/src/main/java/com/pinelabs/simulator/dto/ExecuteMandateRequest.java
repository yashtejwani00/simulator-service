
package com.pinelabs.simulator.dto;

import lombok.Data;


@Data
public class ExecuteMandateRequest {
    public String merchantId;
    public String subMerchantId;
    public String terminalId;
    public String merchantTranId;
    public String merchantName;
    public String subMerchantName;
    public String amount;
    public String billNumber;
    public String remark;
    public String retryCount;
    public String mandateSeqNo;
    public String UMN;
    public String purpose;
}
