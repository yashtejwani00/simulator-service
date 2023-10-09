
package com.pinelabs.simulator.dto;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    "transactionType",
    "transactionDate",
    "refID",
    "UMN"
})
public class TransactionStatus {

    /**
     * Merchant Identification Number
     * (Required)
     * 
     */
    @JsonProperty("merchantId")
    @JsonPropertyDescription("Merchant Identification Number")
    @NotNull
    private Integer merchantId;
    /**
     * Sub Merchant Identification Number of Merchant 
     * (Required)
     * 
     */
    @JsonProperty("subMerchantId")
    @JsonPropertyDescription("Sub Merchant Identification Number of Merchant ")
    @NotNull
    private Integer subMerchantId;
    /**
     * Needs to send Merchant category code (MCC code). [Default MCC-5411] 
     * (Required)
     * 
     */
    @JsonProperty("terminalId")
    @JsonPropertyDescription("Needs to send Merchant category code (MCC code). [Default MCC-5411] ")
    @NotNull
    private Integer terminalId;
    /**
     * Bank reference Number for this transaction
     * 
     */
    @JsonProperty("BankRRN")
    @JsonPropertyDescription("Bank reference Number for this transaction")
    private Integer bankRRN;
    /**
     * This will be a Unique Transaction ID generated by the Merchant. 
     * (Required)
     * 
     */
    @JsonProperty("merchantTranId")
    @JsonPropertyDescription("This will be a Unique Transaction ID generated by the Merchant. ")
    @Pattern(regexp = "^[a-zA-Z0-9{}/]+$")
    @NotNull
    private String merchantTranId;
    /**
     * Flag to identify type of original transaction ( M Y – Mandate)
     * 
     */
    @JsonProperty("transactionType")
    @JsonPropertyDescription("Flag to identify type of original transaction ( M Y \u2013 Mandate)")
    @Size(max = 1)
    private String transactionType;
    /**
     * Date of the Transaction
     * 
     */
    @JsonProperty("transactionDate")
    @JsonPropertyDescription("Date of the Transaction")
    private String transactionDate;
    /**
     * Reference Number passed in QR/Intent C Call
     * 
     */
    @JsonProperty("refID")
    @JsonPropertyDescription("Reference Number passed in QR/Intent C Call")
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String refID;
    /**
     * UPI Mandate number generated at manage mandate request <32 character>@<PSP Handle> 
     * 
     */
    @JsonProperty("UMN")
    @JsonPropertyDescription("UPI Mandate number generated at manage mandate request <32 character>@<PSP Handle> ")
    @Pattern(regexp = "^(.+)@(.+)$")
    private String umn;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Merchant Identification Number
     * (Required)
     * 
     */
    @JsonProperty("merchantId")
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * Merchant Identification Number
     * (Required)
     * 
     */
    @JsonProperty("merchantId")
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * Sub Merchant Identification Number of Merchant 
     * (Required)
     * 
     */
    @JsonProperty("subMerchantId")
    public Integer getSubMerchantId() {
        return subMerchantId;
    }

