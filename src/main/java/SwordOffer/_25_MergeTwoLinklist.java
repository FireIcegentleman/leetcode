package SwordOffer;
/**
 * 2021/10/01
 *
 * 合并两个排序的链表
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * */
public class _25_MergeTwoLinklist {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x , ListNode a) {
            val = x;
            next = a ;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2 ;
        }
        if (l2 == null){
            return l1 ;
        }
        ListNode dummy = new ListNode(0) ;
        ListNode p = dummy ;

        if (l1.val < l2.val){
            p.next = l1 ;
            l1 = l1.next ;
            p = p.next ;
        }else{
            p.next = l2 ;
            l2 = l2.next ;
            p = p.next ;
        }
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                p.next = l1 ;
                l1 = l1.next ;
                p = p.next ;
            }else{
                p.next = l2 ;
                l2 = l2.next ;
                p = p.next ;
            }
        }

        while (l1 != null){
            p.next = l1 ;
            l1 = l1.next ;
            p = p.next ;
        }
        while (l2 != null){
            p.next = l2 ;
            l2 = l2.next ;
            p = p.next ;
        }
        return dummy.next ;
    }
    public static void main(String[] args) {
        _25_MergeTwoLinklist obj = new _25_MergeTwoLinklist() ;
        ListNode node14 = new ListNode(4) ;
        ListNode node12 = new ListNode(2 , node14) ;
        ListNode node11 = new ListNode(1 , node12) ;

        ListNode node24 = new ListNode(4) ;
        ListNode node23 = new ListNode(3 ,node24) ;
        ListNode node21 = new ListNode(1 , node23) ;
        ListNode res = obj.mergeTwoLists(node11 , node21) ;
        System.out.println(res.val);
    }
}
