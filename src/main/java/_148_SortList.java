/**
 * 2021/09/15
 * 排序链表
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：你可以在 O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * */

public class _148_SortList {
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
    // 归并排序法
    public ListNode sortList(ListNode head) {
        return sortList(head , null) ;
    }

    public ListNode sortList(ListNode head , ListNode tail) {
        // 注意这两个判断条件
        if (head == null){
            return head ;
        }
        if(head.next == tail){
            head.next = null ;
            return head ;
        }

        ListNode slow = head , fast = head ;
        while(fast != tail){
            slow = slow.next ;
            fast = fast.next ;
            if (fast != tail){
                fast = fast.next ;
            }
        }

        // 此时slow指向链表中点位置
        ListNode l1 = sortList(head , slow) ;
        ListNode l2 = sortList(slow ,tail) ;
        return merge(l1 , l2) ;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0) ;
        ListNode tmp = dummy , tmp1 = l1 , tmp2 = l2 ;

        while(tmp1 != null && tmp2 != null){
            if(tmp1.val < tmp2.val){
                tmp.next = tmp1 ;
                tmp1 = tmp1.next ;
            }else{
                tmp.next = tmp2 ;
                tmp2 = tmp2.next ;
            }
            tmp = tmp.next ;
        }

        if(tmp1 != null){
            tmp.next = tmp1 ;
        }

        if(tmp2 != null){
            tmp.next = tmp2 ;
        }

        return dummy.next ;
    }

    public static void main(String[] args) {
        _148_SortList obj = new _148_SortList() ;
        ListNode node3 = new ListNode(3) ;
        ListNode node1 = new ListNode(1 , node3) ;
        ListNode node2 = new ListNode(2 , node1) ;
        ListNode node4 = new ListNode(4 , node2) ;
        ListNode root = obj.sortList(node4) ;
        ListNode t = root ;
        return ;
    }
}