    /**
     * Sub Merchant Identification Number of Merchant 
     * (Required)
     * 
     */
    @JsonProperty("subMerchantId")
    public void setSubMerchantId(Integer subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    /**
     * Needs to send Merchant category code (MCC code). [Default MCC-5411] 
     * (Required)
     * 
     */
    @JsonProperty("terminalId")
    public Integer getTerminalId() {
        return terminalId;
    }

    /**
     * Needs to send Merchant category code (MCC code). [Default MCC-5411] 
     * (Required)
     * 
     */
    @JsonProperty("terminalId")
    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    /**
     * Bank reference Number for this transaction
     * 
     */
    @JsonProperty("BankRRN")
    public Integer getBankRRN() {
        return bankRRN;
    }

    /**
     * Bank reference Number for this transaction
     * 
     */
    @JsonProperty("BankRRN")
    public void setBankRRN(Integer bankRRN) {
        this.bankRRN = bankRRN;
    }

    /**
     * This will be a Unique Transaction ID generated by the Merchant. 
     * (Required)
     * 
     */
    @JsonProperty("merchantTranId")
    public String getMerchantTranId() {
        return merchantTranId;
    }

    /**
     * This will be a Unique Transaction ID generated by the Merchant. 
     * (Required)
     * 
     */
    @JsonProperty("merchantTranId")
    public void setMerchantTranId(String merchantTranId) {
        this.merchantTranId = merchantTranId;
    }

    /**
     * Flag to identify type of original transaction ( M Y – Mandate)
     * 
     */
    @JsonProperty("transactionType")
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Flag to identify type of original transaction ( M Y – Mandate)
     * 
     */
    @JsonProperty("transactionType")
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Date of the Transaction
     * 
     */
    @JsonProperty("transactionDate")
    public String getTransactionDate() {
        return transactionDate;
    }

    /**
     * Date of the Transaction
     * 
     */
    @JsonProperty("transactionDate")
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    /**
     * Reference Number passed in QR/Intent C Call
     * 
     */
    @JsonProperty("refID")
    public String getRefID() {
        return refID;
    }

    /**
     * Reference Number passed in QR/Intent C Call
     * 
     */
    @JsonProperty("refID")
    public void setRefID(String refID) {
        this.refID = refID;
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
        sb.append(TransactionStatus.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        sb.append("transactionType");
        sb.append('=');
        sb.append(((this.transactionType == null)?"<null>":this.transactionType));
        sb.append(',');
        sb.append("transactionDate");
        sb.append('=');
        sb.append(((this.transactionDate == null)?"<null>":this.transactionDate));
        sb.append(',');
        sb.append("refID");
        sb.append('=');
        sb.append(((this.refID == null)?"<null>":this.refID));
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
        result = ((result* 31)+((this.transactionType == null)? 0 :this.transactionType.hashCode()));
        result = ((result* 31)+((this.subMerchantId == null)? 0 :this.subMerchantId.hashCode()));
        result = ((result* 31)+((this.merchantId == null)? 0 :this.merchantId.hashCode()));
        result = ((result* 31)+((this.umn == null)? 0 :this.umn.hashCode()));
        result = ((result* 31)+((this.bankRRN == null)? 0 :this.bankRRN.hashCode()));
        result = ((result* 31)+((this.terminalId == null)? 0 :this.terminalId.hashCode()));
        result = ((result* 31)+((this.refID == null)? 0 :this.refID.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.transactionDate == null)? 0 :this.transactionDate.hashCode()));
        result = ((result* 31)+((this.merchantTranId == null)? 0 :this.merchantTranId.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof TransactionStatus) == false) {
            return false;
        }
        TransactionStatus rhs = ((TransactionStatus) other);
        return (((((((((((this.transactionType == rhs.transactionType)||((this.transactionType!= null)&&this.transactionType.equals(rhs.transactionType)))&&((this.subMerchantId == rhs.subMerchantId)||((this.subMerchantId!= null)&&this.subMerchantId.equals(rhs.subMerchantId))))&&((this.merchantId == rhs.merchantId)||((this.merchantId!= null)&&this.merchantId.equals(rhs.merchantId))))&&((this.umn == rhs.umn)||((this.umn!= null)&&this.umn.equals(rhs.umn))))&&((this.bankRRN == rhs.bankRRN)||((this.bankRRN!= null)&&this.bankRRN.equals(rhs.bankRRN))))&&((this.terminalId == rhs.terminalId)||((this.terminalId!= null)&&this.terminalId.equals(rhs.terminalId))))&&((this.refID == rhs.refID)||((this.refID!= null)&&this.refID.equals(rhs.refID))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.transactionDate == rhs.transactionDate)||((this.transactionDate!= null)&&this.transactionDate.equals(rhs.transactionDate))))&&((this.merchantTranId == rhs.merchantTranId)||((this.merchantTranId!= null)&&this.merchantTranId.equals(rhs.merchantTranId))));
    }

}
