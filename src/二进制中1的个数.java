public class 二进制中1的个数 {

//    题目描述
//    输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
//            n = n&(n-1);可以实现把二进制中最右边的1变为0
    public static int NumberOf1(int n) {
        int res = 0;
        while(n != 0){
            n = n&(n-1);
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-9));
    }
}
