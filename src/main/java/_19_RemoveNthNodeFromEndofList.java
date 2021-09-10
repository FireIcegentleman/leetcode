import java.util.List;

/**
 * 2021/2/8
 * leetcode 19
 * 双指针，倒数
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
 * Memory Usage: 37 MB, less than 66.24% of Java online submissions for Remove Nth Node From End of List.
 * 条件限制不多
 * */
public class _19_RemoveNthNodeFromEndofList {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 倒数，双指针
        ListNode dummy = new ListNode(0 , head) ;
        ListNode pre = dummy ;
        ListNode after = dummy ;
        for(int i = 0 ; i < n + 1; i++){
            after = after.next ;
        }
        while(after != null){
            pre = pre.next;
            after = after.next ;
        }
        pre.next = pre.next.next;
        return dummy.next ;
    }
    public static void main(String[] args) {
        _19_RemoveNthNodeFromEndofList obj = new _19_RemoveNthNodeFromEndofList() ;
        ListNode l1_5 = new ListNode(5) ;
        ListNode l1_4 = new ListNode(4,l1_5) ;
        ListNode l1_3 = new ListNode(3,l1_4) ;
        ListNode l1_2 = new ListNode(2,l1_3 ) ;
        ListNode l1 = new ListNode(1 , l1_2) ;

        ListNode res = obj.removeNthFromEnd(l1 , 2) ;
        while(res!=null){
            System.out.print(res.val + " ");
            res = res.next ;
        }
    }
}
