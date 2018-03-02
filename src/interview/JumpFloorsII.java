public class JumpFloorsII {
    /*
    变态跳台阶，还可一次性跳n阶台阶
     */
    public int JumpFloorII(int target) {
        if (target <= 0)
            return -1;
        else  if(target == 1)
            return 1;
        else
            return 2 * JumpFloorII(target - 1);
    }
}
