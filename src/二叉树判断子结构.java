import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 二叉树判断子结构 {


//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

        public boolean HasSubtree(TreeNode root1, TreeNode root2) {
            if (root1 == null || root2 == null) {
                return false;
            }
            return judgeSubTree(root1, root2) ||
                    judgeSubTree(root1.left, root2) ||
                    judgeSubTree(root1.right, root2);
        }

        private boolean judgeSubTree(TreeNode root1, TreeNode root2) {
            if (root2 == null) {
                return true;
            }
            if (root1 == null) {
                return false;
            }
            return (root1.val == root2.val)&&judgeSubTree(root1.left, root2.left) &&
                    judgeSubTree(root1.right, root2.right);
        }


//        下面的答案是错误的
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }

        if(A.val == B.val){
            return help(A,B);
        }

        return isSubStructure(A.left,B) || isSubStructure(A.right,B);

    }

    private static boolean help(TreeNode A, TreeNode B){
//        if(A == null && B == null) return true;
//        if(A ==null || B == null) return false;

        if (B == null) return true;
//        if (B == null && A==null) return true;
//        if (B == null && A!=null) return true;

        if (A == null) return false;
//      if (B != null && A==null) return false;


        return (A.val == B.val) && help(A.left,B.left) && help(A.right,B.right);
    }
    public static void main(String[] args) {
//        TreeNode A = new TreeNode(10);
//        A.left = new TreeNode(12);
//        A.right = new TreeNode(6);
//        A.left.left = new TreeNode(8);
//        A.left.right = new TreeNode(3);
//        A.right.left = new TreeNode(11);
//
//        TreeNode B = new TreeNode(10);
//        B.left = new TreeNode(12);
//        B.right = new TreeNode(6);
//        B.left.left = new TreeNode(8);

        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);

        TreeNode B = new TreeNode(3);
        System.out.println(isSubStructure(A,B));

        System.out.println(help(A,B));

    }


}
