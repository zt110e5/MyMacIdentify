import java.util.HashMap;

/**
 * 字符串中第一个只出现一次的字符：
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置.
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {

        if (str.length() == 0)
            return 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i = 0; i< str.length();i++){
            if (hashMap.containsKey(str.charAt(i))){
                int num = hashMap.get(str.charAt(i));
                hashMap.put(str.charAt(i),++num);
            }else {
                hashMap.put(str.charAt(i),1);
            }
        }

        int pos = -1;
        for (int j = 0;j < str.length();j++){
            char c = str.charAt(j);
            if (hashMap.get(c) == 1){
                return j;
            }
        }


        return pos;
    }
}
