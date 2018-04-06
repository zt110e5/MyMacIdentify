package LeetCode;

public class RomanToInt {
    public int romanToInt(String s){

        // Write your code here
        if (s.length() < 1)
            return 0;
        int result = 0;
        int sub = getRomanValues(s.charAt(0));
        int lastv = sub;
        for (int i = 1;i<s.length();i++){
            char s_value_i = s.charAt(i);
            int temp = getRomanValues(s_value_i);
            if (lastv==temp){
                sub += temp;
            }else if (lastv>temp){
                result += temp;
                sub = temp;
            }else {
                sub = temp - sub;
            }
            lastv = temp;
        }
        result += sub;
        return result;

    }

    public int getRomanValues(char c){
        // 基本字符    相应的阿拉伯数字表示为
        // I           1
        // V           5
        // X           10
        // L           50
        // C           100
        // D           500
        // M           1000
        switch (c){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
             default:
                 return 0;
        }
    }
}
