public class 前序中序推二叉树结构 {

//    输入某二叉树的前序遍历和中序遍历的结果，
//    请重建出该二叉树。
//    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
//    则重建二叉树并返回。

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return dfs(pre,in,0,pre.length-1,0,in.length-1);
    }

    /**
     *
     * @param pre
     * @param in
     * @param preL 前序开始索引
     * @param preR 前序结束索引
     * @param inL  中序开始索引
     * @param inR  中序结束索引
     * @return
     */
    private TreeNode dfs(int[] pre,int[] in,int preL,int preR,int inL,int inR){

        if (preL>preR || inL > inR) return null;
        //找到当前元素在中序的位置
        int temp = 0;
        for(int i=inL;i<=inR;i++){
            if(pre[preL] == in[i]){
                temp = i;
                break;
            }
        }

        TreeNode head = new TreeNode(pre[preL]);
        head.left = dfs(pre,in,preL+1,preL+temp-inL,inL,temp-1);
        head.right = dfs(pre,in,preL+temp-inL+1,preR,temp+1,inR);
        return head;

    }

    public static void main(String[] args) {

    }
}
