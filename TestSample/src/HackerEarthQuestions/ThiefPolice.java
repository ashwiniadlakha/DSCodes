/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package HackerEarthQuestions;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ashwini.adlakha
 * @version $Id: ThiefPolice.java, v 0.1 2020-05-18 12:19 AM ashwini.adlakha Exp $$
 */

//https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/thief-and-warehouses-6ebf4e07/
public class ThiefPolice {

    private static void calculateMaxValue(ArrayList<Integer> array, int i, int j){
        if(i>j){
            return;
        }else{
            int minIndex = getMin(array, i, j);
            int sum = array.get(minIndex) * (j-i+1);
            maxSum = Math.max(sum, maxSum);
            calculateMaxValue(array, i, minIndex-1);
            calculateMaxValue(array, minIndex+1, j);
        }
    }

    static int getMin(ArrayList<Integer> array, int i, int j){
        int returnIndex = 0;
        int min = 10000000;
        for(int index = i;index <= j ; index ++ ){
            if(min < array.get(index)){
                min = array.get(index);
                returnIndex = index;
            }
        }
        return returnIndex;
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
    static int maxSum = 0;
    private static int getMaxSum(ArrayList<Integer> array){
        maxSum = 0;
        calculateMaxValue(array, 0, array.size() -1);
        return maxSum;
    }

    public static void main(String args[] ) throws Exception {

        Scanner s = new Scanner(System.in);
        String testCases = s.nextLine();
        int cases = getNumber(testCases);
        for(int testIter = 0; testIter<cases; testIter++){
            String NKString = s.nextLine();
            ArrayList<Integer> nkValue = getNumberArray(NKString);
            System.out.println(getMaxSum(nkValue));
        }

    }


}