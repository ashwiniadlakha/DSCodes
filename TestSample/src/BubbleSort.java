import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BubbleSort {

	public static void main(String[] ar){
		int[] a = {4, 5, 1, 4, 2, 9, 10, 3, 56, 98, 1, 3};
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length;j++){
				if(a[i] > a[j]){
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
		System.out.println("sorted list:" + Arrays.toString(a));
		boolean even = false;
		List<Integer> evenList = new ArrayList<Integer>();
		List<Integer> oddList = new ArrayList<Integer>();
		for(int i=1;i<a.length;i++){
			if(a[i] == a[i-1]){
				even = !even;
			}else{
				if(even){
					evenList.add(a[i-1]);
				}else{
					oddList.add(a[i-1]);
				}
				even = false;
			}
		}
		System.out.println("even list : " + Arrays.toString(evenList.toArray()));
		System.out.println("odd list : " + Arrays.toString(oddList.toArray()));
	}
	
}
