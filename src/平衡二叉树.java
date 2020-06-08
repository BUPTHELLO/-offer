import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


//平衡二叉树：一个二叉树每个节点的左右两个子树的高度差的绝对值不超过1。
public class 平衡二叉树 {
//    错误解法：
//    只判断了根节点的左右节点高度差，没有判断每个节点
    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int L = Depth(root.left);
        int R = Depth(root.right);

        return Math.abs(R-L)<=1 ? true:false;
    }

//    正确解法
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int L = Depth(root.left);
        int R = Depth(root.right);
        if(Math.abs(L-R)>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private static int Depth(TreeNode root){
        if (root == null) return 0;
        int L = Depth(root.left);
        int R = Depth(root.right);
        return Math.max(L,R)+1;
    }




    public static void main(String[] args) {

    }
}
