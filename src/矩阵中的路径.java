public class 矩阵中的路径 {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){

        boolean[] flag = new boolean[rows*cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (judge(matrix,i,j,rows,cols,flag,str,0)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean judge(char[] matrix,int i,int j,int rows,int cols,boolean[] flag,char[] str,int k) {
        int index = i*cols+j;

        if (i<0 || i>=rows || j<0 || j>=cols || flag[index] || str[k] != matrix[index])
            return false;

        if (k == str.length-1)
            return true;

        flag[index] = true;

        if (    judge(matrix,i-1,j,rows,cols,flag,str,k+1) ||
                judge(matrix,i+1,j,rows,cols,flag,str,k+1) ||
                judge(matrix,i,j-1,rows,cols,flag,str,k+1) ||
                judge(matrix,i,j+1,rows,cols,flag,str,k+1)){
            return true;
        }
        flag[index] = false;
        return false;


    }



    public static void main(String[] args) {

    }
}
