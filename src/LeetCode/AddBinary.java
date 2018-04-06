package LeetCode;
/*
给定两个二进制字符串，返回他们的和（用二进制表示）。

案例：
a = "11"
b = "1"
返回 "100" 。
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        /*
         考虑进位，考虑最后一项的进位

        0+0 = 0 不需要进位

        0+1 = 1 不需要进位

        1+1 =0  进位 1

        同时注意

        低位进1，高位时1+1的情况，直接加就是3了，这个需要进位1 ，原位的结果也是1的情况
         */
        String result = "";
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;
        int sum = 0;
        while (aLen >= 0 || bLen >=0){
            if (aLen >=0){
                sum += Integer.parseInt(a.substring(aLen,aLen+1));
                aLen--;
            }
            if (bLen>=0){
                sum += Integer.parseInt(b.substring(bLen,bLen+1));
                bLen--;
            }
            if (sum==2){
                result = "0"+result;
                sum = 1;
            }else if (sum==0 || sum==1){
                result = sum +"" + result;
                sum = 0;
            }else if(sum==3){
                result = "1" + result;
                sum = 1;
            }
        }
        if(sum==1)
            result = "1" + result;
        return result;
    }
}
