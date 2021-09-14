/**
 * 2021/09/14
 * 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 * */
public class _142_LinkedListCycleII {
    public static class  ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // 寻找第一个入环的节点
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head ;
        ListNode fast = head ;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;

            // 此时slow在相遇点
            if(slow == fast){
                break ;
            }
        }

        // 为什么需要保证这个？
        if(fast == null || fast.next == null){
            return null ;
        }
        // 令a为环外长度，b为入环后的相遇位置，c为相遇点到入环点的距离
        // 有 a+(n+1)b+nc = 2(a+b)(fast指针走过的路等于两倍的slow指针走过的路)
        // 再申请一个指针为ptr指向头部，和slow每次向后移动一个位置，最终他们会在入环点相遇
        ListNode ptr = head ;

        while(ptr != slow){
            ptr = ptr.next ;
            slow = slow.next ;
        }

        return ptr ;
    }
    public static void main(String[] args) {
        _142_LinkedListCycleII obj = new _142_LinkedListCycleII() ;
        ListNode node_4 = new ListNode(-4) ;
        ListNode node0 = new ListNode(0 , node_4) ;
        ListNode node2 = new ListNode(2 , node0) ;
        ListNode node3 = new ListNode(3 , node2) ;
        node_4.next = node2 ;
        System.out.println(obj.detectCycle(node3).val);
    }
}
/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
 * */
