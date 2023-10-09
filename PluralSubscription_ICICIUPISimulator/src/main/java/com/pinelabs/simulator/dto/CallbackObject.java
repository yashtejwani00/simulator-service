package com.pinelabs.simulator.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CallbackObject {

    public String merchantId;
    public String subMerchantId;
    public String terminalId;
    public String BankRRN;
    public String merchantTranId;
    public String PayerName;
    public String PayerMobile;
    public String PayerVA;
    public String PayerAmount;
    public String TxnStatus;
    public String TxnInitDate;
    public String TxnCompletionDate;
    public String UMN;
    public String ResponseCode;
    public String RespCodeDescription;
    public String PayeeVPA;
}
