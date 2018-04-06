import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println(N);
        int num[] = new int[4];

        for (int i  = 0;i < 4;i++){
            num[i] = in.nextInt();
            System.out.println(num[i]);
        }
        in.close();
        int sum = helper(num,N);
        System.out.println(sum);
    }

    private static int helper(int num[],int k){
        int x = num[0];     //第一类歌曲长度
        int y = num[2];     //第二类歌曲长度
        int A = num[1];     //第一类歌曲数量
        int B = num[3];     //第二类歌曲数量
        System.out.println(x + " " + y + " " + A + " " + B);
        int num1[] = new int[A];

        for (int i = 0;i < A;i++){
            num1[i] = x;
        }
        int num2[] = new int[B];
        for (int i = 0;i < B;i++){
            num2[i] = y;
        }
        int a1 = 0;
        int a2 = 0;
        int result = 0;
        for (int i = 0;i<A;i++){
            for (int j = 0;j < B;j++){
                if (x * i + y * j == k){
                    a1 = i;
                    a2 = j;
                }
            }
        }
//        System.out.println(a1 + " " +a2);

        return getJieSheng(A,a1)*getJieSheng(B,a2);
    }

    private static int getJieSheng(int m, int n)
    {
        int sumM = 1;
        for (int i = m;i >= n;i--){
            sumM *= i;
        }

        int sumN = 1;
        for (int j = n; j >= 1;j--){
            sumN *=j;
        }

        return sumM/sumN;

    }

}
