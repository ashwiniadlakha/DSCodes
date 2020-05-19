/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package HackerEarthQuestions;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * @author ashwini.adlakha
 * @version $Id: PoliceAndTheive.java, v 0.1 2020-04-22 5:47 PM ashwini.adlakha Exp $$
 */

//https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/joker-and-thieves-53e59f4a/
public class PoliceAndTheive {


    public static void main(String a[]){
        Scanner s = new Scanner(System.in);
        String testCases = s.nextLine();
        int cases = getNumber(testCases);
        for(int testIter = 0; testIter<cases; testIter++){
            String NKString = s.nextLine();
            ArrayList<Integer> nkValue = getNumberArray(NKString);
            char[][] policeThiefArray = getArray(nkValue.get(0), s);
            System.out.println(checkThiefsCaught(policeThiefArray, nkValue.get(1), nkValue.get(0)));
        }
        Math.max(1, 2);
    }

    private static char POLICE = 'P';
    private static char THEIF = 'T';

    private static int checkThiefsCaught(char[][] policeThiefArray, Integer maxStep, Integer size) {

        int caughtTheieves = 0;
        boolean[][] visitedTheif = new boolean[size][size];

        /*for(int i=0; i<size;i++){
            for(int j=0; j<size; j++){
                if(policeThiefArray[i][j] == POLICE){
                    if(checkThiefCaughtFromLeft(policeThiefArray, i, j, maxStep, visitedTheif, size)){
                        caughtTheieves++;
                        visitedTheif[i][j] = true;
                    }
                }
            }
        }*/
        int leftTheives = getThiefCaughtFromLeft(policeThiefArray, 0, 0, maxStep, visitedTheif, size, 0, 1);
        int rightTheives = getThiefCaughtFromLeft(policeThiefArray, 0, 0, maxStep, visitedTheif, size, 0, 0);

        if(leftTheives > rightTheives){
            return leftTheives;
        }else
            return rightTheives;
    }

    private static int getThiefCaughtFromLeft(char[][] policeThiefArray, int i, int j, Integer maxStep, boolean[][] visitedTheif, Integer size, int theivesCaught , int direction) {

        if(policeThiefArray[i][j] == POLICE) {
            for (int maxStepIter = 0; maxStepIter <= maxStep; maxStepIter++) {
                if (direction == 1) {

                }

            }
        }else{
            int[] ij = getNextIJ(i,j);
            int leftTheives = getThiefCaughtFromLeft(policeThiefArray, ij[0], ij[1], maxStep, visitedTheif, size, theivesCaught, 1);
            int rightTheives = getThiefCaughtFromLeft(policeThiefArray, ij[0], ij[1], maxStep, visitedTheif, size, theivesCaught, 0);

            if(leftTheives > rightTheives){
                return leftTheives;
            }else
                return rightTheives;
        }
        return 1;
    }

    private static int[] getNextIJ(int i, int j) {
        return new int[0];
    }

    private static boolean foundUnvisitedTheif(char[][] policeThiefArray, int i, int j, boolean[][] visitedTheif, Integer size) {
        if(i<size && j<size && !visitedTheif[i][j] && policeThiefArray[i][j] == THEIF){
            return true;
        }
        return false;
    }

    private static int getNumber(String inputString) {
        String[] inputArray = inputString.split(" ");
        return Integer.parseInt(inputArray[0]);
    }

    private static ArrayList<Integer> getNumberArray(String inputString) {
        String[] inputArray = inputString.split(" ");
        ArrayList<Integer> arrayList  = new ArrayList<Integer>();
        int i= 0;
        for(String input : inputArray){
            arrayList.add(Integer.parseInt(input));
        }
        return arrayList;
    }

    public static char[][] getArray(int size, Scanner s) {

        char[][] policeTheifArray  = new char[size][size];
        for(int i=0; i<size;i++) {
            String arrayValue = s.nextLine();
            char[] ptArray = arrayValue.replaceAll("\\s+", "").toCharArray();
            for(int j=0; j<size; j++){
                policeTheifArray[i][j] = ptArray[j];
            }
        }
        return policeTheifArray;
    }
}