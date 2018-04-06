/**
 * 数组中的逆序对：
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 思路：按照最笨的遍历方法，时间复杂度为O(n^2)。
 *      我们可以采取归并排序的方法
 */
public class InversePairs {
    public int InversePairs(int [] array) {
        if (array.length == 0 || array == null)
            return 0;
        int copy[] = new int[array.length];
        for (int i = 0; i < array.length;i++){
            copy[i] = array[i];
        }
        int count = InversePairsCore(array,copy,0,array.length - 1);
        return count;
    }

    private int InversePairsCore(int [] array, int [] copy, int low ,int high){
        if (low == high)
            return 0;
        int mid = (low + high) >> 1;
        int leftCount = InversePairsCore(array,copy,low,mid)%1000000007;
        int rightCount = InversePairsCore(array,copy,mid+1,high)%1000000007;

        int count = 0;
        int i = mid;        //i初始化为前半段最后一个数字的下标
        int j = high;       //j初始化为后半段的最后一个数字的下标
        int locCopy = high;

        while (i>= low && j > mid){
            if (array[i] > array[j]){
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007){
                    count %= 1000000007;
                }
            }else {
                copy[locCopy--] = array[j--];
            }
        }
        for (;i>=low;i--){
            copy[locCopy--]=array[i];
        }
        for (;j>mid;j--){
            copy[locCopy--]=array[j];
        }
        for (int s = low;s <= high;s++){
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;
    }
}

