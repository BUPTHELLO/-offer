public class 机器人的运动范围 {


    private int sum = 0;
    public int movingCount(int threshold, int rows, int cols)
    {
        boolean[][] visit= new boolean[rows][cols];
        solve(0,0,rows,cols,visit,threshold);
        return sum;
    }

    private void solve(int x,int y,int rows,int cols,boolean[][] visit,int threshold){
        if(x<0 || y<0 || x>=rows || y>=cols || visit[x][y] || Cal(x,y)>threshold)
            return;
        visit[x][y] = true;
        sum++;
        solve(x+1,y,rows,cols,visit,threshold);
        solve(x-1,y,rows,cols,visit,threshold);
        solve(x,y+1,rows,cols,visit,threshold);
        solve(x,y-1,rows,cols,visit,threshold);
    }

//    注意这个处理思路
//    任意一个数字x=123456，一位一位的取出来
//    x%10可以得到x中最后一位的数字
//    x=x/10
//    不断循环即可拿出来每一位数字
//    类似的题目：整数中1出现的个数
    private int Cal(int i,int j){
        int res = 0;
        while(i != 0){
            res = res + i%10;
            i = i/10;
        }
        while(j != 0){
            res = res + j%10;
            j = j/10;
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
