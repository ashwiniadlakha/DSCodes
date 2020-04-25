package HackerRankQuestions;

public class TotalBstPossible {

	
	public static void main(String[] a){
		System.out.println(getMaxBst(5));
	}

	private static long getMaxBst(long n) {
		if(n==0 | n==1){
			return 1;
		}else{
			long sum = 0;
			for(int i=1 ; i<=n ; i++){
				sum = (long)(sum + (long)getMaxBst(i-1)*getMaxBst(n-i));
			}
			return sum;
		}
	}
	
}
