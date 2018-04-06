import java.util.ArrayList;

/*
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
例如，如果输入如下矩阵：
1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class PrintMatrix {
    ArrayList<Integer> array = new ArrayList<>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        if (matrix == null || matrix.length == 0)
            return array;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        while (columns > start * 2 && rows > start * 2){
            printMatrixInCircle(matrix,columns,rows,start);
            start++;
        }
        return array;
    }

    public void printMatrixInCircle(int [][] matrix,int columns,int rows,int start){
        int endY = columns  -1- start;
        int endX = rows  - 1-start;
        //从左到右打印一行
        for (int i =start;i<=endX;i++){
            int number = matrix[start][i];
            array.add(number);
        }
        //从上到下打印一列
        //终止行号要大于起始行号
        if (start < endY){
            for (int i = start + 1;i<=endY;i++){
                array.add(matrix[i][endY]);
            }
        }

        //从右到左打印一行
        //要打印这一列，则至少需要矩阵为2*2，故需要终止行号大于起始行号，终止列号大于起始列号
        if (start < endY && start <endX){
            for (int i = endY -1;i>=start;i--){
                array.add(matrix[endY][i]);
            }
        }

        //从下到上打印一行
        //要打印这一列，则至少需要矩阵为3*2，故终止列号大于起始列号，终止行号比起始行号大2以上
        if (start < endY && start < endY-1){
            for (int i = endY -1;i > start +1;i--){
                array.add(matrix[i][start]);
            }
        }
    }

    public static void main(String[] args) {
        int a1[] = {1,2,3,4};
        int a2[]=  {5,6,7,8};
        int a3[] = {9,10,11,12};
        int a4[]= {13,14,15,16};
        int att[][] = new int[4][4];
        att[0] = a1;
        att[1] = a2;
        att[2] = a3;
        att[3] = a4;
        PrintMatrix pm = new PrintMatrix();
        ArrayList<Integer> array = pm.printMatrix(att);
        for (int i :
                array) {
            System.out.println(i);
        }

    }
}

