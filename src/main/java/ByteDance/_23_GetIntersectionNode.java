package ByteDance;
/**
 * 2021/11/5
 *
 * 相交链表
 *
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：
 * */
public class _23_GetIntersectionNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 找到相交时的起始节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 有一个为空
        if (headA == null || headB == null){
            return new ListNode(0) ;
        }

        ListNode p = headA ;
        ListNode q = headB ;

        while (p != null && q != null){
            p = p.next ;
            q = q.next ;
        }

        // 此时有一个为空，这个空的开始指示的为短链，现在改为指向更长的链
        if (p == null){
            p = headB ;
        }else{
            q = headA ;
        }

        // 第二个节点指向末尾
        while (p != null && q != null){
            p = p.next ;
            q = q.next ;
        }

        if (p == null){
            p = headB ;
        }else{
            q = headA ;
        }

        while (p != q){
            p = p.next ;
            q = q.next ;
        }
        return p ;
    }
    public static void main(String[] args) {
        _23_GetIntersectionNode obj = new _23_GetIntersectionNode() ;
        ListNode node5 = new ListNode(5) ;
        ListNode node4 = new ListNode(4 , node5) ;
        ListNode node8 = new ListNode(8 , node4) ;

        ListNode node11 = new ListNode(1 , node8) ;
        ListNode node14 = new ListNode(4 , node11) ;

        ListNode node21 = new ListNode(1 , node8) ;
        ListNode node22 = new ListNode(0 , node21) ;
        ListNode node25 = new ListNode(5 , node22) ;

        ListNode res = obj.getIntersectionNode(node14 , node25) ;

        System.out.println(res.val);
    }
}
