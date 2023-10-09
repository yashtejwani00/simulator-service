
package com.pinelabs.simulator.dto;

import lombok.Data;


@Data
public class MandateRequest{
    public String merchantId;
    public String subMerchantId;
    public String terminalId;
    public String merchantName;
    public String subMerchantName;
    public String amount;
    public String merchantTranId;
    public String billNumber;
    public String requestType;
    public String collectByDate;
    public String validityStartDate;
    public String validityEndDate;
    public String amountLimit;
    public String frequency;
    public String remark;
    public String autoExecute;
    public String debitDay;
    public String debitRule;
    public String revokable;
    public String blockfund;
    public String purpose;
    public String Umn;
    public String payerVa;
    public String note;

}
