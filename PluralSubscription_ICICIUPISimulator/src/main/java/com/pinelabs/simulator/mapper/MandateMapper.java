package com.pinelabs.simulator.mapper;

import com.pinelabs.simulator.dto.ApiResponse;
import com.pinelabs.simulator.dto.MandateRequest;
import com.pinelabs.simulator.entity.SimulatorMandatesTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MandateMapper {

    @Mapping(target = "merchantId", source = "request.merchantId")
    @Mapping(target = "subMerchantId", source = "request.subMerchantId")
    @Mapping(target = "terminalId", source = "request.terminalId")
    @Mapping(target = "merchantName", source = "request.merchantName")
    @Mapping(target = "subMerchantName", source = "request.subMerchantName")
    @Mapping(target = "amount", source = "request.amount")
    @Mapping(target = "merchantTranId", source = "request.merchantTranId")
    @Mapping(target = "billNumber", source = "request.billNumber")
    @Mapping(target = "requestType", source = "request.requestType")
    @Mapping(target = "collectByDate", source = "request.collectByDate")
    @Mapping(target = "validityStartDate", source = "request.validityStartDate")
    @Mapping(target = "validityEndDate", source = "request.validityEndDate")
    @Mapping(target = "amountLimit", source = "request.amountLimit")
    @Mapping(target = "frequency", source = "request.frequency")
    @Mapping(target = "remark", source = "request.remark")
    @Mapping(target = "autoExecute", source = "request.autoExecute")
    @Mapping(target = "debitDay", source = "request.debitDay")
    @Mapping(target = "debitRule", source = "request.debitRule")
    @Mapping(target = "revokable", source = "request.revokable")
    @Mapping(target = "blockfund", source = "request.blockfund")
    @Mapping(target = "purpose", source = "request.purpose")
    @Mapping(target = "umn", source = "request.Umn")
    @Mapping(target = "payerVa", source = "request.payerVa")
    @Mapping(target = "note", source = "request.note")
    @Mapping(target = "bankRRN", source = "response.BankRRN")
    @Mapping(target = "responseCode", source = "response.response")
    @Mapping(target = "success", source = "response.success")
    @Mapping(target = "responseMessage", source = "response.message")
    SimulatorMandatesTable mapSimulatorMandatesTable(MandateRequest request, ApiResponse response);
}
