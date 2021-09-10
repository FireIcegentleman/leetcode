/**
 * 2021/5/10
 * leetcode 24
 * 交换两个临近数组
 *
 * 开始未想到
 * */
public class _24_SwapNodesinPairs {
    public static class ListNode {
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1) ;
        ListNode pre = dummy ;
        dummy.next = head ;

        while(pre.next != null && pre.next.next != null){
            ListNode tmp = pre.next.next ;
            pre.next.next = tmp.next ;
            tmp.next = pre.next ;
            pre.next = tmp ;
            pre = tmp.next ;
        }
        return dummy.next ;
    }

    public static void main(String[] args) {
        _24_SwapNodesinPairs obj = new _24_SwapNodesinPairs() ;
        ListNode l1_4 = new ListNode(4);
        ListNode l1_3 = new ListNode(3,l1_4);
        ListNode l1_2 = new ListNode(2 , l1_3);
        ListNode l1 = new ListNode(1,l1_2);

        ListNode res = obj.swapPairs(l1) ;

        while(res != null){
            System.out.print(res.val);
            res = res.next ;
        }
    }
}

/**
 * 肯定使用循环，并且每个循环执行的内容是一样的
 * 所以pre的指定很重要
 * */
