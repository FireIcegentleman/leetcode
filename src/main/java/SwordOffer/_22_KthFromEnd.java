package SwordOffer;
/**
 * 2021/10/02
 *
 * 链表中的倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * */
public class _22_KthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x , ListNode a) {
            val = x ;
            next = a ;
        }
    }
    // 快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head ;
        ListNode slow = head ;

        while (k > 0 && fast != null){
            fast = fast.next ;
            k-- ;
        }
        if (k > 0){
            return null ;
        }

        while(fast != null){
            slow = slow.next ;
            fast = fast.next ;
        }

        return slow ;
    }
    public static void main(String[] args) {
        _22_KthFromEnd obj = new _22_KthFromEnd() ;
        ListNode node5 = new ListNode(5) ;
        ListNode node4 = new ListNode(4 , node5) ;
        ListNode node3 = new ListNode(3 , node4) ;
        ListNode node2 = new ListNode(2 , node3) ;
        ListNode node1 = new ListNode(1 , node2) ;

        int k = 2 ;
        ListNode res = obj.getKthFromEnd(node1 , k) ;
        System.out.println(res.val);
    }
}
