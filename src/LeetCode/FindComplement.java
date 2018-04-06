package LeetCode;
//Given a positive integer, output its complement number.
// The complement strategy is to flip the bits of its binary representation.
/*
1.The given integer is guaranteed to fit within the range of a 32-bit signed integer.
2.You could assume no leading zero bit in the integer’s binary representation.
 */
public class FindComplement {
    public int findComplement(int num){
        int i = 0;
        int j = 0;
        while (i < num){
            i += Math.pow(2,j);
            j++;
        }
        return i - num;
    }
}
