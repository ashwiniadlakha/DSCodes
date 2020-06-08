/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ashwini.adlakha
 * @version $Id: RightView.java, v 0.1 2020-06-04 2:10 PM ashwini.adlakha Exp $$
 */
public class RightView {


    static class TreeNode{
        TreeNode left;
        TreeNode right;
        public int val;
    }
    static class TreeNodeLevel{
        public TreeNode node;
        public int level;

        public TreeNodeLevel(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {

        int maxLevelCovered = 0;

        List<Integer> rightView = new ArrayList<Integer>();

        Queue<TreeNodeLevel> queue = new LinkedList<TreeNodeLevel>();

        queue.add(new TreeNodeLevel(root, 1));
        while(!queue.isEmpty()){
            TreeNodeLevel tnl = queue.remove();
            int level = tnl.level;
            if(maxLevelCovered < level){
                rightView.add(tnl.node.val);
                maxLevelCovered = level;
            }
            if(tnl.node.right != null){
                queue.add(new TreeNodeLevel(tnl.node.right, level+1));
            }
            if(tnl.node.left != null){
                queue.add(new TreeNodeLevel(tnl.node.left, level+1));
            }

        }

        return rightView;

    }
}