package com.pinelabs.simulator.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "simulator_mandates_table")
public class SimulatorMandatesTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String merchantId;
    private String subMerchantId;
    private String terminalId;
    private String merchantName;
    private String subMerchantName;
    private String amount;
    private String merchantTranId;
    private String billNumber;
    private String requestType;
    private String collectByDate;
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
    private String payerVa;
    private String note;
    private String success;
    private String responseCode;
    private String refId;
    private String umn;
    private String retryCount;
    private String mandateSeqNo;
    private String executionDate;
    private String key;
    private String value;
    private String bankRRN;
    private String responseMessage;
    private String webhookResponseMessage;
    private String webhookResponseCode;
    private String webhookResponseSuccess;
    private String webhookResponseCodeDescription;
    private String webhookResponseStatus;

    @CreationTimestamp
    private LocalDateTime rowCreateTime;
    @UpdateTimestamp
    private LocalDateTime rowUpdateTime;

}
