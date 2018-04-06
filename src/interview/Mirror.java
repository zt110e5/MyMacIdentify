/*
操作给定的二叉树，将其变换为源二叉树的镜像。
1.先前序遍历这棵树的每一个节点，如果遍历到的节点有子节点，就交换他的两个子节点。
2.当交换完所有非叶节点的左右子节点，就得到了树的镜像。
 */
public class Mirror {
    public void Mirror(TreeNode root){
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);
    }
}
