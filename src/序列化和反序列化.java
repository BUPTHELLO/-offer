import java.util.LinkedList;
import java.util.Queue;

public class 序列化和反序列化 {
    public static String Serialize(TreeNode root) {
        StringBuffer res = new StringBuffer();
        help(root,res);
        return res.substring(0);
    }
    private static void help(TreeNode root,StringBuffer res){
        if(root == null){
            res.append("#!");
            return;
        }
        res.append(root.val);
        res.append("!");

        help(root.left,res);
        help(root.right,res);

    }

    public static TreeNode Deserialize(String str) {
        String[] values = str.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (int i = 0; i != values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }
    public static TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }

        TreeNode head = new TreeNode(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(6);
        String res = Serialize(head);
        Deserialize(res);


    }
}
