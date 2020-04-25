package HackerRankQuestions;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ListSumPoint {

    public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int nul = Integer.parseInt(s);
		List<List<Integer>> inputList = new ArrayList<List<Integer>>();
		for(int i=0; i<nul;i++){
			List<Integer> arrayList = new ArrayList<Integer>();
			s = in.nextLine();
			int arlength = Integer.parseInt(s);
            s = in.nextLine();
            String[] sAr = s.split(" ");
			for(int j=0;j<arlength;j++){
				arrayList.add(Integer.parseInt(sAr[j]));
			}
			inputList.add(arrayList);
		}
		for(List<Integer> listAr : inputList){
            
			if(binarySearch(listAr, 0, listAr.size() - 1) == -1){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}
		}
	}

	private static long getSumList(List<Integer> listAr, int start, int stop) {
		
        long sum = 0;
		for(int val=start;val<stop;val++){
			sum = (long)(sum + (long)listAr.get(val));
		}
		String value = "asadfas";
		char[] charValue = value.toCharArray();

		char val = charValue[1];
		if(value.indexOf(val) != -1){

		}
		return sum;



	}
    
   
    private static int binarySearch(List<Integer> listAr, int min, int max){
        if(min > max){
            return -1;
        }else{
            int mid = (min + max)/2;
            long minSum = getSumList(listAr,0,mid);
            long maxSum = getSumList(listAr, mid + 1, listAr.size());
            if(minSum == maxSum){
                return mid;
            }else{
                if(minSum > maxSum){
                    return binarySearch(listAr, min, mid - 1);
                }else{
                    return binarySearch(listAr, mid + 1, max);
                }
            }
        }
    }
    
	
}