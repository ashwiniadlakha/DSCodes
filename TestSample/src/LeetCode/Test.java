/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LeetCode;

/**
 * @author ashwini.adlakha
 * @version $Id: Test.java, v 0.1 2020-06-06 9:52 AM ashwini.adlakha Exp $$
 */
public class Test {


    static class ClassRoom{


        // Identity matrix specifying space booked
        // 1 - > Space booked
        // 0 - > Space available
        public int[][] space;



    }

    static class Item{

        public int lenght;
        public int bredth;
    }

    static int maxClassLength = 5;
    static int maxClassBredth = 5;




    public static void main(String [] args) {

        ClassRoom cr = new ClassRoom();
        cr.space = new int[][]{{1, 1, 1, 0, 2},{0, 0, 0, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};

        Item item = new Item();
        item.lenght = 1;
        item.bredth = 4;





        fitItemInClassRoom(cr, item);


        //Print output
        for(int i=0;i<maxClassLength;i++) {
            for (int j = 0; j < maxClassBredth; j++) {
                System.out.print(cr.space[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void fitItemInClassRoom(ClassRoom cr, Item item) {

        for(int i=0;i<maxClassLength;i++){
            for(int j=0;j<maxClassBredth;j++){
                if(cr.space[i][j] == 0){
                    if(fitItem(cr, item, i, j)){
                        return;
                    }
                }
            }
        }

    }

    private static boolean fitItem(ClassRoom cr, Item item, int i, int j) {
        if(!tryHorizontal(cr, item, i, j)){
            return tryVertical(cr, item, i, j);
        }
        return true;
    }

    private static boolean tryVertical(ClassRoom cr, Item item, int i, int j) {
        for(int itemLengthIter =0;itemLengthIter < item.lenght;itemLengthIter++){
            for(int itemBredthIter=0;itemBredthIter < item.bredth;itemBredthIter++){
                if(i+itemBredthIter < maxClassLength && itemLengthIter+j < maxClassBredth && cr.space[i+itemBredthIter][itemLengthIter+j] == 0){

                }else{
                    return false;
                }
            }
        }

        for(int itemLengthIter =0;itemLengthIter < item.lenght;itemLengthIter++) {
            for (int itemBredthIter = 0; itemBredthIter < item.bredth; itemBredthIter++) {
                if(i+itemBredthIter < maxClassLength && itemLengthIter+j < maxClassBredth && cr.space[i+itemBredthIter][itemLengthIter+j] == 0){
                   cr.space[i+itemBredthIter][itemLengthIter+j] = 1;
                }
            }
        }

        return true;
    }

    private static boolean tryHorizontal(ClassRoom cr, Item item, int i, int j) {
        for(int itemLengthIter =0;itemLengthIter < item.lenght;itemLengthIter++){
            for(int itemBredthIter=0;itemBredthIter < item.bredth;itemBredthIter++){
                if(i+itemLengthIter < maxClassLength && itemBredthIter+j < maxClassBredth && cr.space[i+itemLengthIter][itemBredthIter+j] == 0 && cr.space[i+itemLengthIter][itemBredthIter+j] != 2){

                }else{
                    return false;
                }
            }
        }

        for(int itemLengthIter =0;itemLengthIter < item.lenght;itemLengthIter++) {
            for (int itemBredthIter = 0; itemBredthIter < item.bredth; itemBredthIter++) {
                if (i + itemLengthIter < maxClassLength && itemBredthIter + j < maxClassBredth && cr.space[i + itemLengthIter][itemBredthIter + j] == 0) {
                    cr.space[i + itemLengthIter][itemBredthIter + j] = 1;
                }
            }
        }

        return true;
    }


    /**
     *   1 1 1 2 2
     *   0 0 0 2 2
     *   1 1 1 1 1
     *   0 0 0 0 0
     *   0 0 0 0 0
     *
     *   [1, 4],
     *
     *   1 1 1 1 1
     *   0 0 0 1 1
     *   1 1 1 1 1
     *   0 0 0 1 0
     *   0 0 0 0 0
     *
     *
     *   //
     *   1 corner cases edges of the matrix
     *   1 horizontal item
     *   1 vertical item
     *   1 full space ocupying item
     *   1 negative case
     *
     **/


    //

}