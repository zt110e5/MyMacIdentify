/**
 * 连续子数组的最大和：
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length <= 0)
            return 0;
        boolean g_InvalidInput = false;
        int nCurSum = 0;
        int nGreatestSum = 0x80000000;      // 0x80000000具体指最小的负数(-0), 而习惯上0是没有正负的, 所以就是起变量置零效果。
        for (int i = 0; i < array.length; i++){
            if (nCurSum <= 0)
                nCurSum = array[i];     //记录当前最大值
            else
                nCurSum += array[i];        //当array[i]为正数时，加上之前的最大值并更新最大值。
            if (nCurSum > nGreatestSum)
                nGreatestSum = nCurSum;
        }
        return nGreatestSum;
        //动态规划方法：
        /*
        if (array == null || array.length <= 0)
            return 0;
        int sum = array[0];     //注意初始值,不能设为0,防止只有负数
        int tempSum = array[0];
        for (int i = 1; i < array.length; i++){
            tempSum = (tempSum < 0 ) ? array[i] : tempSum + array[i];
            sum = (tempSum > sum) ? tempSum : sum;
        }
        return sum;
        */

    }
}
