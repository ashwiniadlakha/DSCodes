package HackerRankQuestions; /**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */

import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

/**
 * @author ashwini.adlakha
 * @version $Id: HackerRankQuestions.TSVReader.java, v 0.1 2020-01-28 11:30 AM ashwini.adlakha Exp $$
 */
public class TSVReader {


    public static void main(String[] args) {
        String tsvFile = "/Users/ashwini/Downloads/APCashierSheet7.tsv";
        parseTsv(tsvFile);
    }

    public static void parseTsv(String fileName){
        TsvParserSettings settings = new TsvParserSettings();
        settings.getFormat().setLineSeparator("\\n");
        TsvParser parser = new TsvParser(settings);
        List<String[]> allRows = parser.parseAll(new File(fileName));

        String commandId = "010012710110000149000PAYTW3IN1685597737";
        int commandItertor = 49306;

        for (int i = 0; i < allRows.size(); i++) {

            String transId = "20200127111212801800168388040354386";
            String originTransId = "20200127111212800110168382510602452";
            String amount = "13467";
            String accountNo = "20070000001363031387";
            String extendInfo = "{\"alipayMerchantId\":\"216820000277875797482\",\"requestType\":\"CAPTURE\",\"productCode\":\"51051000100000000003\",\"totalTxnAmount\":\"5085\",\"userMobile\":\"8003305723\",\"merchantName\":\"UBER\",\"mode\":\"CAPTURE\",\"topupAndPay\":\"false\",\"browserUserAgent\":\"DEFAULT_AGENT\",\"deviceId\":\"8003305723\",\"merchantTransId\":\"9eb27a16a1da34008761710a0afc3a0\",\"paytmMerchantId\":\"YXwYLs51053157209367\",\"PAYTM_USER_ID\":\"302401284\",\"looperExtendInfo\":\"{\\\"callbackUrl\\\":\\\"rmi://pgp-payment-service-srv2.paytm.local:13385/looperCallback\\\",\\\"localCacheKey\\\":\\\"QUERY_CAPTURE_38dff1b6e23a40338f3edafc69f199bapgppaymentservicesrv2\\\"}\"}";
            String  msgId = "802f78d0-9899-4483-9a07-76f1f8ce";


            transId = allRows.get(i)[2];
            originTransId = allRows.get(i)[3];
            amount = allRows.get(i)[4];
            accountNo = allRows.get(i)[7];
            extendInfo = processExtendInfo(allRows.get(i)[9]);
            commandItertor++;


            String curlRequest = "curl -X POST \\\n" +
                    "  https://wallet-preprod.paytm.in/wallet-web/alipayplus/account/command/accounting \\\n" +
                    "  -H 'Content-Type: application/json' \\\n" +
                    "  -d '{\n" +
                    "  \"request\": {\n" +
                    "  \"head\": {\n" +
                    "    \"version\": \"1.1.2\",\n" +
                    "    \"function\": \"alipayplus.account.command.accounting\",\n" +
                    "    \"clientId\": \"PAYTW3IN51\",\n" +
                    "    \"reqTime\": \"2020-01-26T18:46:17+05:30\",\n" +
                    "    \"reqMsgId\": \"" + msgId + String.valueOf(commandItertor) + "\"\n" +
                    "  },\n" +
                    "  \"body\": {\n" +
                    "      \"commandList\": [\n" +
                    "        {\n" +
                    "          \"accountNo\": \"" + accountNo + "\",\n" +
                    "          \"accountingScene\": \"PREAUTH_CAPTURE\",\n" +
                    "          \"amount\": {\n" +
                    "            \"currency\": \"INR\",\n" +
                    "            \"value\": \"" + amount + "\"\n" +
                    "          },\n" +
                    "          \"commandId\": \"" + commandId + String.valueOf(commandItertor) + "\",\n" +
                    "          \"commandTime\": \"2020-01-27T19:27:40+05:30\",\n" +
                    "          \"commandType\": \"DEBIT\",\n" +
                    "          \"innerAssetType\": \"BALANCE\",\n" +
                    "          \"isMigrated\": false,\n" +
                    "          \"paymentId\": \"" + commandId + String.valueOf(commandItertor) + "\",\n" +
                    "          \"referenceTransId\": \"" + originTransId + "\",\n" +
                    "          \"transId\": \"" + transId + "\",\n" +
                    "          \"transTime\": \"2020-01-27T19:27:40+05:30\"\n" +
                    "        }\n" +
                    "      ],\n" +
                    "      \"extendInfo\": \"" + extendInfo + "\"\n" +
                    "    }\n" +
                    "},\n" +
                    "\"signature\": \"c9e4683da23293a990bdcf1182992fd368cc7f63bd2fba77373405c5efb36813\"\n" +
                    "}'";


            System.out.println(curlRequest);
            System.out.println();

        }

    }

    private static String processExtendInfo(String extendInfo) {
        extendInfo =  extendInfo.replaceAll("\"", Matcher.quoteReplacement("\\\""));
        extendInfo =  extendInfo.replaceAll(Matcher.quoteReplacement("\\\\\""), Matcher.quoteReplacement("\\\\\\\""));
        return extendInfo;

    }
}