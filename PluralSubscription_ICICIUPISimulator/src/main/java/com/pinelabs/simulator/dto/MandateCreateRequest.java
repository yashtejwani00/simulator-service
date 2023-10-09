package com.pinelabs.simulator.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class MandateCreateRequest {

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getSubMerchantId() {
        return subMerchantId;
    }

    public void setSubMerchantId(String subMerchantId) {
        this.subMerchantId = subMerchantId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getSubMerchantName() {
        return subMerchantName;
    }

    public void setSubMerchantName(String subMerchantName) {
        this.subMerchantName = subMerchantName;
    }

    public String getPayerVa() {
        return payerVa;
    }

    public void setPayerVa(String payerVa) {
        this.payerVa = payerVa;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCollectByDate() {
        return collectByDate;
    }

    public void setCollectByDate(String collectByDate) {
        this.collectByDate = collectByDate;
    }

    public String getMerchantTranId() {
        return merchantTranId;
    }

    public void setMerchantTranId(String merchantTranId) {
        this.merchantTranId = merchantTranId;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getValidityStartDate() {
        return validityStartDate;
    }

    public void setValidityStartDate(String validityStartDate) {
        this.validityStartDate = validityStartDate;
    }

    public String getValidityEndDate() {
        return validityEndDate;
    }

    public void setValidityEndDate(String validityEndDate) {
        this.validityEndDate = validityEndDate;
    }

    public String getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(String amountLimit) {
        this.amountLimit = amountLimit;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAutoExecute() {
        return autoExecute;
    }

    public void setAutoExecute(String autoExecute) {
        this.autoExecute = autoExecute;
    }

    public String getDebitDay() {
        return debitDay;
    }

    public void setDebitDay(String debitDay) {
        this.debitDay = debitDay;
    }

    public String getDebitRule() {
        return debitRule;
    }

    public void setDebitRule(String debitRule) {
        this.debitRule = debitRule;
    }

    public String getRevokable() {
        return revokable;
    }

    public void setRevokable(String revokable) {
        this.revokable = revokable;
    }

    public String getBlockfund() {
        return blockfund;
    }

    public void setBlockfund(String blockfund) {
        this.blockfund = blockfund;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getUMN() {
        return UMN;
    }

    public void setUMN(String UMN) {
        this.UMN = UMN;
    }

    private String merchantId;

    private String subMerchantId;

    private String terminalId;

    private String merchantName;

    private String subMerchantName;

    private String payerVa;

    private String amount;

    private String note;

    private String collectByDate;

    private String merchantTranId;

    private String billNumber;

    private String requestType;

    private String validityStartDate;

    private String validityEndDate;

    private String amountLimit;

    private String frequency;

    private String remark;

    private String autoExecute;

    private String debitDay;

    private String debitRule;

    private String revokable;

    private String blockfund;

    private String purpose;

    private String UMN;

}
