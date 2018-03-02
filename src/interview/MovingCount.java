public class MovingCount {
    /*
    地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
    每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
    例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
    请问该机器人能够达到多少个格子？
     */
    public int movingCount(int threshold, int rows, int cols){
        if (threshold <=0 || rows <= 0 || cols <= 0)
            return 0;
        boolean flag[][] = new boolean[rows][cols];
        int count =  helper(threshold,rows,cols,0,0,flag);
        return count;
    }

    private int helper(int threshold,int rows, int cols,int i,int j,boolean[][] flag){
        if (i < 0 || i >=rows || j < 0 || j>= cols || sum(i,j) > threshold || flag[i][j] == true)
            return 0;
        flag[i][j] = true;
        return helper(threshold,rows,cols,i -1 ,j,flag) + helper(threshold,rows,cols,i+1,j,flag) +
                helper(threshold,rows,cols,i,j -1,flag) + helper(threshold,rows,cols,i,j+1,flag)+1;
    }

    private int sum(int a,int b){
        int ans = 0;
        ans = a%10 + a/10 + b%10 + b/10;
        return ans;
    }
}
