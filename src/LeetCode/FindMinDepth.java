package LeetCode;

import java.util.LinkedList;
import java.util.Queue;
/*
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class FindMinDepth {
    public int run(TreeNode root){

        //非递归方法
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int depth = 0;
        Queue<TreeNode> quene = new LinkedList<>();
        quene.offer(root);
        while (!quene.isEmpty()){
            int len = quene.size();
            depth++;
            for (int i = 0;i < len;i++){
                TreeNode cur = quene.poll();
                if (cur.left==null && cur.right == null)
                    return depth;
                if (cur.left!=null)
                    quene.offer(cur.left);
                if (cur.right != null)
                    quene.offer(cur.right);
            }
        }
        return 0;

        //递归方法
        /*
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left==null && root.right ==null)
            return Math.max(run(root.left),run(root.right))+1;
        return Math.min(run(root.left),run(root.right))+1;
        */
    }
}
