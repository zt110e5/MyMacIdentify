import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * 输出描述：输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
//思路1：
/**
 * 用两个数字begin和end分别表示序列的最大值和最小值，
 * 首先将begin初始化为1，end初始化为2.
 * 如果从begin到end的和大于s，我们就从序列中去掉较小的值(即增大begin),
 * 相反，只需要增大end。
 * 终止条件为：一直增加begin到(1+sum)/2并且end小于sum为止
 *
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (sum <= 1)
            return arrayLists;
        int begin = 1, end = 2;
        while (begin != (1 + sum)/2){
            int curSum = getSum(begin,end);
            if (curSum == sum){
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = begin;i <= end;i++){
                    arrayList.add(i);
                }
                arrayLists.add(arrayList);
                begin++;
                end++;
            }else if (curSum < sum){
                end++;
            }else {
                begin++;
            }
        }
        return arrayLists;
    }

    //计算当前序列的和
    private int getSum(int head,int leap){
        int sum = (head + leap)*(leap - head + 1)/2;
        return sum;

    }
}
