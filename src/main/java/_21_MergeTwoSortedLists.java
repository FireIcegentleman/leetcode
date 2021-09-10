/**
 * 2021/2/8
 * leetcode 21
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
 * Memory Usage: 38.7 MB, less than 30.27% of Java online submissions for Merge Two Sorted Lists.
 * */
public class _21_MergeTwoSortedLists {
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0) ;
        if(l1 == null && l2 == null){
            return dummy.next;
        }
        if(l1 == null){
            return l2 ;
        }
        if(l2 == null){
            return l1 ;
        }
        if(l1.val <= l2.val){
            dummy.next = l1;
            l1 = l1.next ;
        }else{
            dummy.next = l2;
            l2 = l2.next ;
        }
        ListNode cur = dummy.next ;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1 ;
                cur = cur.next ;
                l1 = l1.next ;
            }else if(l1.val > l2.val){
                cur.next = l2 ;
                cur = cur.next ;
                l2 = l2.next ;
            }
        }
        if(l1 != null){
            while(l1 != null){
                cur.next = l1 ;
                cur = cur.next ;
                l1 = l1.next ;
            }
        }
        if(l2 != null){
            while(l2 != null){
                cur.next = l2 ;
                cur = cur.next ;
                l2 = l2.next ;
            }

        }
        return dummy.next ;
    }
    public static void main(String[] args) {
        ListNode l1_3 = new ListNode(4) ;
        ListNode l1_2 = new ListNode(2 , l1_3) ;
        ListNode l1 = new ListNode(1 , l1_2) ;

        ListNode l2_3 = new ListNode(4) ;
        ListNode l2_2 = new ListNode(3 , l2_3) ;
        ListNode l2 = new ListNode(1 , l2_2) ;

        _21_MergeTwoSortedLists obj = new _21_MergeTwoSortedLists() ;
        ListNode res = obj.mergeTwoLists(l1 ,l2) ;
        while(res!=null){
            System.out.print(res.val + " ");
            res = res.next ;
        }
    }
}
