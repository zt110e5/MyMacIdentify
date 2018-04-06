import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintFromTop2Bottom2 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if (pRoot == null)
            return arrayList;
        ArrayList<Integer> array = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int start = 0;
        int end = 1;

        queue.offer(pRoot);
        while (!queue.isEmpty()){
            TreeNode tnode = queue.remove();
            array.add(tnode.val);
            start++;
            if (tnode.left != null)
                queue.offer(tnode.left);
            if (tnode.right != null)
                queue.offer(tnode.right);
            if (start == end){
                end = queue.size();
                arrayList.add(array);
                array = new ArrayList<>();
            }
        }
        return arrayList;

    }
}
