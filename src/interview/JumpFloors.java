public class JumpFloors {
    /*
    一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法.本质是斐波那契数列问题。
   f(n) = f(n-1) + f(n-2)
     */
    public int JumpFloor(int target) {
        if (target == 1 || target ==2){
            return target;
        }

        int jumpsum = 0;
        int jump1 = 1;
        int jump2 = 2;
        for (int i = 3;i <= target;i++){
            jumpsum = jump2 + jump1;
            jump1 = jump2;
            jump2 = jumpsum;
        }
        return jumpsum;
    }
}
