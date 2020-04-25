package HackerRankQuestions;

import java.util.List;

public class Solution {




    public static void main(String a[]){
        int arr[] = { 2, 4, 6, 8, 16 };
        int n = arr.length;
        int gcd = generalizedGCD(n, arr);
        System.out.println("GCD = " + gcd);
        long lcm = (multiplyArray(arr) / gcd);
        System.out.println("LCM = " + lcm);

        int rows = 5;
        int colomns = 4;
        int ROW = rows;
        int COL = colomns;
        List<List<Integer> > original;
        int[][] original2 = {{0,1,1,0,1}, {0,1,0,1,0}, {0,0,0,0,1}, {0,1,0,0,0}};





        boolean[][] visited = new boolean[ROW][COL];
        int numCluster = 0;
        int numDays = 0;


        //fill visited

        while(allNotChecked(original2, ROW, COL)) {
            for (int i = 0; i < ROW; ++i) {
                for (int j = 0; j < COL; ++j) {
                    if (original2[i][j] == 1 && !visited[i][j])
                    {
                        DFS(original2, i, j, visited, ROW, COL);
                        ++numCluster;
                    }
                }
            }
            numDays++;
        }

        System.out.println(numCluster);

    }








    private static boolean allNotChecked(int[][] M, int row, int col) {
        for(int i=0; i<row;i++){
            for(int j=0; j<col;j++){
                if(M[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean isSafe(int[][] M, int row, int col,
                   boolean visited[][], int ROW, int COL)
    {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }


    static boolean needUpdate(int[][] M, int row, int col,
                          boolean visited[][], int ROW, int COL)
    {
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL) && (M[row][col] == 1 && !visited[row][col]);
    }






    static void  DFS(int[][] M, int row, int col, boolean visited[][], int ROW, int COL)
    {

        int rowNbr[] = new int[] { -1, 0, 0, 1 };
        int colNbr[] = new int[] { 0, -1, 1, 0 };

        visited[row][col] = true;

        for (int k = 0; k < 4; ++k) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL)) {
                DFS(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL);
            }
            if (needUpdate(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL)) {
                M[row + rowNbr[k]][col + colNbr[k]] = 1;
            }
        }


    }




    //Function DFS for other clusters
    void dfs(int[][] M , int row, int col, int ROW, int COL, boolean[][] visited){


        int[] rowNbr = new int[]{0,0,1,-1};
        int[] colNbr = new int[]{1,-1,0,0};

        visited[row][col] = true;

        for(int k=0;k<3;k++){
            if(isSafe(M, row+rowNbr[k], col + colNbr[k], ROW, COL, visited)){
                dfs(M, row+rowNbr[k], col + colNbr[k], ROW, COL, visited);
            }
        }


    }



    //Function is safe
    boolean isSafe(int[][] M , int row, int col, int ROW, int COL, boolean[][] visited){


        if(row<ROW && col<COL && !visited[row][col] && M[row][col]==1 && row>=0 && col>=0){
            return true;
        }
        return false;

    }


    // The main function that returns count of islands in a given
    // boolean 2D matrix
    /*int countIslands(int M[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[ROW][COL];

        // Initialize count as 0 and travese through the all cells
        // of given matrix
        int count = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j] == 1 && !visited[i][j]) // If a cell with
                { // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }*/


    private static long multiplyArray(int[] arr) {
        long returnedNum = 1;
        for(int index = 0; index<arr.length; index++){
            returnedNum = returnedNum * arr[index];
        }
        return returnedNum;
    }

    static public int generalizedGCD(int num, int[] arr)
    {
        int result = arr[0];
        for (int i = 1; i < num; i++){
            result = gcd(arr[i], result);

            if(result == 1)
            {
                return 1;
            }
        }

        return result;
    }

    static int gcd(int a, int b)
    {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
