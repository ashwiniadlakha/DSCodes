/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LeetCode;

import java.io.StringWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ashwini.adlakha
 * @version $Id: MinimumElement.java, v 0.1 2020-06-04 3:36 PM ashwini.adlakha Exp $$
 */





public class MinimumElement {

    static public int[] getInput(){
        //int[] inputArray = new int[]{1, 1000 , 5};
        int[] inputArray = new int[]{1, 2, 0};
        //[3, 4, -1, 1] - > 2
        // [-2, 6] -> 1
        // [-3, -2] - > 1
        // [1, 2, 0] - > 3
        // [1, 3, 4, 2] - > 5

        return inputArray;
    }

    public static void main(String s[]){

       /* int[] input = getInput();

        Map<Integer, Integer> arrayMap = getArrayMap(input);


        for(int iter = 1; iter <= input.length+1 ; iter++){


            if(arrayMap.get(iter) == null){
                System.out.println(iter);
                break;
            }
        }*/

       StringBuffer number = new StringBuffer("");
       number.append(Long.toBinaryString(100l));
        BigInteger n = new BigInteger("234");

        System.out.println(FindBigNum(100l));

    }


    static long FindBigNum(long n) {
        StringBuffer number = new StringBuffer("");
        for(long i=1;i<=n;i++){
            number.append(Long.toBinaryString(i));
            if(Long.parseLong(number.toString(), 2) > 1000000007l) {
                String modNumber =
                        Long.toBinaryString((new BigInteger(number.toString(), 2).mod(new BigInteger("1000000007")).longValue()));
                number = new StringBuffer(modNumber);
            }
        }
        System.out.println(number.toString());
        return new BigInteger(number.toString(), 2).longValue();






    }

    private static Map<Integer, Integer> getArrayMap(int[] input) {
        Map<Integer, Integer> arrayMap = new HashMap<Integer, Integer>();
        for(int inputNum : input){
            arrayMap.put(inputNum, 1);
        }
        return arrayMap;


    }
}