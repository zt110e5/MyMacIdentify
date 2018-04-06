import java.util.Arrays;

public class Print1ToMaxOfNDigts {
    /*
    在字符串上模拟数字加法:
    1.将字符串每一个数字都初始化位0
    2.在字符串表达式上模拟加法
    3.把字符串表达的数字打印出来
     */
    /*
    public void print1toMaxOfNDights(int n){
        if( n<=0 )
            return;
        char[] numbers = new char[n];
        Arrays.fill(numbers,'0');   //将字符串每一个数字都初始化位0
        while (!Increment(numbers))     //判断是否达到n位数的最大值，如果达到，则打印出所有数组中的数。
            PrintNumber(numbers);
    }
    //实现表示数字的字符串numbers上加1，还有判断是不是达到了最大的n位数。
    private boolean Increment(char[] numbers){
        boolean isOverflow = false;         //是否达到最大n位数标记，初始位false
        int nTakeOver = 0;                  //10位进百位，个位进10位，到整十整百时用
        int nLength = numbers.length;       //字符串长度
        for (int i = nLength - 1;i>=0;i--){
            int nSum = numbers[i] - '0' + nTakeOver;
            if (i == nLength-1)             //个位增加1
                nSum++;
            if (nSum >= 10){                //判断个位数字是否要溢出进位
                if(i==0)                    //达到n位最大值
                    isOverflow = true;
                else {                      //未达到n位最大值，进一位
                    nSum -= 10;
                    nTakeOver = 1;
                    numbers[i] = (char)('0' + nSum);
                }
            }
            else {                          //个位数字不进位
                numbers[i] = (char)('0'+ nSum);
                break;
            }
        }
        return isOverflow;
    }
    */

    public void PrintNumber(char[] numbers){
        boolean isBeginning0 = true;
        int nLength = numbers.length;
        for (int i = 0;i < nLength;i++){
            if (isBeginning0 && numbers[i] != '0')
                isBeginning0 = false;
            if (!isBeginning0)
                System.out.print(numbers[i]);
        }
        System.out.print('\t');
    }



    //递归方法
    public void print1toMaxOfNDights2(int n){
        if (n <= 0)
            return;

        char numbers[] = new char[n];
        Arrays.fill(numbers,'0');
        for (int i= 0;i < 10 ;i++){
            numbers[0] = (char)(i + '0');
            Print1ToMaxOfNDightsRecurively(numbers,n,0);

        }
    }

    private void Print1ToMaxOfNDightsRecurively(char[] numbers,int length,int index){
        if (index == length -1){
            PrintNumber(numbers);
            return;
        }
        for (int i = 0;i < 10;i++){
            numbers[index+1] = (char)(i + '0');
            Print1ToMaxOfNDightsRecurively(numbers,length,index+1);
        }
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDigts p = new Print1ToMaxOfNDigts();
        //p.print1toMaxOfNDights(3);
        p.print1toMaxOfNDights2(3);
    }

}
