public class Power {
    /*
    给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     */
    public static void main(String[] args) {
        Power p = new Power();
        System.out.println(p.power(2,-3));
    }
    boolean g_InvaildInput = false;
    public  double power(double base, int exponent) {
       //方法1：缺点：没有考虑指数（expenent）<1（0和负数）的情况
     /*
        double result = 1.0;
        for (int i = 0;i <= exponent;i++){
            result *= base;
        }
        return result;
     */

        //方法2：全面但不够高效的解法
        g_InvaildInput = false;
        if (equal(base,0.0) && exponent < 0){
            g_InvaildInput = true;
            return 0.0;     //代表：无效输入
        }
        int absExpenent = exponent;
        if (exponent < 0)
            absExpenent = -exponent;
        System.out.println(absExpenent);
        double ans = powerWithExpenent(base,absExpenent);
        if (exponent < 0)
            ans = 1.0/ans;
        return ans;
    }
    boolean equal(double num1, double num2){
        if ((num1 - num2)> -0.000001 && (num2 -num1) < 0.000001)
            return false;
        else
            return true;
    }

    private double powerWithExpenent(double base,int expenent){
        if(expenent==0)
            return 1;
        if (expenent==1)
            return base;
        double result = 1.0;
        for ( int i = 0;i <= expenent-1;i++){
            result *= base;
        }
        return result;
    }
    //方法3：即全面又高效的算法
    public  double power3(double base, int exponent) {
        if (exponent==0)
            return 0;
        if (exponent==1)
            return base;

        double ans = powerWithExpenent(base,exponent>>1);
        ans *= ans;
        if ((exponent & 1) == 1)
            ans *= base;
        return ans;
    }
}
