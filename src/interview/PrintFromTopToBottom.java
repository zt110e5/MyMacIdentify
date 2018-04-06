import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
从上往下打印出二叉树：
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
思路：利用队列的先进先出
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null)
            return null;

        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            if (treeNode.left != null)
                queue.offer(treeNode.left);
            if (treeNode.right != null)
                queue.offer(treeNode.right);
            arrayList.add(treeNode.val);
        }
        return arrayList;

    }
}
