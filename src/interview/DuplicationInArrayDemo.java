import java.util.Scanner;

public class DuplicationInArrayDemo {
    /*
    面试题3：数组中重复的数字
    思想：从头到尾扫描这个数组种的每个数字。当扫描到下标为i的数字时，首先比较这个数字（m)是不是等于i.如果是，则接着扫描下一个数字；
         如果不是，则再拿它和第m个数字进行比较。如果他和第m个数字相等，就找到了一个重复的数字（该数字在下标i和m的位置都出现了)；如果他和第m
         个数字不等，则把第i和第m个数字交换，把m放到属于它的位置。接下来重复这一步骤。
    时间复杂的：O(n)
    空间复杂的：O(1)
     */
    public boolean duplication(int[] array){
        if(array == null || array.length <= 0){
            return false;
        }
        for(int i = 0;i < array.length;i++){
            if (array[i] < 0 || array[i] > array.length-1)
                return false;
        }

        for (int i = 0;i < array.length;i++){
            while (array[i] != i){
                if (array[i] == array[array[i]]){
                    System.out.println("array[i] == array[array[i]]");
                    return true;
                }else {
                    //int temp = array[i];
                    //array[i] = array[array[i]];
                    //array[array[i]] = array[i];
                    int sum = array[i] + array[array[i]];
                    array[i] = sum - array[i];
                    array[array[i]] = sum - array[array[i]];

                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {2,5,8,6,4,9,3,7,5,2};
        DuplicationInArrayDemo diad = new DuplicationInArrayDemo();
        Scanner in = new Scanner(System.in);
        System.out.println(diad.duplication(arr));
    }
}
