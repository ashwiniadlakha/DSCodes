/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package HackerEarthQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author ashwini.adlakha
 * @version $Id: ArraysQuestion.java, v 0.1 2020-04-21 1:07 PM ashwini.adlakha Exp $$
 */

//Question : https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/range-query-2/

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class ArraysQuestion {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        Scanner s = new Scanner(System.in);
        String NQString = s.nextLine();

        int[] NAndQ  = getNumbers(NQString);
        StringBuilder inputStringBuilder = new StringBuilder();
        while(inputStringBuilder.length() < NAndQ[0]){
            String inputString = s.nextLine();
            inputString = inputString.replaceAll("\\s+", "");
            inputStringBuilder.append(inputString);
        }

        for(long QIter=0; QIter<NAndQ[1]; QIter++) {

            String query = s.nextLine();

            List<List<String>> list = new ArrayList<>();
            inputStringBuilder = applyQueryToInput(query, inputStringBuilder);

        }









    }

    private static StringBuilder applyQueryToInput(String query, StringBuilder inputBits) {
        String type = getTypeOfQuery(query);
        if (type.equals("FLIP")) {
            String[] inputArray = query.split(" ");
            int lengthToFlip = Integer.parseInt(inputArray[1]);
            char bitAtChar = inputBits.charAt(lengthToFlip - 1);
            if(bitAtChar=='0'){
                inputBits.setCharAt(lengthToFlip-1, '1');
            }else{
                inputBits.setCharAt(lengthToFlip-1, '0');
            }
        }
        else {
            String[] inputArray = query.split(" ");
            int oddEvenBit = Integer.parseInt(inputArray[2]);
            if(inputBits.charAt(oddEvenBit-1) == '0'){
                System.out.println("EVEN");
            }else{
                System.out.println("ODD");
            }
        }
        return inputBits;
    }

    private static String getTypeOfQuery(String query) {
        if(query.charAt(0) == '1'){
            return "FLIP";
        }else{
            return "PRINT";
        }
    }

    private static int[] getNumbers(String inputString) {
        String[] inputArray = inputString.split(" ");
        return new int[]{Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1])};
    }














    private static String DEFENDER = "DEFENDER";
    private static String STRIKER = "STRIKER";
    private static String SELECT = "SELECT";
    private static String REJECT = "REJECT";



    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {

        List<List<String>> applicantList = assignRoles(applications);
        return applicantList;
    }

    public static List<List<String>> assignRoles(List<List<String>> applications){

        PlayerList playerList = getPlayerStatus(applications);
        int playerNeeded = 0;
        if(playerList.Dlist.size() < playerList.Slist.size()){
            playerNeeded = playerList.Dlist.size();
        }else{
            playerNeeded = playerList.Slist.size();
        }

        return getPlayerList(playerList, playerNeeded, applications);
    }

    private static List<List<String>> getPlayerList(PlayerList playerList, int playerNeeded, List<List<String>> applications) {
        List<List<String>> list = new ArrayList<>();

        Collections.sort(playerList.Dlist);
        playerList.Dlist = shortListDPlayers(playerList.Dlist, playerNeeded);


        Collections.sort(playerList.Slist);
        playerList.Slist = shortListSPlayers(playerList.Slist, playerNeeded);

        Map<String, String> Dmap = getDMap(playerList.Dlist);
        Map<String, String> Smap = getSMap(playerList.Slist);


        for(List<String> player : applications){
            List<String> slPlayer = new ArrayList<String>();
            System.out.println(player.get(0));
            System.out.println(player.get(1));
            System.out.println(player.get(2));
            System.out.println(player.get(3));
            System.out.println(player.get(4));
            if(Dmap.get(player.get(0)) != null){

                slPlayer.add(player.get(0));
                slPlayer.add(SELECT);
                slPlayer.add(DEFENDER);
            }else if(Smap.get(player.get(0)) != null){

                slPlayer.add(player.get(0));
                slPlayer.add(SELECT);
                slPlayer.add(STRIKER);
            }else{

                slPlayer.add(player.get(0));
                slPlayer.add(REJECT);
                slPlayer.add("NA");
            }
            list.add(slPlayer);
        }
        return list;
    }

    private static ArrayList<Striker> shortListSPlayers(ArrayList<Striker> slist, int playerNeeded) {
        ArrayList<Striker> ssList = new ArrayList<Striker>();
        for(int i=0; i<playerNeeded;i++){
            ssList.add(slist.get(i));
        }
        return ssList;
    }

    private static ArrayList<Defender> shortListDPlayers(ArrayList<Defender> dlist, int playerNeeded) {
        ArrayList<Defender> ddList = new ArrayList<Defender>();
        for(int i=0; i<playerNeeded;i++){
            ddList.add(dlist.get(i));
        }
        return ddList;
    }

    private static Map<String, String> getSMap(ArrayList<Striker> slist) {

        HashMap<String , String>  Smap = new HashMap<String , String>();
        for(Striker s : slist){
            Smap.put(s.name, s.name);
        }
        return Smap;
    }

    private static Map<String, String> getDMap(ArrayList<Defender> dlist) {

        HashMap<String , String>  Dmap = new HashMap<String , String>();
        for(Defender s : dlist){
            Dmap.put(s.name, s.name);
        }
        return Dmap;


    }


    static class Striker implements Comparable<Striker> {

        public String name;

        public int value;


        @Override
        public int compareTo(Striker o) {
            return this.value-o.value;
        }
    }

    static class Defender implements Comparable<Defender>{

        public String name;

        public int value;


        @Override
        public int compareTo(Defender o) {
            return this.value - o.value;
        }
    }

    static public class PlayerList{

        public ArrayList<Defender> Dlist;
        public ArrayList<Striker> Slist;
    }

    public static PlayerList getPlayerStatus(List<List<String>> players){
        ArrayList<Defender> DList = new ArrayList<Defender>();
        ArrayList<Striker> Slist = new ArrayList<Striker>();
        //Check Fitness factor and accept or reject
        for(List<String> player : players) {
            if (Float.parseFloat(player.get(1)) >= 5.8 && Integer.parseInt(player.get(2)) <= 23) {
                //Check for striker or defender
                if (Integer.parseInt(player.get(3)) >= 50 || Integer.parseInt(player.get(4)) >= 30) {

                    if (Integer.parseInt(player.get(3)) >= 50) {
                        Striker s = new Striker();
                        s.name = player.get(0);
                        s.value = Integer.parseInt(player.get(3)) - 50;
                        Slist.add(s);
                    }

                    if (Integer.parseInt(player.get(4)) >= 30) {
                        Defender d = new Defender();
                        d.name = player.get(0);
                        d.value = Integer.parseInt(player.get(4)) - 30;
                        DList.add(d);
                    }
                }
            }
        }
        PlayerList playerList = new PlayerList();
        playerList.Dlist = DList;
        playerList.Slist = Slist;
        return playerList;
    }

}