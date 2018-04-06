/**
 * 二叉树的反序列化
 */
public class Deserialize {
    public  int index = -1;
    public TreeNode Deserialize(String str){
        index++;
        int len = str.length();
        if (index >= len){
            return null;
        }
        String[] strings = str.split(",");
        TreeNode node = null;
        if (!strings[index].equals("$")){
            node = new TreeNode(Integer.valueOf(strings[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);

        }
        return node;
    }
}
