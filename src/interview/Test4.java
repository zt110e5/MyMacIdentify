import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = input.next();
        str = str.toLowerCase();
        Map<Integer,Integer> map = map_helper();
        for (int i = 0;i < str.length();i++){
            char s = str.charAt(i);
            int index_num = map.get(str.charAt(i))+1;
            map.put(Integer.valueOf(s),index_num);
        }
        for (int i = 0;i < 10;i++){
            if (map.get(i) == 0){
                System.out.println(i);
                break;
            }
        }



    }

    public static Map<Integer,Integer> map_helper(){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0;i <=9;i++){
            map.put(i,0);
        }
         return map;

    }
}
