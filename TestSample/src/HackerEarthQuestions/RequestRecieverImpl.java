/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package HackerEarthQuestions;

/**
 * @author ashwini.adlakha
 * @version $Id: RequestRecieverImpl.java, v 0.1 2020-05-20 4:47 PM ashwini.adlakha Exp $$
 */
public class RequestRecieverImpl implements RequestReciever{


    private static int limit;









    public static void main(String a[]) {


        //Multiple customer
        //solution to use more resourses by a single customer
        //Time


        // Id - Session ID - Unique parameter


        // 10:01 - 10:11 - Key
        //key -  SessionId1 : Count
        //        SessionId2 : Count
        //

        //sessionId : Calculate key

        //Key + SessionId - > do we have a key

        //Limit : 100


        String timeValue = "10:10";
        String sessionId = "abc";

        RequestRecieverImpl requestReciever = new RequestRecieverImpl();

        try {
            for (int i = 0; i < 200; i++) {
                requestReciever.recieveRequest("session1");
                System.out.println(i);
            }
        }catch (Exception e){
            System.out.println("requestBlocked");
        }
        System.out.println("exiting");
    }

    @Override
    public void recieveRequest(String sessionId) throws Exception {

            RateLimiter rateLimiter = new RateLimiter();

            int limit = rateLimiter.getLimit();

            String currentTimeKey = rateLimiter.getKeyValueFromTime(System.currentTimeMillis());

            int countOfPreviousRequests = rateLimiter.getCountOfPreviousRequestsBySession(currentTimeKey, sessionId);

            if (countOfPreviousRequests == 0) {
                rateLimiter.initialiseCountOfTheSession(currentTimeKey, sessionId);
            } else {
                countOfPreviousRequests++;
                if (countOfPreviousRequests >= limit) {
                    blockRequest();
                } else {
                    rateLimiter.setNewCount(currentTimeKey, sessionId, countOfPreviousRequests);
                }
            }


        }

    private void blockRequest() throws Exception {

        System.out.println("requestBlocked");
        throw new Exception("requestBlocked");
    }

}