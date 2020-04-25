package HackerRankQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestInput {

	
	public static void main(String[] a){
		System.out.println("hello");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int nul = Integer.parseInt(s);
		List<String> inputList = new ArrayList<>();
		for(int i=0; i<nul;i++){
			inputList.add(in.nextLine());
		}
		in = new Scanner(System.in);
		nul = Integer.parseInt(s);
		List<String> queryList = new ArrayList<>();
		for(int i=0; i<nul;i++){
			queryList.add(in.nextLine());
		}
		for(String query:queryList){
			int num = inputList.size();
			int queryNum = 0;
			for(int i=0;i<num;i++){
				Map<String, String> result = found(inputList.get(i), query);
				queryNum+=Integer.parseInt(result.get("resultNum"));
				inputList.remove(i);
				inputList.add(i, result.get("resultString"));
			}
			System.out.println(queryNum);
		}
	}

	private static Map<String, String> found(String input, String query) {
		Map<String, String> result = new HashMap<String, String>();
		char[] inputChar = input.toCharArray();
		char[] queryChar = query.toCharArray();
		int match = 0;
		List<Integer> indexList = new ArrayList<Integer>();
		for(int i=0;i<inputChar.length;i++){
			if(inputChar[i]==queryChar[0]){
				int j=1;
				for(j=1;j<queryChar.length;j++){
					if(i+j+1 > inputChar.length || inputChar[i+j] != queryChar[j]){
						break;
					}
				}
				if(j == queryChar.length-1){
					match++;
					indexList.add(i);
				}
			}
		}
		input.replaceAll(query, "");
		result.put("resultNum", String.valueOf(match));
		result.put("resultString", input);
		return result;
	}

}
