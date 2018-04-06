/**
 * 数组中有两个出现一次的数字，其他数字都出现两次，找出这两个数字
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1){
            num1[0] = num2[0] = 0;
            return;
        }

        int length = array.length;
        int index = 0;
        int sum = 0;

        for (int i = 0; i < length; i++){
            sum ^= array[i];
        }
        //sum的二进制表示中的1，表示的是两个唯一数字不同的位
        //我们就取第一个1所在的位数(index)
        for (index = 0;index < 32;index++){
            if ((sum & (1 << index))!= 0)
                break;
        }
        //将数组按照这个第一个1所在的index位将原数组分成两个子数组，分组的标准是第index位是否是1。
        //则相同的数肯定在同一个组里，因为相同的数字他的所有位也相同。不同的数字，肯定不在同一个组里。
        // 然后按照处理"数组中有1个出现一次的数字，其他数字都出现两次，找出这两个数字"的办法按位亦或计算即可。
        //
        for (int i =0;i < length;i++){
            if ((array[i] & (1 << index))!= 0){
                num2[0] ^= array[i];
            }else {
                num1[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        int num[] = {1,1,2,2,3,3,11,5};
        int sum = 0;
        int index =0 ;
        for (int i = 0;i < num.length;i++){
            sum ^= num[i];
        }
        System.out.println(sum);
        for (index = 0;index < 32;index++){
            if ((sum & (1 << index))!= 0){
                System.out.println(index);
                break;
            }

        }
        System.out.println(sum);
    }
}
