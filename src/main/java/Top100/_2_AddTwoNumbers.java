/**
 * 2021/1/18
 * leetcode 2
 * Runtime: 2 ms, faster than 76.94% of Java online submissions for Add Two Numbers.
 * Memory Usage: 39.3 MB, less than 58.93% of Java online submissions for Add Two Numbers.
 *
 * 代码问题：重复判断过多
 * 改进版本：用或的思路
 * */
public class _2_AddTwoNumbers {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode begin = dummy ;
        int sum = 0 ;
        int flag = 0 ;
        while(l1 != null && l2 != null){
            sum = (l1.val + l2.val + flag) % 10 ;
            flag = (l1.val + l2.val + flag) / 10 ;
            begin.next = new ListNode(sum) ;
            begin = begin.next ;
            l1 = l1.next ;
            l2 = l2.next ;
        }
        if(l1 != null){
            while(l1 != null){
                sum = (l1.val + flag) % 10 ;
                flag = (l1.val + flag) / 10 ;
                begin.next = new ListNode(sum) ;
                begin = begin.next ;
                l1 = l1.next ;
            }
            if(flag != 0){
                begin.next = new ListNode(1) ;
            }
        }
        if(l2 != null){
            while(l2 != null){
                sum = (l2.val + flag) % 10 ;
                flag = (l2.val + flag) / 10 ;
                begin.next = new ListNode(sum) ;
                begin = begin.next ;
                l2 = l2.next ;
            }
            if(flag != 0){
                begin.next = new ListNode(1) ;
            }
        }
        if(flag != 0){
            begin.next = new ListNode(1) ;
        }
        return dummy.next ;
    }

    public static void main(String[] args) {
        ListNode l1_3 = new ListNode(9) ;
        ListNode l1_2 = new ListNode(4 , l1_3) ;
        ListNode l1 = new ListNode(2 , l1_2) ;

        ListNode l2_4 = new ListNode(9) ;
        ListNode l2_3 = new ListNode(4 , l2_4) ;
        ListNode l2_2 = new ListNode(6 , l2_3) ;
        ListNode l2 = new ListNode(5 , l2_2) ;

        ListNode l = addTwoNumbers(l1 , l2) ;
        while(l!=null){
            System.out.print(l.val + " ");
            l = l.next ;
        }
    }
}
/** 示例代码
 *    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
 *     ListNode dummyHead = new ListNode(0);
 *     ListNode p = l1, q = l2, curr = dummyHead;
 *     int carry = 0;
 *     while (p != null || q != null) {
 *         int x = (p != null) ? p.val : 0;
 *         int y = (q != null) ? q.val : 0;
 *         int sum = carry + x + y;
 *         carry = sum / 10;
 *         curr.next = new ListNode(sum % 10);
 *         curr = curr.next;
 *         if (p != null) p = p.next;
 *         if (q != null) q = q.next;
 *     }
 *     if (carry > 0) {
 *         curr.next = new ListNode(carry);
 *     }
 *     return dummyHead.next;
 * }
*/