/**
 * 二叉树的序列化
 */
public class Serialize {

    public String Serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        if (root == null){
            sb.append("$");
            return sb.toString();
        }
        sb.append(root.val + " ,");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
}
