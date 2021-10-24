package All;

/**
 * 2021/10/23
 *
 * k个一组反转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *      你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 *      你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * */
public class _25_ReverseKGroup {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 一组为k个
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0) ;
        dummy.next = head ;

        ListNode prev = dummy , end = dummy ;

        while (end.next != null){
            for (int i = 0 ; i < k && end != null ; i++){
                end = end.next ;
            }
            if (end == null){
                break;
            }

            // 这个组的开头节点
            ListNode start = prev.next ;
            // 这个组的结尾节点
            ListNode next = end.next ;

            // 暂时把链表断开
            end.next = null ;
            prev.next = reverse(start) ;
            // 重新把链表连起来
            start.next = next ;
            prev = start ;

            end = prev ;
        }
        return dummy.next ;
    }

    // 反转链表
    private ListNode reverse(ListNode start) {
        if (start == null || start.next == null){
            return start ;
        }
        ListNode prev = null ;
        ListNode cur = start ;

        while (cur != null){
            ListNode next = cur.next ;
            cur.next = prev ;
            prev = cur ;
            cur = next ;
        }
        // 注意要反悔返回的值
        return prev ;
    }


    public static void main(String[] args) {
        _25_ReverseKGroup obj = new _25_ReverseKGroup() ;
        ListNode node5 = new ListNode(5) ;
        ListNode node4 = new ListNode(4 , node5) ;
        ListNode node3 = new ListNode(3 , node4) ;
        ListNode node2 = new ListNode(2 , node3) ;
        ListNode node1 = new ListNode(1 , node2) ;

        int target = 2 ;
        ListNode res = obj.reverseKGroup(node1 , target) ;
        System.out.print(res.val);
    }

}
