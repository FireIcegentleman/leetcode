package SwordOffer;

/**
 * 2021/10/04
 *
 * 删除链表的节点
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * */
public class _18_DeleteNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x , ListNode a) {
            val = x;
            next = a ;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null ;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head ;
        ListNode pre = dummy ;
        ListNode p = head ;

        while(p != null){
            if (p.val == val){
                pre.next = p.next ;
                break;
            }
            pre = p ;
            p = p.next ;
        }
        return dummy.next ;
    }
    public static void main(String[] args) {
        _18_DeleteNode obj = new _18_DeleteNode() ;
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4 , node5);
        ListNode node3 = new ListNode(3 , node4);
        ListNode node2 = new ListNode(2 , node3);
        ListNode node1 = new ListNode(1 , node2);

        ListNode res = obj.deleteNode(node1 , 3) ;
        System.out.println(res.val);
    }
}
