/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package HackerEarthQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author ashwini.adlakha
 * @version $Id: BinarySerachQuestion.java, v 0.1 2020-04-22 12:37 PM ashwini.adlakha Exp $$
 */

//Question : https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/the-soap-mystery/
public class BinarySerachQuestion {


    public static void main(String a[]){
        Scanner s = new Scanner(System.in);
        String numberOfSoapString = s.nextLine();
        int soapNumber = getNumber(numberOfSoapString);
        List<Integer> arrayList  = new ArrayList<Integer>();
        while(arrayList.size() < soapNumber){
            String inputString = s.nextLine();
            arrayList.addAll(getNumberArray(inputString));
        }

        String numQueries = s.nextLine();
        int queryNumber = getNumber(numQueries);
        Collections.sort(arrayList);

        for(int inputIterator = 0; inputIterator<queryNumber; inputIterator++){
            String query = s.nextLine();
            int queryint = getNumber(query);
            System.out.println(getNumberOfSoapUnderThisPrice(arrayList, queryint));
        }
    }

    private static int getNumberOfSoapUnderThisPrice(List<Integer> arrayList, int queryint) {

        int index = searchInList(queryint, arrayList, 0, arrayList.size());
        return  index+1;

    }

    private static int searchInList(int queryint, List<Integer> arrayList, int start, int end) {
        if(start > end){
            return -1;
        }


        int mid = (start + end)/2;

        if(mid < (arrayList.size()-1) && arrayList.get(mid) < queryint && arrayList.get(mid+1) >= queryint){
            return mid;
        }

        if(mid == (arrayList.size()-1) && arrayList.get(mid) < queryint){
            return mid;
        }

        if(arrayList.get(mid) < queryint){
            return searchInList(queryint, arrayList, mid+1, end);
        }else{
            return searchInList(queryint, arrayList,start,  mid-1);
        }

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



    static int[] A;
    static int[] BRep;
    static int sum = 0;
    // Complete the cost function below.
    static int cost(int[] B) {
        A = new int[B.length];
        BRep = B;
        for(int i=0;i<B.length;i++){
            compute(i);
        }
        return sum;
    }

    static void compute(int index){
        for(A[index]=1; A[index]<BRep[index] ; A[index]++){
            if(index == (BRep.length - 1)){
                int sumA = getSum(A);
                if(sum < sumA){
                    sum = sumA;
                }
            }else{
                compute(index+1);
            }
        }


    }

    static int getSum(int[] B){

        if(B.length == 1){
            return B[0];
        }

        int sum = 0;
        for(int i=1;i<B.length;i=i+1){

            sum = sum + Math.abs(B[i] - B[i-1]);

        }
        return sum;
    }


}
