package com.pinelabs.simulator.util;

import com.pinelabs.simulator.dto.ApiResponse;
import com.pinelabs.simulator.dto.ApiResponseQR;
import com.pinelabs.simulator.dto.MandateRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Random;
import java.util.UUID;

public class SimulatorUtils {
    public static String generateBankRRN() {
        return System.currentTimeMillis()+"";
    }

    public static String generateCompletionDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return LocalDateTime.now().format(dtf);
    }

    public static String generateUMN() {
        String str = UUID.randomUUID().toString();
        return str.replaceAll("-", "z") + "@icici";
    }

    public static String generateQRData(MandateRequest request, ApiResponseQR response) {
        String str = "upi://mandate?" +
                "pa=" + Constants.PAYEE_VPA +
                "&pn=" + "PINE%20LABS%20PRIVATE%20LIMITED" +
                "&tr=" + response.refId +
                "&am=" + response.Amount +
                "&cu=" + "INR" +
                "&orgid=" + "400011" +
                "&mc=" + request.terminalId +
                "&purpose=" + "14" +
                "&tn=" + "Mandate%20Request" +
                "&validitystart=" + "25082023" +
                "&validityend=" + "29082023" +
                "&amrule=" + "MAX" +
                "&recur=" + "DAILY" +
                "&rev=" + "Y" +
                "&share=" + "Y" +
                "&block=" + request.getBlockfund() +
                "&txnType=" + "CREATE" +
                "&mode=" + "13" +
                "&sign=" + "MEUCIQD3psY3g97D38L9ymzvPS2+9sUG1MqcLo7hN2JAzFknQwIgdc1lOVUBTSKzi0BAE6Jb5H86\\r\\nJyiDLVZlSLDm59jeLUs=\\r\\n";
        return str;
    }
}
