/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package AirtelGame;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ashwini.adlakha
 * @version $Id: HitUserWithHoliToolGame.java, v 0.1 2020-05-06 4:59 PM ashwini.adlakha Exp $$
 */
public class HitUserWithHoliToolGame {


    Queue<HitRequest> requestQueue = new ArrayDeque<HitRequest>();
    List<User> userList;


    public static void main(String a[]){

        HitUserWithHoliToolGame hitUserWithHoliToolGame = new HitUserWithHoliToolGame();

        hitUserWithHoliToolGame.fillUserList();

        Stack<Integer> newYearQueueStack = new Stack<Integer>();



    }

    void fillUserList(){

        List<User> userList = new ArrayList<User>();
        for(int i=0;i<10;i++){
            List<HoliTool> holiTools = getHoliToolList();
            User user = new User(i, 100, holiTools);
            userList.add(user);
        }
        this.userList = userList;
    }

    public List<HoliTool> getHoliToolList() {

        List<HoliTool> holiTools = new ArrayList<HoliTool>();
        holiTools.add(HoliTool.Water_Bucket);
        holiTools.add(HoliTool.Balloon);
        holiTools.add(HoliTool.Sweets);

        return holiTools;
    }

}