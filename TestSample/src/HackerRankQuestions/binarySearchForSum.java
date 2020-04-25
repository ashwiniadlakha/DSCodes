package HackerRankQuestions;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class binarySearchForSum {

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
            
			if(binarySearch(getSumList(listAr, listAr.size()), 0, listAr.size() - 1) == -1){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}
		}
	}

	private static List<Integer> getSumList(List<Integer> listAr, int length) {
		List<Integer> sumAr = new ArrayList<Integer>();
        int sum = 0;
		for(int val=0;val<length;val++){
			sum = sum + listAr.get(val);
            sumAr.add(sum);
		}
		return sumAr;
	}

    private static int binarySearch(List<Integer> listAr, int min, int max){
        if(min > max){
            return -1;
        }else{
            int mid = (min + max)/2;
            if(listAr.get(mid) * 2 == listAr.get(listAr.size() - 1)){
                return mid;
            }else{
                if(listAr.get(mid) * 2 > listAr.get(listAr.size() - 1)){
                    return binarySearch(listAr, min, mid - 1);
                }else{
                    return binarySearch(listAr, mid + 1, max);
                }
            }
        }
    }
    
	
}