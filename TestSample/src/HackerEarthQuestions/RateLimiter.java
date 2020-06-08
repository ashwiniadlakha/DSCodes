/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package HackerEarthQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ashwini.adlakha
 * @version $Id: RateLimiter.java, v 0.1 2020-05-29 8:29 AM ashwini.adlakha Exp $$
 */
public class RateLimiter {

     Map<String, Map<String, Integer>> requestMap = new HashMap<String, Map<String, Integer>>();

    void setNewCount(String currentTimeKey, String sessionId, int countOfPreviousRequests) {
        Map<String, Integer> sessionMapForTimeKey = requestMap.get(currentTimeKey);
        sessionMapForTimeKey.put(sessionId, countOfPreviousRequests);
    }

     void blockRequest() {

        System.out.println("Blocked");
    }


    void initialiseCountOfTheSession(String currentTimeKey, String sessionId) {

        Map<String, Integer> sessionMapForTimeKey = requestMap.get(currentTimeKey);
        if(sessionMapForTimeKey == null) {
            Map<String, Integer> sessionCountMap = new HashMap<String, Integer>();
            sessionCountMap.put(sessionId, 1);
            requestMap.put(currentTimeKey, sessionCountMap);
        }else{
            sessionMapForTimeKey.put(sessionId, 1);

        }

    }

    int getCountOfPreviousRequestsBySession(String currentTimeKey, String sessionId) {

        Map<String, Integer> sessionMapForTimeKey = requestMap.get(currentTimeKey);
        if(sessionMapForTimeKey == null){
            return 0;
        }else{
            Integer sessionCount = sessionMapForTimeKey.get(sessionId);
            if(sessionCount == null){
                return 0;
            }else{
                return sessionCount;
            }
        }

    }

    String getKeyValueFromTime(long timeValue) {
        //Returning Static Value for now
        return "abcd123";
    }


    int getLimit() {
        return 3;
    }



}