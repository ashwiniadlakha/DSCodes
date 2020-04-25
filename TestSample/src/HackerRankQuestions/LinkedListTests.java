package HackerRankQuestions;

import javax.xml.transform.Templates;

public class LinkedListTests {

	
	static class Node{
		Node next;
		int data;
	}
	
	public static Node start1;
	public static Node end1;
	
	public static void main(String[] args) {
		createListPalindrome();
		printList(start1);
		checkForPalindrome(start1);

	}

	
	static Node tempStart;
	static boolean isPalindrome = true;
	private static void checkForPalindrome(Node start12) {
		tempStart = start12;
		checkIfPalindrome(start12);
		System.out.println(isPalindrome);
	}

	private static void checkIfPalindrome(Node start12) {
		if(start12 != null){
			checkIfPalindrome(start12.next);
			if(tempStart.data != start12.data){
				//System.out.println(tempStart.data + " " + );
				isPalindrome = false;
			}
			tempStart = tempStart.next;
		}
		
	}

	private static void printList(Node start12) {
		if(start12 != null){
			System.out.print(start12.data + " ");
			printList(start12.next);
		}
		
	}

	private static void createListPalindrome() {
		for(int i=0;i<=10;i++){
			if(start1 == null){
				start1 = new Node();
				start1.data = i;
				end1 = start1;
			}else{
				Node temp = new Node();
				temp.data = i;
				end1.next  = temp;
				end1 = temp;
			}
		}
		for(int i=9;i>=0;i--){
			Node temp = new Node();
			temp.data = i;
			end1.next  = temp;
			end1 = temp;
		}
	}

}
