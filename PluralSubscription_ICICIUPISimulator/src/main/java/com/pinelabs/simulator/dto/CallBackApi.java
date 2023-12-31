
package com.pinelabs.simulator.dto;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Mandate Notification API Request
 * <p>
 * Mandate Notification API Request JSON
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "merchantId",
    "subMerchantId",
    "terminalId",
    "BankRRN",
    "merchantTranId",
    "PayerName",
    "PayerMobile",
    "PayerVa",
    "PayerAmount",
    "TxnStatus",
    "TxnInitDate",
    "TxnCompletionDate",
    "mandateSeqNo",
    "UMN"
})
public class CallBackApi {

    /**
     * Merchant Identification Number
     * 
     */
    @JsonProperty("merchantId")
    @JsonPropertyDescription("Merchant Identification Number")
    private Double merchantId;
    /**
     * Sub Merchant Identification Number of Merchant 
     * 
     */
    @JsonProperty("subMerchantId")
    @JsonPropertyDescription("Sub Merchant Identification Number of Merchant ")
    private Double subMerchantId;
    /**
     * Needs to send Merchant category code (MCC code). [Default MCC-5411] 
     * 
     */
    @JsonProperty("terminalId")
    @JsonPropertyDescription("Needs to send Merchant category code (MCC code). [Default MCC-5411] ")
    private Double terminalId;
    /**
     * Bank reference Number for this transaction
     * 
     */
    @JsonProperty("BankRRN")
    @JsonPropertyDescription("Bank reference Number for this transaction")
    private Double bankRRN;
    /**
     * This will be a Unique Transaction ID generated by the Merchant. 
     * 
     */
    @JsonProperty("merchantTranId")
    @JsonPropertyDescription("This will be a Unique Transaction ID generated by the Merchant. ")
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Size(max = 35)
    private String merchantTranId;
    /**
     * Sub Merchant Name of the Merchant
     * 
     */
    @JsonProperty("PayerName")
    @JsonPropertyDescription("Sub Merchant Name of the Merchant")
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Size(max = 50)
    private String payerName;
    /**
     * Alias name with which the payer can be identified by his registered entity
     * 
     */
    @JsonProperty("PayerMobile")
    @JsonPropertyDescription("Alias name with which the payer can be identified by his registered entity")
    private Double payerMobile;
    /**
     * Sub Merchant Name of the Merchant
     * 
     */
    @JsonProperty("PayerVa")
    @JsonPropertyDescription("Sub Merchant Name of the Merchant")
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Size(max = 255)
    private String payerVa;
    /**
     * Amount to be debited.(In Rupees, Integer value with 2 decimal) E.g. : 200.00 / 300.12
     * 
     */
    @JsonProperty("PayerAmount")
    @JsonPropertyDescription("Amount to be debited.(In Rupees, Integer value with 2 decimal) E.g. : 200.00 / 300.12")
    private Double payerAmount;
    /**
     * Status of the Transaction 
     * 
     */
    @JsonProperty("TxnStatus")
    @JsonPropertyDescription("Status of the Transaction ")
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    @Size(max = 20)
    private String txnStatus;
    /**
     * Date and time on which the transaction was initiated 
     * 
     */
    @JsonProperty("TxnInitDate")
    @JsonPropertyDescription("Date and time on which the transaction was initiated ")
    private Object txnInitDate;
    /**
     * Date and time on which the transaction was completed 
     * 
     */
    @JsonProperty("TxnCompletionDate")
    @JsonPropertyDescription("Date and time on which the transaction was completed ")
    private Object txnCompletionDate;
    /**
     * Execution Sequence Number 
     * 
     */
    @JsonProperty("mandateSeqNo")
    @JsonPropertyDescription("Execution Sequence Number ")
    private Double mandateSeqNo;
    /**
     * UPI Mandate number generated at manage mandate request <32 character>@<PSP Handle> 
     * 
     */
    @JsonProperty("UMN")
    @JsonPropertyDescription("UPI Mandate number generated at manage mandate request <32 character>@<PSP Handle> ")
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String umn;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Merchant Identification Number
     * 
     */
    @JsonProperty("merchantId")
    public Double getMerchantId() {
        return merchantId;
    }

