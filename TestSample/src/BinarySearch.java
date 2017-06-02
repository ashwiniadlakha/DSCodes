
public class BinarySearch {

	
	public static void main(String[] a){
		int ar[] = {2, 4, 6, 8, 9, 20, 27, 35};
		int index = binarySearch(ar, 0, ar.length, 10);
		System.out.println("index of searched : " + index + " value : " + ar[index]);
	}

	private static int binarySearch(int[] ar, int min, int max, int value) {
		if(min > max){
			return -1;
		}else{
			int mid = (min+max)/2;
			if(ar[mid]==value){
				return mid;
			}else{
				if(ar[mid]>value){
					return binarySearch(ar, min, mid - 1, value);
				}else{
					return binarySearch(ar, mid + 1, max, value);
				}
			}
		}
	}
}
