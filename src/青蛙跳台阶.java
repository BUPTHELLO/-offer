public class 青蛙跳台阶 {
    //一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

    public int JumpFloorII(int n) {

        int[] arr = new int[n+1];
        arr[0] = 0;
        for (int i=1;i<=n;i++){
            int total = 0;
            for (int j=0;j<i;j++){
                total = total + arr[j];
            }
            arr[i] = 1 + total;
        }
        return arr[n];
    }

    public static void main(String[] args) {

    }
}
