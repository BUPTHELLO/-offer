import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 字符串排列 {
//    public static ArrayList<String> Permutation(String str) {
//        ArrayList<String> res = new ArrayList<>();
//        if(str == null || str.length() == 0) return res;
//        help(str.toCharArray(),0,res);
//        Collections.sort(res);
//
//        return res;
//    }
//
//    private static void help(char[] arr, int index, ArrayList<String> res){
//
//        if(index==arr.length-1){
//            String val = String.valueOf(arr);
//            if(!res.contains(val)){
//                res.add(val);
//            }
//        }
//
//        for(int i=index;i<arr.length;i++){
//            swap(arr,i,index);
//            help(arr,index+1,res);
//            swap(arr,i,index);
//        }
//    }
//
//    private static void swap(char[] arr,int i,int j){
//        char temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }


//    DFS模板，非常好！！！
    private static List<List<Integer>> res;
    public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        help(nums,0,new ArrayList<>(),visited);
        return res;
    }
    private static void help(int[] nums, int index, List<Integer> list, boolean[] visited){
        if(index == nums.length) {
            ArrayList ans = new ArrayList<>(list);
            if(!res.contains(ans)){
                res.add(ans);
            }
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            help(nums,index+1,list,visited);
            visited[i] = false;
            list.remove(list.size()-1);
        }
    }
    public static void main(String[] args) {
//        System.out.println(Permutation("dkjphedy"));
        System.out.println(permute(new int[]{1,2,3,4}));
    }
}
