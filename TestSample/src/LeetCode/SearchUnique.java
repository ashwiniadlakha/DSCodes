/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LeetCode;

import java.util.HashMap;
import java.util.List;

/**
 * @author ashwini.adlakha
 * @version $Id: SearchUnique.java, v 0.1 2020-06-05 9:42 PM ashwini.adlakha Exp $$
 */
public class SearchUnique {

    static int[] getInput(){
        return new int[]{2, 4, 4, 5, 5, 7,7, 9, 9};

    }

    public static void main(String p[]){


        int input[] = getInput();

        int unique = findUnique(input, 0, input.length-1);

        System.out.println(input[unique]);






    }



    public static void updateList(List<Integer> list) {
        int index = conditionMatch(list);
        while(index != -1){
            list.remove(index);
            index = conditionMatch(list);
        }

    }

    private static int conditionMatch(List<Integer> list) {
        for(int i=0;i<list.size();i++){
            if(i>0 && i<list.size()-1 && (list.get(i) < list.get(i-1) &&  list.get(i) < list.get(i+1))){
                return i;
            }
        }
        return -1;
    }

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        HashMap<String, Float> priceMap = getMap(products, productPrices);
        int error = 0;

        for(int i=0;i<productSold.size();i++){
            if(priceMap.get(productSold.get(i)) == null || priceMap.get(productSold.get(i)).floatValue() != soldPrice.get(i).floatValue()){
                error++;
            }
        }

        return error;

    }

    private static HashMap<String, Float> getMap(List<String> products, List<Float> productPrices) {

        HashMap<String, Float> productMap = new HashMap<String, Float>();
        for(int i=0;i<products.size();i++){
            productMap.put(products.get(i), productPrices.get(i));
        }
        return productMap;
    }

    public static String newPassword(String a, String b) {
        char[] achars = a.toCharArray();

        char[] bchars = b.toCharArray();

        int sum = achars.length + bchars.length;

        char[] newPassword = new char[sum];

        int aiter = 0;
        int biter = 0;
        boolean getFromA = true;

        while(aiter < achars.length || biter < bchars.length){
            if(getFromA){
                if(aiter < achars.length) {
                    newPassword[aiter + biter] = achars[aiter];
                    aiter++;
                }
                getFromA = !getFromA;
            }else{
                if(biter <bchars.length){
                    newPassword[aiter + biter] = bchars[biter];
                    biter++;
                }
                getFromA = !getFromA;
            }
        }

        return  String.valueOf(newPassword);



    }


    private static int findUnique(int[] input, int i, int j) {
        if(i > j){
            return -1;
        }

        int mid = (i+j)/2;

        int val = input[mid];

        if((mid+1)< (input.length-1) && input[mid+1] == val ){
            if((mid+1)%2 == 0){
                return findUnique(input, i, mid-1);
            }else{
                return findUnique(input, mid+1, j);
            }
        }

        if(mid-1 > 0 && input[mid-1] == val){
            if((mid)%2 == 0){
                return findUnique(input, i, mid-1);
            }else{
                return findUnique(input, mid+1, j);
            }
        }

        return mid;
    }
}