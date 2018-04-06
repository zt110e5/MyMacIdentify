/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树:平衡二叉搜索树又被称为AVL树,且具有以下性质：
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树，
 * 同时，平衡二叉树必定是二叉搜索树，反之则不一定。
 * 采用后序遍历的方法，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次
 */

public class IsBalanced_Solution {
    private boolean isBalance = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        getDepth(root);
        return isBalance;
    }


    //获取树深度方法
    private int getDepth(TreeNode root){
        if (root == null)
            return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1)
            isBalance = false;
        return right > left ? right + 1 : left + 1;
    }

    private int getDepth2(TreeNode root){
        if (root == null)
            return 0;
        int left = getDepth2(root.left);
        if (left == -1)
            return -1;
        int right = getDepth2(root.right);
        if (right == -1)
            return  -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left,right);
    }
}
