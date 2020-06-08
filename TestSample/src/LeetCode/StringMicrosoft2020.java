/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LeetCode;

import java.util.List;

/**
 * @author ashwini.adlakha
 * @version $Id: StringMicrosoft2020.java, v 0.1 2020-06-03 9:00 PM ashwini.adlakha Exp $$
 */

//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/submissions/
public class StringMicrosoft2020 {


        int result = 0;

        public int maxLength(List<String> arr) {

            getMaxUniqueCount(arr,  0 , "");
            return result;

        }

        void getMaxUniqueCount(List<String> arr, int index, String resultString){


            if(index == arr.size() && getUniqueStringCount(resultString) > result){
                result = resultString.length();
                return;
            }

            if(index == arr.size()){
                return;
            }

            getMaxUniqueCount(arr, index+1, resultString);
            getMaxUniqueCount(arr, index+1, resultString+arr.get(index));

        }

        int getUniqueStringCount(String val){

            char[] valArray = val.toCharArray();
            char[] uniqueCount = new char[26];
            for(char c : valArray){
                if(uniqueCount[(c-'a')] == 0){
                    uniqueCount[(c-'a')] = 1;
                }else{
                    return -1;
                }
            }

            return val.length();

        }


}