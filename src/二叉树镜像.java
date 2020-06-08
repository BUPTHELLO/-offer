import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉树镜像 {

//    翻转以root为根节点的左右节点
    public void Mirror(TreeNode root) {
        if (root == null) return;

//        交换左右子树的位置
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        Mirror(root.left);
        Mirror(root.right);

    }



    public static void main(String[] args) {
    }
}
