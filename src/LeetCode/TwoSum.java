package LeetCode;

import java.util.HashMap;

/*
给定一个整数数列，找出其中和为特定值的那两个数。

你可以假设每个输入都只会有一种答案，同样的元素不能被重用。

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class TwoSum {
    public int[] twosum(int [] nums,int target){
        int nlength = nums.length;
        int result[] = new int[2];
        //hashmap的键：target-数组其中一个数；值：这个数的下标
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nlength ;i++){
            if (map.containsKey(nums[i])){
                result[0] = map.get(nums[i])+1;
                result[1] = i+1;
            }else {
                map.put(target-nums[i],i);
            }
        }
        return result;
    }
}
