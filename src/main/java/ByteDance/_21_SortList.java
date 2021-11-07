package ByteDance;
/**
 * 2021/11/2
 *
 * 排序链表
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *    你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * */
public class _21_SortList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 返回排序的结果
    // 时间复杂度是O(nlogn)，常数级空间复杂度
    // 快排的时间复杂度是O(n^2)
    public ListNode sortList_bullon(ListNode head) {
        // 冒泡排序
        if (head == null){
            return null;
        }
        // 当前已排序好的节点位置
        ListNode cur = head , p = head.next ;

        while (cur != null){
            p = cur.next ;
            while (p != null){
                if (p.val < cur.val){
                    swap(p , cur);
                }
                p = p.next ;
            }
            cur = cur.next ;
        }

        return head ;
    }

    // 题目需要使用快速排序、堆排序、希尔排序、归并排序等，但是要求常数空间复杂度
    // 所以使用归并排序
    private ListNode sortList(ListNode head) {
        return sortList(head , null) ;
    }

    private ListNode sortList(ListNode head , ListNode tail){
        if (head == null){
            return null ;
        }
        // 将两边的链表从中间断开
        if (head.next == tail){
            head.next = null ;
            return head ;
        }

        ListNode fast = head , slow = head ;

        // 快慢指针遍历到中点的位置
        while (fast != tail){
            slow = slow.next ;
            fast = fast.next ;
            if (fast != tail){
                fast = fast.next ;
            }
        }

        ListNode l1 = sortList(head , slow) ;
        ListNode l2 = sortList(slow , tail) ;

        return merge(l1 , l2) ;
    }

    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0) ;
        ListNode cur = dummy ;
        ListNode p = l1 , q = l2 ;

        while (p != null && q != null){
            if (p.val < q.val){
                cur.next = p ;
                p = p.next ;
                cur = cur.next ;
            }else{
                cur.next = q ;
                q = q.next ;
                cur = cur.next ;
            }
        }

        while (p != null){
            cur.next = p ;
            p = p.next ;
            // 不能缺少最后一个节点
            cur = cur.next ;
        }
        while (q != null){
            cur.next = q ;
            q = q.next ;
            cur = cur.next ;
        }

        return dummy.next ;
    }

    private void swap(ListNode a , ListNode b){
        int tmp = a.val ;
        a.val = b.val ;
        b.val = tmp ;
    }
    public static void main(String[] args) {
        _21_SortList obj = new _21_SortList() ;
        ListNode node3 = new ListNode(3) ;
        ListNode node1 = new ListNode(1 , node3) ;
        ListNode node2 = new ListNode(2 , node1) ;
        ListNode node4 = new ListNode(4 , node2) ;
        ListNode res = obj.sortList(node4) ;

        System.out.println(res.val);
    }

}
