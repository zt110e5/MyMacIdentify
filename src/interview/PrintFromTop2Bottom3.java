import java.util.ArrayList;
import java.util.Stack;

/*
按之字形打印二叉树：
请实现一个函数按照之字形打印二叉树，
即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
其他行以此类推。
思路：用两个栈，注意，这次用的是栈，不是队列！！！！
打印某一层节点时，把下一层的子节点保存到相应的栈里。
如果当前打印的是奇数层（1，3层），则先保存左子节点在保存右子节点到第一个栈里；
如果当前打印的是奇数层（2，4层），则先保存右子节点再保存左子节点到第二个栈里。
 */
public class PrintFromTop2Bottom3 {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> >  arrayLists = new ArrayList<>();
        if (pRoot == null)
            return arrayLists;


        Stack<TreeNode> stack1 = new Stack<>();     //奇数层
        Stack<TreeNode> stack2 = new Stack<>();     //偶数层
        stack1.push(pRoot);
        int layer = 1;
        while (!stack1.empty() || !stack2.empty()){
            if (layer %2 == 1){
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!stack1.empty()){
                    TreeNode t1 = stack1.pop();
                    if (t1!=null){
                        arrayList.add(t1.val);
                        stack2.push(t1.left);
                        stack2.push(t1.right);
                    }
                }
                if (!arrayList.isEmpty()){
                    arrayLists.add(arrayList);
                    layer ++;
                }
            }else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                while (!stack2.empty()){
                    TreeNode t2 = stack2.pop();
                    if (t2!=null){
                        arrayList.add(t2.val);
                        stack1.push(t2.right);
                        stack1.push(t2.left);
                    }

                }
                if (!arrayList.isEmpty()){
                    arrayLists.add(arrayList);
                    layer++;
                }
            }
        }
        return arrayLists;
    }
}
