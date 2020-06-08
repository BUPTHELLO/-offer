import java.util.*;

//
// 之字形打印二叉树
// 三种变形:
// 1、普通的广度优先，将数据打印在数组里面
// 2、广度优先，每一层单独放一个数组里面
// 3、广度优先，之字形打印

public class 之字形打印二叉树 {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (pRoot==null) return res;
        //        入队顺序标志位：left->right
        boolean flag = false;

        queue.add(pRoot);
        while (!queue.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int size = queue.size();
            while (size > 0){
                pRoot = queue.remove();
                temp.add(pRoot.val);
                size--;
                if (pRoot.left!=null)
                    queue.add(pRoot.left);

                if (pRoot.right!=null)
                    queue.add(pRoot.right);
            }

            if (!flag) res.add(temp);

            else {

//                反转链表
//                Collections.reverse(temp);

                for (int i=0;i<temp.size()/2;i++){
                    int a = temp.get(i);
                    int b = temp.get(temp.size()-1-i);
                    temp.set(i,b);
                    temp.set(temp.size()-1-i,a);
                }
                res.add(temp);
            }

//          注意每一层取反
            flag = !flag;
        }

        return res;
    }
    public static void main(String[] args) {

    }
}
