
import java.util.*;

public class build {
    public static ArrayList<Integer> res1 = new ArrayList<>();


    public static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] num = new int[]{10,5,15,3,7,13,18};

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();



        if (line.equals("None")){
            System.out.println("False");
            return;
        }
        String[] strings = line.trim().split(",");
        int[] nums = new int[strings.length];
        for(int i=0;i<strings.length;i++){
            nums[i] = Integer.parseInt(strings[i]);
        }

        TreeNode head = help(nums,0);

        inorder(head,res);
        System.out.println(judge(res));

    }

    private static TreeNode help(int[] nums,int i){
        if (i>=nums.length)
            return null;
        TreeNode head = new TreeNode(nums[i]);
        head.left = help(nums,2*i+1);
        head.right = help(nums,2*i+2);
        return head;
    }

    private static void inorder(TreeNode head,ArrayList<Integer> res){
        if (head == null) return;
        inorder(head.left,res);
        res.add(head.val);
        inorder(head.right,res);
    }

    private static boolean judge(ArrayList<Integer> res){
        for (int i=0;i<res.size()-1;i++){
            if (res.get(i)>res.get(i+1))
                return false;
        }
        return true;
    }
}
