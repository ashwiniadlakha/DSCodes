/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package AirtelGame;

import java.util.List;
import java.util.Queue;

/**
 * @author ashwini.adlakha
 * @version $Id: RequestPerformer.java, v 0.1 2020-05-06 5:31 PM ashwini.adlakha Exp $$
 */
public class RequestPerformer implements  Runnable{

    Queue<HitRequest> requestQueue;
    List<User> userList;



    public RequestPerformer(Queue<HitRequest> requestQueue, List<User> userList){
        this.requestQueue = requestQueue;
        this.userList = userList;
    }

    @Override
    public void run(){

        while(!requestQueue.isEmpty()) {
            HitRequest request = requestQueue.remove();
            if(!performRequest(request)){
                revertTool(request);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private void revertTool(HitRequest request) {

    }

    private boolean performRequest(HitRequest request) {
        return false;
    }
}