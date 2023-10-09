package com.pinelabs.simulator.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinelabs.simulator.dto.EncryptedRequest;
import com.pinelabs.simulator.service.MandateService;
import com.pinelabs.simulator.service.ExecuteMandateService;
import com.pinelabs.simulator.service.PreDebitNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SimulatorController {
    @Autowired
    MandateService mandateService;
    @Autowired
    ExecuteMandateService executeMandateService;
    @Autowired
    PreDebitNotificationService preDebitNotificationService;
    @Autowired
    ObjectMapper objectMapper;

    private final Logger logger= LoggerFactory.getLogger(SimulatorController.class);

    @RequestMapping(
            value = "/api/MerchantAPI/UPI2/v1/CreateMandate",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody EncryptedRequest createMandate(@RequestBody String request) throws Exception {
        return mandateService.handleMandateApi(request);
    }
    @RequestMapping(
            value = "/api/MerchantAPI/UPI2/v1/MandateQR",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody EncryptedRequest createMandateQR(@RequestBody String request) throws Exception{
        return mandateService.createMandateQR(request);
    }

    @RequestMapping(
            value = "/api/MerchantAPI/UPI2/v1/ExecuteMandate",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody EncryptedRequest executeMandate(@RequestBody String request) throws Exception {
        return executeMandateService.executeMandate(request);
    }


    @RequestMapping(
            value = "/api/MerchantAPI/UPI2/v1/MandateNotification",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody EncryptedRequest mandateNotification(@RequestBody String request) throws Exception {
        return preDebitNotificationService.preDebitNotification(request);
    }


    @RequestMapping(
            value = "/api/MerchantAPI/UPI2/v1/TransactionStatus",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody EncryptedRequest getTransactionStatus(@RequestBody EncryptedRequest request) throws Exception {
//        return createMandateService.getTransactionStatus(request);
        return null;
    }


    @RequestMapping(
            value = "/api/MerchantAPI/UPI2/v1/TransactionStatusByCriteria",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody EncryptedRequest getTransactionStatusByCriteria(@RequestBody String request) throws Exception {
//        return createMandateService.getTransactionStatusByCriteria(request);
        return null;
    }
}
