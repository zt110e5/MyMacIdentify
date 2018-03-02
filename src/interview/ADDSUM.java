/*
求和：1+2+3+```+n
 */
public class ADDSUM {
    public int sum_solution(int n){
        int result = 0;
        boolean flag = (result>0) && ((result += sum_solution(--n))>0);
        return result;
    }

    public static void main(String[] args) {
        boolean flag[] = new boolean[20];
        System.out.println(flag);
    }
}
