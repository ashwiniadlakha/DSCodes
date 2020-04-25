package HackerRankQuestions;

public class SegmentedTree {

	
	public static void main(String[] a){
		int[] ar = {2,4,3,1,34,23,5,10};
		NodeA segmentedTreeRoot= createSegmentedTree(ar, 0, ar.length-1);
		traverseTree(segmentedTreeRoot);
		
	}

	private static void traverseTree(NodeA NodeA) {
		if(NodeA == null){
			return;
		}
		System.out.println("range : " + NodeA.start + " to" + NodeA.end);
		System.out.println("value : " + NodeA.value);
		traverseTree(NodeA.left);
		traverseTree(NodeA.right);
		
	}

	private static NodeA createSegmentedTree(int[] ar, int start, int end) {
		//System.out.println("start : " + start + "end " + end);
		if(start == end){
			NodeA node = new NodeA();
			node.value = ar[start];
			node.left = null;
			node.right = null;
			node.start = start;
			node.end = end;
			return node;
		}
		
		int mid = (end+start)/2;
		NodeA left = createSegmentedTree(ar, start, mid);
		NodeA right = createSegmentedTree(ar, mid+1, end);
		
		NodeA NodeA = new NodeA();
		NodeA.value = left.value + right.value;
		NodeA.left = left;
		NodeA.right = right;
		NodeA.start = start;
		NodeA.end = end;
		return NodeA;
		
	}

	
	
}

class NodeA {
	NodeA left;
	NodeA right;
	int start;
	int end;
	int value;
}
