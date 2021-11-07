package ByteDance;
/**
 * 2021/11/2
 *
 * 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * */
public class _19_ReverseList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode cur = head ;
        ListNode pre = head ;

        while (cur != null){
            pre = cur.next ;
            cur.next = p ;
            p = cur ;
            cur = pre ;
        }
        return p ;
    }
    public static void main(String[] args) {
        _19_ReverseList obj = new _19_ReverseList() ;
        ListNode node5 = new ListNode(5) ;
        ListNode node4 = new ListNode(4 , node5) ;
        ListNode node3 = new ListNode(3 , node4) ;
        ListNode node2 = new ListNode(2 , node3) ;
        ListNode node1 = new ListNode(1 , node2) ;

        ListNode res = obj.reverseList(node1) ;
        System.out.println(res.val);

    }
}