    /**
     * Merchant Identification Number
     * 
     */
    @JsonProperty("merchantId")
    public void setMerchantId(Double merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Sub Merchant Identification Number of Merchant 
     * 
     */
    @JsonProperty("subMerchantId")
    public Double getSubMerchantId() {
        return subMerchantId;
    }

    /**
     * Sub Merchant Identification Number of Merchant 
     * 
     */
    @JsonProperty("subMerchantId")
    public void setSubMerchantId(Double subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    /**
     * Needs to send Merchant category code (MCC code). [Default MCC-5411] 
     * 
     */
    @JsonProperty("terminalId")
    public Double getTerminalId() {
        return terminalId;
    }

    /**
     * Needs to send Merchant category code (MCC code). [Default MCC-5411] 
     * 
     */
    @JsonProperty("terminalId")
    public void setTerminalId(Double terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * Bank reference Number for this transaction
     * 
     */
    @JsonProperty("BankRRN")
    public Double getBankRRN() {
        return bankRRN;
    }

    /**
     * Bank reference Number for this transaction
     * 
     */
    @JsonProperty("BankRRN")
    public void setBankRRN(Double bankRRN) {
        this.bankRRN = bankRRN;
    }

    /**
     * This will be a Unique Transaction ID generated by the Merchant. 
     * 
     */
    @JsonProperty("merchantTranId")
    public String getMerchantTranId() {
        return merchantTranId;
    }

    /**
     * This will be a Unique Transaction ID generated by the Merchant. 
     * 
     */
    @JsonProperty("merchantTranId")
    public void setMerchantTranId(String merchantTranId) {
        this.merchantTranId = merchantTranId;
    }

    /**
     * Sub Merchant Name of the Merchant
     * 
     */
    @JsonProperty("PayerName")
    public String getPayerName() {
        return payerName;
    }

    /**
     * Sub Merchant Name of the Merchant
     * 
     */
    @JsonProperty("PayerName")
    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    /**
     * Alias name with which the payer can be identified by his registered entity
     * 
     */
    @JsonProperty("PayerMobile")
    public Double getPayerMobile() {
        return payerMobile;
    }

    /**
     * Alias name with which the payer can be identified by his registered entity
     * 
     */
    @JsonProperty("PayerMobile")
    public void setPayerMobile(Double payerMobile) {
        this.payerMobile = payerMobile;
    }

    /**
     * Sub Merchant Name of the Merchant
     * 
     */
    @JsonProperty("PayerVa")
    public String getPayerVa() {
        return payerVa;
    }

    /**
     * Sub Merchant Name of the Merchant
     * 
     */
    @JsonProperty("PayerVa")
    public void setPayerVa(String payerVa) {
        this.payerVa = payerVa;
    }

    /**
     * Amount to be debited.(In Rupees, Integer value with 2 decimal) E.g. : 200.00 / 300.12
     * 
     */
    @JsonProperty("PayerAmount")
    public Double getPayerAmount() {
        return payerAmount;
    }

    /**
     * Amount to be debited.(In Rupees, Integer value with 2 decimal) E.g. : 200.00 / 300.12
     * 
     */
    @JsonProperty("PayerAmount")
    public void setPayerAmount(Double payerAmount) {
        this.payerAmount = payerAmount;
    }

    /**
     * Status of the Transaction 
     * 
     */
    @JsonProperty("TxnStatus")
    public String getTxnStatus() {
        return txnStatus;
    }

    /**
     * Status of the Transaction 
     * 
     */
    @JsonProperty("TxnStatus")
    public void setTxnStatus(String txnStatus) {
        this.txnStatus = txnStatus;
    }

    /**
     * Date and time on which the transaction was initiated 
     * 
     */
    @JsonProperty("TxnInitDate")
    public Object getTxnInitDate() {
        return txnInitDate;
    }

    /**
     * Date and time on which the transaction was initiated 
     * 
     */
    @JsonProperty("TxnInitDate")
    public void setTxnInitDate(Object txnInitDate) {
        this.txnInitDate = txnInitDate;
    }

    /**
     * Date and time on which the transaction was completed 
     * 
     */
    @JsonProperty("TxnCompletionDate")
    public Object getTxnCompletionDate() {
        return txnCompletionDate;
    }

    /**
     * Date and time on which the transaction was completed 
     * 
     */
    @JsonProperty("TxnCompletionDate")
    public void setTxnCompletionDate(Object txnCompletionDate) {
        this.txnCompletionDate = txnCompletionDate;
    }

    /**
     * Execution Sequence Number 
     * 
     */
    @JsonProperty("mandateSeqNo")
    public Double getMandateSeqNo() {
        return mandateSeqNo;
    }

    /**
     * Execution Sequence Number 
     * 
     */
    @JsonProperty("mandateSeqNo")
    public void setMandateSeqNo(Double mandateSeqNo) {
        this.mandateSeqNo = mandateSeqNo;
    }

    /**
     * UPI Mandate number generated at manage mandate request <32 character>@<PSP Handle> 
     * 
     */
    @JsonProperty("UMN")
    public String getUmn() {
        return umn;
    }

    /**
     * UPI Mandate number generated at manage mandate request <32 character>@<PSP Handle> 
     * 
     */
    @JsonProperty("UMN")
    public void setUmn(String umn) {
        this.umn = umn;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CallBackApi.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("merchantId");
        sb.append('=');
        sb.append(((this.merchantId == null)?"<null>":this.merchantId));
        sb.append(',');
        sb.append("subMerchantId");
        sb.append('=');
        sb.append(((this.subMerchantId == null)?"<null>":this.subMerchantId));
        sb.append(',');
        sb.append("terminalId");
        sb.append('=');
        sb.append(((this.terminalId == null)?"<null>":this.terminalId));
        sb.append(',');
        sb.append("bankRRN");
        sb.append('=');
        sb.append(((this.bankRRN == null)?"<null>":this.bankRRN));
        sb.append(',');
        sb.append("merchantTranId");
        sb.append('=');
        sb.append(((this.merchantTranId == null)?"<null>":this.merchantTranId));
        sb.append(',');
        sb.append("payerName");
        sb.append('=');
        sb.append(((this.payerName == null)?"<null>":this.payerName));
        sb.append(',');
        sb.append("payerMobile");
        sb.append('=');
        sb.append(((this.payerMobile == null)?"<null>":this.payerMobile));
        sb.append(',');
        sb.append("payerVa");
        sb.append('=');
        sb.append(((this.payerVa == null)?"<null>":this.payerVa));
        sb.append(',');
        sb.append("payerAmount");
        sb.append('=');
        sb.append(((this.payerAmount == null)?"<null>":this.payerAmount));
        sb.append(',');
        sb.append("txnStatus");
        sb.append('=');
        sb.append(((this.txnStatus == null)?"<null>":this.txnStatus));
        sb.append(',');
        sb.append("txnInitDate");
        sb.append('=');
        sb.append(((this.txnInitDate == null)?"<null>":this.txnInitDate));
        sb.append(',');
        sb.append("txnCompletionDate");
        sb.append('=');
        sb.append(((this.txnCompletionDate == null)?"<null>":this.txnCompletionDate));
        sb.append(',');
        sb.append("mandateSeqNo");
        sb.append('=');
        sb.append(((this.mandateSeqNo == null)?"<null>":this.mandateSeqNo));
        sb.append(',');
        sb.append("umn");
        sb.append('=');
        sb.append(((this.umn == null)?"<null>":this.umn));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.txnInitDate == null)? 0 :this.txnInitDate.hashCode()));
        result = ((result* 31)+((this.subMerchantId == null)? 0 :this.subMerchantId.hashCode()));
        result = ((result* 31)+((this.terminalId == null)? 0 :this.terminalId.hashCode()));
        result = ((result* 31)+((this.txnCompletionDate == null)? 0 :this.txnCompletionDate.hashCode()));
        result = ((result* 31)+((this.mandateSeqNo == null)? 0 :this.mandateSeqNo.hashCode()));
        result = ((result* 31)+((this.payerMobile == null)? 0 :this.payerMobile.hashCode()));
        result = ((result* 31)+((this.txnStatus == null)? 0 :this.txnStatus.hashCode()));
        result = ((result* 31)+((this.merchantId == null)? 0 :this.merchantId.hashCode()));
        result = ((result* 31)+((this.umn == null)? 0 :this.umn.hashCode()));
        result = ((result* 31)+((this.payerVa == null)? 0 :this.payerVa.hashCode()));
        result = ((result* 31)+((this.payerName == null)? 0 :this.payerName.hashCode()));
        result = ((result* 31)+((this.bankRRN == null)? 0 :this.bankRRN.hashCode()));
        result = ((result* 31)+((this.payerAmount == null)? 0 :this.payerAmount.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.merchantTranId == null)? 0 :this.merchantTranId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CallBackApi) == false) {
            return false;
        }
        CallBackApi rhs = ((CallBackApi) other);
        return ((((((((((((((((this.txnInitDate == rhs.txnInitDate)||((this.txnInitDate!= null)&&this.txnInitDate.equals(rhs.txnInitDate)))&&((this.subMerchantId == rhs.subMerchantId)||((this.subMerchantId!= null)&&this.subMerchantId.equals(rhs.subMerchantId))))&&((this.terminalId == rhs.terminalId)||((this.terminalId!= null)&&this.terminalId.equals(rhs.terminalId))))&&((this.txnCompletionDate == rhs.txnCompletionDate)||((this.txnCompletionDate!= null)&&this.txnCompletionDate.equals(rhs.txnCompletionDate))))&&((this.mandateSeqNo == rhs.mandateSeqNo)||((this.mandateSeqNo!= null)&&this.mandateSeqNo.equals(rhs.mandateSeqNo))))&&((this.payerMobile == rhs.payerMobile)||((this.payerMobile!= null)&&this.payerMobile.equals(rhs.payerMobile))))&&((this.txnStatus == rhs.txnStatus)||((this.txnStatus!= null)&&this.txnStatus.equals(rhs.txnStatus))))&&((this.merchantId == rhs.merchantId)||((this.merchantId!= null)&&this.merchantId.equals(rhs.merchantId))))&&((this.umn == rhs.umn)||((this.umn!= null)&&this.umn.equals(rhs.umn))))&&((this.payerVa == rhs.payerVa)||((this.payerVa!= null)&&this.payerVa.equals(rhs.payerVa))))&&((this.payerName == rhs.payerName)||((this.payerName!= null)&&this.payerName.equals(rhs.payerName))))&&((this.bankRRN == rhs.bankRRN)||((this.bankRRN!= null)&&this.bankRRN.equals(rhs.bankRRN))))&&((this.payerAmount == rhs.payerAmount)||((this.payerAmount!= null)&&this.payerAmount.equals(rhs.payerAmount))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.merchantTranId == rhs.merchantTranId)||((this.merchantTranId!= null)&&this.merchantTranId.equals(rhs.merchantTranId))));
    }

}
