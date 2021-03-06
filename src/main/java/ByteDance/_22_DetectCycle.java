package ByteDance;
/**
 * 2021/11/4
 *
 * 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 * */
public class _22_DetectCycle {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 返回环的入口处的节点
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head , slow = head ;


        while (true){
            if (fast == null || fast.next == null){
                return null ;
            }
            slow = slow.next ;
            fast = fast.next.next ;

            // 当前slow在相遇位置，并且此时走了nb步
            if (slow == fast){
                break;
            }
        }

        // 若从链表开头开始走，那么走到链表入口的位置的长度应该是a + nb
        ListNode ptr = head ;

        while (ptr != slow){
            ptr = ptr.next ;
            slow = slow.next ;
        }

        return ptr ;
    }
    public static void main(String[] args) {
        _22_DetectCycle obj = new _22_DetectCycle() ;
        ListNode node_4 = new ListNode(-4) ;
        ListNode node0 = new ListNode(0 , node_4) ;
        ListNode node2 = new ListNode(2 , node0) ;
        ListNode node3 = new ListNode(3 , node2) ;
        node_4.next = node2 ;
        System.out.println(obj.detectCycle(node3).val);
    }
}
