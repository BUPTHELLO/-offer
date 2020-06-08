import java.util.ArrayList;

public class 和为S的连续正整数数列 {
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(sum <= 0) return res;
        int i = 1;
        int j = 1;
        int aa = 1;
        while(i<=sum/2){
            if(aa < sum){
                j++;
                aa = aa + j;
            }else if(aa > sum){
                aa = aa - i;
                i++;

            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                for(int k=i;k<=j;k++)
                    temp.add(k);
                if(temp.size()>=2)
                    res.add(temp);
                j++;
                aa = aa + j;
            }
        }


        return res;
    }

    public static void main(String[] args) {
        FindContinuousSequence(9);
    }
}
