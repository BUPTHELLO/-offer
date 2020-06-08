import java.util.ArrayList;


public class 二叉搜索树与双向链表 {


    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        ArrayList<TreeNode> res = new ArrayList<>();
        inOrber(pRootOfTree,res);

        return Convert(pRootOfTree,res);
    }

//    中序遍历保存所有节点
    private static void inOrber(TreeNode head, ArrayList<TreeNode> res){
        if (head == null) return;
        inOrber(head.left,res);
        res.add(head);
        inOrber(head.right,res);
    }

//  将Arraylist中节点转换为双向链表
    private static TreeNode Convert(TreeNode head,ArrayList<TreeNode> res){

        if (res.size() == 1) return head;


        for (int i=0;i<res.size()-1;i++){
            res.get(i).right = res.get(i+1);
            res.get(i+1).left = res.get(i);
        }

        return res.get(0);
    }

    public static void main(String[] args) {

    }
}
