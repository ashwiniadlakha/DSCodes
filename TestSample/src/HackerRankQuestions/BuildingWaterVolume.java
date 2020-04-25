package HackerRankQuestions;

public class BuildingWaterVolume {

	public static void main(String a[]){
		
		int building[] = {1,2,3,4,5,9,1,2,3,4,5,10,10,11,28,34,1,2,3,4,5,9};
		long sum=0 ;
		int max=0;
		int defMax = 34;
		long sumVerfy = 0;
		for(int i=0; i<building.length; i++){
			if(max < building[i]){
				sum = sum + i * (building[i]-max);
				max = building[i];
			}
			sum = sum + (max - building[i]);
			sumVerfy = sumVerfy + (defMax - building[i]);
		}
		
		System.out.println(sum + "  " + sumVerfy + " " + max);
	}
	
}
