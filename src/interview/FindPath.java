import java.util.ArrayList;
import java.util.Stack;

/**
 * 二叉树中和为某一值得路径：
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (root == null)
            return arrayLists;

        //Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null){
            arrayLists.add(new ArrayList<>(arrayList));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        arrayList.remove(arrayList.size()-1);
        return arrayLists;
    }
}
