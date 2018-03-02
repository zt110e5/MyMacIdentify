
/*
替换字符串中的空格
 */
public class ReplaceBlack {
    public static void main(String[] args) {
        String test = "we are happy.";
        ReplaceBlack rb = new ReplaceBlack();
        System.out.println(rb.replaceBlack1(test));
        System.out.println(rb.replaceBlack2(new StringBuffer(test),25));
    }
    /*
    这种方法是从头到尾遍历数组（字符串），因为将空格代替为%20需要将空格之后的字符串向后移动，假设字符串长度为n，则对于每个空字符串，
    需要移动后面的O(n)个字符串，对于含有O(n)个空格的字符串，总的时间复杂度为O(n2)，所有这种算法效率太慢。。。。
     */
    public String replaceBlack1(String input){
        if (input == null)
            return null;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i< input.length();i++){
            if (input.charAt(i)==' '){
                buffer.append("%");
                buffer.append("2");
                buffer.append("0");
            }else {
                buffer.append(String.valueOf(input.charAt(i)));
            }
        }
        return new String(buffer);

    }

    /*
    更简单快速的方法是从后到前遍历字符串。
     */
    public String replaceBlack2(StringBuffer input,int length){
        if (input == null)
            return null;

        int originalLength = input.length();      //字符串实际长度
        int numberBlack = 0;        //空格数量
        int i = 0;

        //遍历字符串，找出空格数量
        for (i = 0;i<originalLength;i++){
            if (input.charAt(i)==' '){
                ++numberBlack;
            }
        }
        //newLength为把字符串替换后的长度
        int newLength = originalLength + numberBlack * 2;
        if (newLength > length)
            return null;

        int indexOfOriginal = originalLength-1;
        int indexOfNew = newLength-1;
        input.setLength(newLength);   //使input的长度扩大到转换成%20之后的长度,防止下标越界
        while(indexOfOriginal>=0 && indexOfOriginal <indexOfNew){

            if (input.charAt(indexOfOriginal) == ' '){
                input.setCharAt(indexOfNew--,'0');
                input.setCharAt(indexOfNew--,'2');
                input.setCharAt(indexOfNew--,'%');
                numberBlack--;
                if (numberBlack==0)
                    break;
            }else
                input.setCharAt(indexOfNew--,input.charAt(indexOfOriginal));
            --indexOfOriginal;
        }
        return input.toString();
    }

}
