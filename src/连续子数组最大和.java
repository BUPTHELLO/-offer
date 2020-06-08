public class 连续子数组最大和 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 1) return array[0];

        int[] dp = new int[array.length];

        dp[0] = array[0];
        for(int i=1;i<array.length;i++){
            dp[i] = Math.max(array[i],dp[i-1]+array[i]);
        }
        int res = dp[0];
        for(int i=0;i<array.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        FindGreatestSumOfSubArray(new int[]{2,4,-1,100});
    }
}
