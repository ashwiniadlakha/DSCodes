/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package HackerRankQuestions;

import java.util.List;

/**
 * @author ashwini.adlakha
 * @version $Id: CrossWord.java, v 0.1 2020-04-26 2:23 PM ashwini.adlakha Exp $$
 */

//https://www.hackerrank.com/challenges/crossword-puzzle/problem
public class CrossWord {

    public static void main(String[] a){


    }

    static String[] crosswordPuzzle(String[] crossword, String words) {

        String[] wordsArray = words.split(";");

        List<String> wordsPlaces = getWordPlaces(crossword);
        return null;

    }

    private static List<String> getWordPlaces(String[] crossword) {
        for(int i=0;i<crossword.length;i++){
            char[] crosswordline = crossword[i].toCharArray();
            for(int j=0; j<crosswordline.length; j++){
                if(crosswordline[j] == '-'){
                    String hgap = getLastHorizontalGap(i, j, crossword);
                    String vgap = getLastVerticalGap(i, j, crossword);
                }
            }
        }
        return null;

    }

    private static String getLastVerticalGap(int i, int j, String[] crossword) {
        String iString = crossword[i];
        return null;
    }

    private static String getLastHorizontalGap(int i, int j, String[] crossword) {
        return null;
    }










}