import java.util.ArrayList;

public class 二叉树层序遍历 {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if(root == null) return res;

        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.remove(0);
            res.add(root.val);
            if(root.left != null){
                queue.add(root.left);
            }
            if(root.right!=null){
                queue.add(root.right);
            }
        }
        return res;
    }
    public static TreeNode Initial(){
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.left.left = new TreeNode(3);
        head.right = new TreeNode(4);
        head.right.left = new TreeNode(5);
        return head;
    }
    public static void main(String[] args) {
        PrintFromTopToBottom(Initial());
    }
}
