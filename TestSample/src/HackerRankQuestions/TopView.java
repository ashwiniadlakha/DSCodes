package HackerRankQuestions;// Java program to print top view of Binary tree
import java.util.*;
 
// Class for a tree node
class TreeNode
{
    // Members
    int key;
    TreeNode left, right;
 
    // Constructor
    public TreeNode(int key)
    {
        this.key = key;
        left = right = null;
    }
}
 
// A class to represent a queue item. The queue is used to do Level
// order traversal. Every Queue item contains node and horizontal
// distance of node from root
class QItem
{
   TreeNode node;
   int hd;
   public QItem(TreeNode n, int h)
   {
        node = n;
        hd = h;
   }
}
 
// Class for a Binary HackerRankQuestions.Tree
class Tree
{
    TreeNode root;
 
    // Constructors
    public Tree()  { root = null; }
    public Tree(TreeNode n) { root = n; }
 
    
    public void printVerticalNodes(){
    	if(root == null){
    		return;
    	}
    	String s = "sdfsdf";
    	
    	char c='c';
    
    	s.contains(new StringBuffer(c));
    	StringBuffer buff = new StringBuffer();
    	buff.append(c);
    	
    	
    	TreeSet<Integer> numSet = new TreeSet<Integer>();
    	Map<Integer, List<TreeNode>> treeMap = new HashMap<Integer, List<TreeNode>>();
    	fillMapSet(root, numSet, treeMap, 0);
    	for(int i : numSet){
    		List<TreeNode> nodeList = treeMap.get(i);
    		//System.out.println(i);
    		for(TreeNode node : nodeList){
    			System.out.print(node.key + " ");
    		}
    		System.out.println();
    		
    	}
    	
    }
    
    
    private void fillMapSet(TreeNode root2, TreeSet<Integer> numSet, Map<Integer, List<TreeNode>> treeMap, int i) {
		if(root2 == null){
			return;
		}else{
			numSet.add(i);
			List<TreeNode> nodeList = treeMap.get(i);
			if(nodeList == null){
				nodeList = new ArrayList<TreeNode>();
				nodeList.add(root2);
				treeMap.put(i, nodeList);
			}else{
				nodeList.add(root2);
			}
			
			fillMapSet(root2.left, numSet, treeMap, i-1);
			fillMapSet(root2.right, numSet, treeMap, i+1);
			
		}
		
	}
	// This method prints nodes in top view of binary tree
    public void printTopView()
    {
    	System.out.println();
        // base case
        if (root == null) {  return;  }
 
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
 
        // Create a queue and add root to it
        Queue<QItem> Q = new LinkedList<QItem>();
        Q.add(new QItem(root, 0)); // Horizontal distance of root is 0
 
        // Standard BFS or level order traversal loop
        while (!Q.isEmpty())
        {
            // Remove the front item and get its details
            QItem qi = Q.remove();
            int hd = qi.hd;
            TreeNode n = qi.node;
 
            // If this is the first node at its horizontal distance,
            // then this node is in top view
            if (!set.contains(hd))
            {
                set.add(hd);
                System.out.print(n.key + " ");
            }
 
            // Enqueue left and right children of current node
            if (n.left != null)
                Q.add(new QItem(n.left, hd-1));
            if (n.right != null)
                Q.add(new QItem(n.right, hd+1));
        }
        System.out.println();
    }
}
 
// Driver class to test above methods
public class TopView
{
    public static void main(String[] args)
    {
        /* Create following Binary HackerRankQuestions.Tree
             1
           /  \
          2    3
           \
            4
             \
              5
               \
                6*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        Tree t = new Tree(root);
        System.out.println("Following are nodes in top view of Binary HackerRankQuestions.Tree");
        t.printTopView();
        t.printVerticalNodes();
    }
}