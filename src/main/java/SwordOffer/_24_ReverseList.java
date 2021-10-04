package SwordOffer;
/**
 * 2021/10/03
 *
 * 反转链表
 * */
public class _24_ReverseList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x , ListNode a) {
            val = x;
            next = a ;
        }
    }
    // 反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null ;
        }
        ListNode pre = null ;
        ListNode cur = head ;

        while(cur != null){
            ListNode nextTmp = cur.next ;
            cur.next = pre ;
            pre = cur ;
            cur = nextTmp ;
        }

        return pre ;
    }
    public static void main(String[] args) {
        _24_ReverseList obj = new _24_ReverseList() ;
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4 , node5);
        ListNode node3 = new ListNode(3 , node4);
        ListNode node2 = new ListNode(2 , node3);
        ListNode node1 = new ListNode(1 , node2);

        ListNode res = obj.reverseList(node1) ;
        System.out.println(res.val);
    }
}
