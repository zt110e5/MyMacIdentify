/**
 * 二叉搜索树的后序遍历
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        boolean flag = isBST(sequence,0,sequence.length-1);
        return flag;

    }

    public boolean isBST(int [] sequence,int start ,int end){
        if (start >= end)
            return true;
        //当前数组根节点
        int currentRoot = sequence[sequence.length-1];
        int splitIndex;
        //找到数组以根节点的分界
        for (splitIndex = start;splitIndex < end && sequence[splitIndex]<currentRoot;splitIndex++){

        }
        for (int j = splitIndex;j < end;j++){
            if (sequence[j]<currentRoot)
                return false;
        }

        return isBST(sequence,start,splitIndex-1) && isBST(sequence,splitIndex,end);
    }
}
