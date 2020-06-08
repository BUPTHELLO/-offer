import java.util.ArrayList;

public class 二叉树中和为某一值的路径 {


//DFS模板
    private static ArrayList<ArrayList<Integer>> res;
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        res = new ArrayList<>();
        if(root == null) return res;
        help(root,target,new ArrayList<>());
        return res;
    }

    private static void help(TreeNode root,int target,ArrayList<Integer> temp){
//        if(root == null && target == 0){
//            ArrayList<Integer> ans = new ArrayList<>(temp);
//            if (!res.contains(ans)){
//                res.add(ans);
//            }
//            return;
//        }
//        if(root == null){
//            return;
//        }
//
//        temp.add(root.val);
//        help(root.left,target-root.val,temp);
//        help(root.right,target-root.val,temp);
//        temp.remove(temp.size()-1);

        if(root == null){
            return;
        }
        temp.add(root.val);
        target = target - root.val;

        if(root.left == null && root.right == null && target == 0){
            ArrayList<Integer> ans = new ArrayList<>(temp);
            res.add(ans);
        }else{
            help(root.left,target,temp);
            help(root.right,target,temp);
        }
        temp.remove(temp.size()-1);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(-2);
        head.right = new TreeNode(-3);



//        TreeNode head = new TreeNode(1);
//        head.left = new TreeNode(2);
        FindPath(head,-5);
    }
}
