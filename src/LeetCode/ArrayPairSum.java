package LeetCode;

import java.util.Arrays;

/*
Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 say (a1, b1), (a2, b2), ...,
(an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 */
/*
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 */
//思路：先按升序排序，后每隔一个数取一个相加起来就是结果
public class ArrayPairSum {
    public int arrayPairSum(int[] nums){
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i+=2){
            sum += i;
        }
        return sum;
    }
}
