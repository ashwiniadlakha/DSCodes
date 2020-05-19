/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package HackerRankQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @author ashwini.adlakha
 * @version $Id: SuperDigit.java, v 0.1 2020-04-26 3:20 PM ashwini.adlakha Exp $$
 */

//https://www.hackerrank.com/challenges/recursive-digit-sum/problem
public class SuperDigit {

    public static void main(String[] a){
        //System.out.println(superDigit("123", 3));

        SuperDigit superDigit = new SuperDigit();
        List<String> list = new ArrayList<String>();

        list.add("is");
        list.add("are");
        list.add("a");
        List<String> listString = superDigit.retrieveMostFrequentlyUsedWords("rose is a flower red rose are flower", list);
        for(String val : listString){
            System.out.println(val);
        }
    }

    static int superDigit(String n, int k) {

        char[] numberChar = n.toCharArray();
        int sum =0;
        for(int i=0;i<n.length();i++){
            if( i!= n.length()-1 ) {
                sum = sum + Integer.parseInt(n.substring(i, i + 1));
            }else{
                sum = sum + Integer.parseInt(n.substring(i));
            }
        }
        sum = sum*k;
        if(sum / 10 != 0){
            return superDigit(String.valueOf(sum), 1);
        }else{
            return sum;
        }
    }


    static class LogLine implements Comparable<LogLine>{
        public String identifier;
        public String value;
        public String originalString;


        @Override
        public int compareTo(LogLine o) {
            if(this.value.compareTo(o.value) == 0){
                return this.identifier.compareTo(o.identifier);
            }else{
                return this.value.compareTo(o.value);
            }
        }
    }


    public List<String> reorderLines(int logFileSize, List<String> logLines)
    {
        List<String> numberLogLines = new ArrayList<String>();
        List<LogLine> stringLogLines = new ArrayList<LogLine>();
        List<String> orderedLogLines = new ArrayList<String>();
        for(String logline : logLines){
            if(checkifnumberString(logline)){
                numberLogLines.add(logline);
            }else{
                stringLogLines.add(getStringLogLine(logline));
            }
            Collections.sort(stringLogLines);
            orderedLogLines = orderedLines(stringLogLines, numberLogLines);
        }
        return orderedLogLines;
    }

    private List<String> orderedLines(List<LogLine> stringLogLines, List<String> numberLogLines) {

        List<String> orderedLogLines = new ArrayList<String>();
        for(LogLine logLine : stringLogLines){
            orderedLogLines.add(logLine.originalString);
        }
        orderedLogLines.addAll(numberLogLines);
        return orderedLogLines;
    }

    private LogLine getStringLogLine(String logline) {
        LogLine logLineObj = new LogLine();
        String[] loglineSeperated = logline.split("\\s+");
        logLineObj.identifier = loglineSeperated[0];
        logLineObj.originalString = logline;
        logLineObj.value = getLogValue(loglineSeperated);
        return logLineObj;
    }

    private String getLogValue(String[] loglineSeperated) {
        String logVal="";
        for(int i=1;i<loglineSeperated.length;i++){
            logVal = logVal.concat(loglineSeperated[i]);
        }
        return logVal;
    }

    private boolean checkifnumberString(String logline) {
        String[] loglineSeperated = logline.split("\\s+");
        if(Character.isDigit(loglineSeperated[1].charAt(0))){
            return true;
        }else{
            return false;
        }
    }









    List<String> retrieveMostFrequentlyUsedWords(String helpText,
                                                 List<String> wordsToExclude) {


        HashMap<String , String> ignoreStrings = getIgnoreStringsMap(wordsToExclude);
        String[] helpTextList = helpText.split("[^A-Za-z0-9-]");
        HashMap<String , Integer> testCountMap = new HashMap<String, Integer>();
        for(String test : helpTextList){
            if(ignoreStrings.get(test) != null){

            }else{
                if(testCountMap.get(test.toLowerCase()) !=null){
                    addToMap(testCountMap, test.toLowerCase());
                }else{
                    addAndInitialize(testCountMap, test.toLowerCase());
                }
            }
        }
        return getMaxOccuringString(testCountMap);

    }

    private List<String> getMaxOccuringString(HashMap<String, Integer> testCountMap) {
        String key = getKeyWithMaxCount(testCountMap);
        return getListOfKeys(testCountMap, key);
    }

    private List<String> getListOfKeys(HashMap<String, Integer> testCountMap, String key) {

        List<String> keyList = new ArrayList<String>();
        Integer sum = testCountMap.get(key);
        Set<String> keySet = testCountMap.keySet();
        for(String log : keySet){

            if(sum == testCountMap.get(log)){

                keyList.add(log);
            }
        }
        return keyList;

    }

    private String getKeyWithMaxCount(HashMap<String, Integer> testCountMap) {
        Set<String> keySet = testCountMap.keySet();
        String key = "";
        Integer max = 0;

        for(String logText : keySet){
            if(key.equals("")){
                key = logText;
            }
            if(max < testCountMap.get(logText)){
                max = testCountMap.get(logText);
                key = logText;
            }
        }
        return key;
    }

    private void addToMap(HashMap<String, Integer> testCountMap, String test) {
        Integer count = testCountMap.get(test);
        count++;
        testCountMap.put(test, count);
    }

    private void addAndInitialize(HashMap<String, Integer> testCountMap, String test) {
        testCountMap.put(test, 1);
    }



    private HashMap<String, String> getIgnoreStringsMap(List<String> wordsToExclude) {
        HashMap<String , String> wordsToExcludeMap = new HashMap<String, String>();
        for(String excludeWord : wordsToExclude){
            wordsToExcludeMap.put(excludeWord, excludeWord);
        }
        return wordsToExcludeMap;
    }

}