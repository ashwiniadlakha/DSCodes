/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package HackerRankQuestions;

/**
 * @author ashwini.adlakha
 * @version $Id: DPArray.java, v 0.1 2020-04-25 8:48 PM ashwini.adlakha Exp $$
 */
//https://www.hackerrank.com/challenges/sherlock-and-cost/problem
public class DPArray {

    public static void main(String A[]){
        int B[] = new int[]{100, 2, 100, 2, 100};
        int b[] = new int[]{3, 15, 4, 12, 10};
        System.out.println(cost(B));
        System.out.println(cost(b));

    }

    static int[] A;
    static int[] BRep;
    static int sum = 0;

    // Complete the cost function below.
    static int cost(int[] B) {
        A = new int[B.length];
        BRep = new int[B.length];
        BRep = B;
        sum=0;
        for(int i=0;i<B.length;i++){
            compute(i);
        }
        return sum;
    }

    static void compute(int index){
        int AIter=1;
        while(AIter<=BRep[index]){
            A[index] = AIter;
            if(index == (BRep.length - 1)){
                int sumA = getSum(A);
                if(sum < sumA){
                    sum = sumA;
                }
            }else{
                compute(index+1);
            }
            AIter = AIter + 1;
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


    static int[] getReplacementArray(int[] B, int startIndex){

        int[] bnew = new int[B.length];
        if(startIndex == 1){
            bnew[0] = B[0];
        }
        for(int i=startIndex;i<B.length;i=i+2){
            bnew[i] = 1;
            if(i+1 < B.length){
                bnew[i+1] = B[i+1];
            }
        }
        return bnew;
    }
}