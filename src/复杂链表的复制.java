public class 复杂链表的复制 {


    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode CurNode = pHead;

//        链表节点复制
        while (CurNode!=null){
            RandomListNode newNode = new RandomListNode(CurNode.label);
            RandomListNode nextNode = CurNode.next;
            CurNode.next = newNode;
            newNode.next = nextNode;
            CurNode = nextNode;
        }

//        修改新节点random指针
        CurNode = pHead;
        while (CurNode!=null){
            CurNode.next.random = CurNode.random == null ? null:CurNode.random.next;
            CurNode = CurNode.next.next;
        }


        RandomListNode p = pHead;
        RandomListNode q = pHead.next;

        RandomListNode resHead = q;

//                断开指针
        while (q.next != null){
            p.next = q.next;
            q.next = p.next.next;
            p = p.next;
            q = q.next;
        }

        p.next = null;

        return resHead;


    }

    public static void main(String[] args) {

    }
}
