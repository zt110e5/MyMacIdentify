/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 思路：中序遍历法+递归转换左右子树
 */
public class Convert {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null)
            return pRootOfTree;
        //1.将左子树构造成双向链表，并返回链表头结点
        TreeNode lefts = Convert(pRootOfTree.left);
        TreeNode p = lefts;
        //2.定位至左子树双向链表的最后一个节点
        while (p!=null && p.right != null){
            p = p.right;
        }
        //3.如果左子树l链表不为空，将root加到末尾
        if (lefts != null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        //4.将右子树构造成双链表，并返回链表头节点。
        TreeNode rights = Convert(pRootOfTree.right);
        //5.如果右子树链表不为空的话，将该链表追加到root节点之后。
        if (rights != null){
            rights.left = pRootOfTree;
            pRootOfTree.right = rights;
        }
        return lefts == null ? pRootOfTree : lefts;
//        TreeNode pLastNodeInList = null;        //指向双向列表的为尾节点
//        ConvertNode(pRootOfTree,pLastNodeInList);
//        TreeNode pHeadOfList = pLastNodeInList;
//        while (pHeadOfList!= null && pHeadOfList.left != null)
//            pHeadOfList = pHeadOfList.left;
//        return pHeadOfList;
//
//    }
//
//    public void ConvertNode(TreeNode pNode, TreeNode pLastNodeInList){
//        if (pNode == null)
//            return;
//
//        TreeNode pCurrent = pNode;
//        if (pCurrent.left != null){
//            ConvertNode(pCurrent.left,pLastNodeInList);
//        }
//        pCurrent.left = pLastNodeInList;
//
//        if (pLastNodeInList != null)
//            pLastNodeInList.right = pCurrent;
//        pLastNodeInList = pCurrent;
//
//        if (pCurrent.right != null)
//            ConvertNode(pCurrent.right,pLastNodeInList);
    }
}
