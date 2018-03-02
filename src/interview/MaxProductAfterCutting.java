import java.lang.Math;
public class MaxProductAfterCutting {
    /*
     * 面试题14：剪绳子
     * 题目：给你一根长度为n的绳子，请把绳子剪成m段(m和n都是整数，n>1并且m>1)每段绳子的长度记为k[0],k[1],...,k[m].
     * 请问k[0]*k[1]*...*k[m]可能的最大乘积是多少？
     * 例如，当绳子的长度为8时，我们把它剪成长度分别为2,3,3的三段，此时得到的最大乘积是18.
     */
    public static void main(String[] args) {
        System.out.println(maxProductAftrerCutting_solution1(8));
        System.out.println(maxProductAftrerCutting_solution2(8));
    }
    public static int maxProductAftrerCutting_solution1(int length){
        /**
         * 常规的需要O(n2)的时间复杂度和O(n)的空间复杂度的动态规划思路
         * 题目的意思是:绳子至少是2米，并且必须最少剪一刀。
         */
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        // 子问题的最优解存储在product数组中，数组中的第i个元素表示把长度为i的绳子剪成若干段后各段长度乘积的最大值。
        int products[] = new int[length+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;
        //products[4]=4;
        //products[5]=6;
        //int max = 0;
        for (int i =4 ;i <= length;i++){
            int max = 0;
            for (int j = 1;j <= i/2;j++){
                int product = products[j] * products[i - j];
                if (max < product)
                    max = product;
                products[i] = max;
            }
        }

        return products[length];
    }
    public static int maxProductAftrerCutting_solution2(int length){
        /*
        接着这种算法是只需要时间复杂度和空间复杂度为O(1)的贪婪算法。算法如下：
        当n>=5时，尽可能的减长度为3的绳子；当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
         */
        if (length < 2)
            return 0;
        if (length == 2)
            return 2;
        if (length == 3)
            return 3;
        int timeOf3= length/3;
        if (length - timeOf3*3 == 1)
            timeOf3 -= 1;
        int timeOf2 = (length - timeOf3*3)/2;
        return (int)(Math.pow(3,timeOf3))*(int)(Math.pow(2,timeOf2));
    }
}
