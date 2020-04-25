package HackerRankQuestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class TestClass {
    public static void main(String args[] ) throws Exception {
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int m = Integer.parseInt(line);
        line = br.readLine();
        int n = Integer.parseInt(line);
        int[][] matrix = new int[m][n];
        for(int i=0; i<m; i++){
        	line = br.readLine();
        	String[] rowAr = line.split(" ");
        	for(int j=0;j<n; j++){
        		matrix[i][j] = Integer.parseInt(rowAr[j]);
        	}
        }
        System.out.println(biggestRegion(matrix, m, n));
        
    }
    
    
    static long biggestRegion(int M[][], int ROW, int COL)
    {
        //visitedAr
        boolean visited[][] = new boolean[ROW][COL];
 
 
        // Initialize count as 0 and travese through the all cells
        // of given matrix
        long max = 0;
        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j){
                if (M[i][j]==1 && !visited[i][j]) {
                	regionCount = 1;
                    calculateBiggestRegion(M, i, j, visited, ROW, COL);
                    if(max<regionCount){
                    	max = regionCount;
                    }
                }
                    
                }
 
        return max;
    }

    static long regionCount = 0;
    
    static void calculateBiggestRegion(int M[][], int row, int col, boolean visited[][], int ROW, int COL)
    {
        // ups and downs and diagnols
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
 
        // Mark this cell as visited
        visited[row][col] = true;
 
        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k){
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL) )
            {
            	regionCount++;
                calculateBiggestRegion(M, row + rowNbr[k], col + colNbr[k], visited, ROW, COL);
            }
        }
    }
    
    
    
    
    static boolean isSafe(int M[][], int row, int col,boolean visited[][], int ROW, int COL)
	{
	 // row number is in range, column number is in range
	 // and value is 1 and not yet visited
	 return (row >= 0) && (row < ROW) &&
	        (col >= 0) && (col < COL) &&
	        (M[row][col]==1 && !visited[row][col]);
	}
}