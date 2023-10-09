package com.pinelabs.simulator.dto;


import com.fasterxml.jackson.annotation.JsonProperty;


public class EncryptedRequest {
    @JsonProperty("requestId")
    String requestId;
    @JsonProperty("service")
    String service;

    @JsonProperty("encryptedKey")
    String encryptedKey;
    @JsonProperty("oaepHashingAlgorithm")
    String oaepHashingAlgorithm;

    @JsonProperty("iv")
    String iv;
    @JsonProperty("encryptedData")
    String encryptedData;

    @JsonProperty("clientInfo")
    String clientInfo;

    @JsonProperty("optionalParam")
    String optionalParam;


    public String getOptionalParam() {
        return this.optionalParam;
    }

    public void setOptionalParam(String optionalParam) {
        this.optionalParam = optionalParam;
    }

    public String getClientInfo() {
        return this.clientInfo;
    }

    public void setClientInfo(String clientInfo) {
        this.clientInfo = clientInfo;
    }

    public String getEncryptedKey() {
        return encryptedKey;
    }

    public void setEncryptedKey(String encryptedKey) {
        this.encryptedKey = encryptedKey;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getOaepHashingAlgorithm() {
        return this.oaepHashingAlgorithm;
    }

    public void setOaepHashingAlgorithm(String oaepHashingAlgorithm) {
        this.oaepHashingAlgorithm = oaepHashingAlgorithm;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
