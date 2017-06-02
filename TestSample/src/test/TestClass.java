package test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

	public static void main(String args[] ) throws Exception {
		System.out.println("hello");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String line = br.readLine();
	    int m = Integer.parseInt(line);
	    List<List<Integer>> inputList = new ArrayList<List<Integer>>();
	    for(int i=0; i<m; i++){
	    	line = br.readLine();
		    int n = Integer.parseInt(line);
		    line = br.readLine();
	    	String[] rowAr = line.split(" ");
	    	List<Integer> inputAr = new ArrayList<Integer>();
	    	for(int j=0; j<n; j++){
	    		inputAr.add(Integer.parseInt(rowAr[j]));
	    	}
	    	inputList.add(inputAr);
	    }
	   for(List<Integer> input : inputList){
		   System.out.print(getMaxContigiousSum(input) + " ");
		   System.out.print(getMaxNonContigiousSum(input));
		   System.out.println();
	   }
	   
	}

	private static long getMaxNonContigiousSum(List<Integer> input) {
		int max = input.get(0);
		long sum = 0l ;
		for(int num:input){
			if(max < num){
				max = num;
			}
			if(num > 0){
				sum = (long)(sum + (long)num);
			}
		}
		if(sum == 0){
			return max;
		}else{
			return sum;
		}
		
	}

	private static long getMaxContigiousSum(List<Integer> input) {
		int max = input.get(0);
		long max_so_far = 0l, max_ending_here = 0l;
		 
	    for (int i:input)
	    {
	    	if(max < i){
				max = i;
			}
	        max_ending_here = (long)(max_ending_here + (long)i);
	        if (max_ending_here < 0){
	            max_ending_here = 0;
	        }
	        if (max_so_far < max_ending_here){
	            max_so_far = max_ending_here;
	        }
	    }
	    if(max_so_far == 0){
			return max;
		}else{
			return max_so_far;
		}
	    
	}

}