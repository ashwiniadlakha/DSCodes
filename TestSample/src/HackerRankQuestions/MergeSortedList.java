package HackerRankQuestions;

public class MergeSortedList {

	static class Node {
			public int data;
			public Node next;
	}
	
	Node MergeLists(Node headA, Node headB) {
		Node start, temp, temp2;
	    if(headA != null && headB != null && headA.data > headB.data){
	        start = headB;
	        temp = headB;
	        temp2 = headA;
	    }else{
	        start = headA;
	        temp = headA;
	        temp2 = headB;
	    }
	    if(start == null){
	        if(headA==null){
	            return headB;
	        }else{
	            return headA;
	        }
	    }
	    while(temp != null && temp2 !=null){
	        if(temp.next != null && temp.next.data > temp2.data){
	            Node temp3 = temp.next;
	            temp.next = temp2;
	            temp2 = temp2.next;
	            temp = temp.next;
	            temp.next = temp3;
	        }else if(temp.next == null){
	            temp.next = temp2;
	            break;
	        }else{
	            temp = temp.next;
	        }
	    }
	    return start;
	}
}
