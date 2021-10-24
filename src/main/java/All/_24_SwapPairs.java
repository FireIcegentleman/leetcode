package All;
/**
 * 2021/10/23
 *
 * 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * */
public class _24_SwapPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 原奇数位置的节点和原偶数位置的节点位置交换
    // 非递归解法
    public ListNode swapPairs_force(ListNode head) {
        ListNode dummy = new ListNode() ;
        dummy.next = head ;
        ListNode p = dummy.next , prev = dummy ;

        while (p != null){
            if (p.next == null){
                break;
            }
            ListNode nextTmp = p.next.next ;
            p.next.next = p ;
            prev.next = p.next ;
            prev = p ;
            p.next = nextTmp ;
            p = p.next ;
        }

        return dummy.next ;
    }

    /**
     * 可以通过递归的方式实现两两交换链表中的节点。
     * 递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
     *
     * 用 head 表示原始链表的头节点，新的链表的第二个节点，用 newHead 表示新的链表的头节点，
     * 原始链表的第二个节点，则原始链表中的其余节点的头节点是 newHead.next。
     * 令 head.next = swapPairs(newHead.next)，表示将其余节点进行两两交换，
     * 交换后的新的头节点为 head 的下一个节点。然后令 newHead.next = head，即完成了所有节点的交换。最后返回新的链表的头节点 newHead。
     * */
    // 递归解法
    public ListNode swapPairs(ListNode head) {
        // 终止条件为链表中剩余1个或没有节点
        if (head == null || head.next == null){
            return head ;
        }
        ListNode next = head.next ;
        // 向后递归
        head.next = swapPairs(next.next) ;
        next.next = head ;
        return next ;
    }
    public static void main(String[] args) {
        _24_SwapPairs obj = new _24_SwapPairs();
        ListNode node4 = new ListNode(4) ;
        ListNode node3 = new ListNode(3 , node4) ;
        ListNode node2 = new ListNode(2 , node3) ;
        ListNode node1 = new ListNode(1 , node2) ;

        ListNode res = obj.swapPairs(node1) ;
        System.out.print(res.val);
    }
}
