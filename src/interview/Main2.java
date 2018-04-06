import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        ArrayList<String> list = new ArrayList<>();
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i =0; i < N; i++){
            String a = in.next();
            list.add(a);

        }
        int X = in.nextInt();
        String finaldata = in.next();
        list.add(finaldata);
        ArrayList<Integer> alist = null;
        for (String s:
             list) {
            String ss[] = s.split(" ");
            alist = new ArrayList<>();
            alist.add(Integer.valueOf(ss[0]));
            alist.add((Integer.valueOf(ss[1])));
            lists.add(alist);
        }

        int A = lists.get((lists.size()-1)).get(0);
        int B = lists.get((lists.size()-1)).get(1);

        int num[] = new int[2];
        for (int i = 0 ;i < N;i++){
            if (lists.get(i).get(0) < A){
                if (lists.get(i).get(1) + X < B){
                    num[0] = lists.get(i).get(0);
                    num[1] = lists.get(i).get(1);
                }
            }
        }
        for (int i:
             num) {
            System.out.print(i);
        }
    }
}
