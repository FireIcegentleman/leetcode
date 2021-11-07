package Top100;

/**
 * 2021/09/14
 * 环形链表
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * */

public class _141_LinkedListCycle {
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
    //判断是否有环路 ， 双指针
    public boolean hasCycle(ListNode head) {
        ListNode p = head ;
        ListNode q = head ;

        // 总会相遇
        while(p != null && q != null && q.next != null){
            p = p.next ;
            q = q.next.next ;
            if(p == q){
                return true ;
            }
        }
        return false ;
    }

    public static void main(String[] args) {
        _141_LinkedListCycle obj = new _141_LinkedListCycle() ;
        ListNode node_4 = new ListNode(-4) ;
        ListNode node0 = new ListNode(0 , node_4) ;
        ListNode node2 = new ListNode(2 , node0) ;
        ListNode node3 = new ListNode(3 , node2) ;
        node_4.next = node2 ;
        System.out.println(obj.hasCycle(node3));
    }
}
