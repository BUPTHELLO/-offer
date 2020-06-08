import java.util.HashMap;

public class 删除链表中重复节点 {
    public static ListNode deleteDuplication(ListNode pHead){
        if (pHead == null) return null;

//        确定最终链表的头结点1->1->1->2->2->3;
            ListNode ans = pHead;
            while (ans!=null){
                if (ans.next != null && ans.val == ans.next.val){
//                当前ans是重复节点
                    int temp = ans.val;
                    while (ans!=null && ans.val == temp){
                        ans = ans.next;
                    }
                }else
                    break;
            }

//            1->1->1->1
            if (ans == null) {
                return null;
            }
//            最终链表的尾部
            ListNode lastnode = ans;
            ListNode removenode = ans.next;
            while (removenode!=null){

                if (removenode.next != null && removenode.val == removenode.next.val){
                    int temp = removenode.val;
                    while (removenode!=null && removenode.val == temp){
                        removenode = removenode.next;
                    }
                }else {
                    lastnode.next = removenode;
                    lastnode = removenode;
                    removenode = removenode.next;
                }

            }
            lastnode.next = null;
        return ans;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        head = deleteDuplication(head);

    }
}
