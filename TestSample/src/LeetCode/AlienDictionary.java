/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LeetCode;

/**
 * @author ashwini.adlakha
 * @version $Id: AlienDictionary.java, v 0.1 2020-06-03 9:00 PM ashwini.adlakha Exp $$
 */

//https://leetcode.com/problems/verifying-an-alien-dictionary/
public class AlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = getOrderArray(order);

        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                String iWord = words[i];
                String jWord = words[j];
                int k = Math.min(iWord.length(), jWord.length());
                for(int l=0;l<=k;l++){

                    if(l==k){
                        if(jWord.length() < iWord.length()){
                            return false;
                        }
                    }else{
                        char ikChar = iWord.charAt(l);
                        char jkChar = jWord.charAt(l);

                        if(orderArray[(ikChar - 'a')] < orderArray[( jkChar - 'a')]){
                            break;
                        }

                        if(orderArray[(ikChar - 'a')] > orderArray[( jkChar - 'a')]){
                            return false;
                        }
                    }

                }
            }
        }


        String input;


        return true;

    }

    public int[] getOrderArray(String order){
        int[] orderArray = new int[26];
        char[] orderChars = order.toCharArray();
        for(int i=0;i<=26;i++){
            orderArray[(orderChars[i] - 'a')] = i;
        }
        return orderArray;
    }
}