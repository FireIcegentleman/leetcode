package ByteDance;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;
import sun.rmi.log.LogInputStream;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2021/11/5
 *
 * 合并k个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * */
public class _24_MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // 两种方法：优先队列和归并操作
    // 法1:优先队列
    public ListNode mergeKLists_queue(ListNode[] lists) {
        ListNode dummy = new ListNode(0) ;
        ListNode p = dummy ;

        if (lists.length == 0){
            return dummy.next ;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val ;
            }
        }) ;

        for (ListNode head : lists){
            if (head != null){
                queue.add(head) ;
            }
        }

        while (!queue.isEmpty()){
            ListNode cur = queue.poll() ;
            p.next = cur ;
            p = p.next ;

            if (cur.next != null){
                queue.add(cur.next) ;
            }
        }
        return dummy.next ;
    }

    // 法2:归并方法
    public ListNode mergeKLists(ListNode[] lists) {
        return sort(lists , 0 , lists.length - 1) ;
    }

    private ListNode sort(ListNode[] lists, int l, int r) {
        if (l > r){
            return null ;
        }

        if (l == r){
            return lists[l] ;
        }

        int mid = (l + r) >> 1 ;
        ListNode left = sort(lists , l , mid) ;
        ListNode right = sort(lists , mid + 1 , r) ;

        return merge(left , right) ;
    }

    // 合并两个排序链表
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0) ;
        ListNode cur = dummy ;
        ListNode p = left , q = right ;

        while (p != null && q != null){
            if (p.val < q.val){
                cur.next = p ;
                p = p.next ;
            }else{
                cur.next = q ;
                q = q.next ;
            }
            cur = cur.next ;
        }

        while (p != null){
            cur.next = p ;
            p = p.next ;
            cur = cur.next ;
        }
        while (q != null){
            cur.next = q ;
            q = q.next ;
            cur = cur.next ;
        }
        return dummy.next ;
    }

    public static void main(String[] args) {
        _24_MergeKLists obj = new _24_MergeKLists() ;
        ListNode node15 = new ListNode(5) ;
        ListNode node14 = new ListNode(4 , node15) ;
        ListNode node11 = new ListNode(1 , node14) ;

        ListNode node24 = new ListNode(4) ;
        ListNode node23 = new ListNode(3 , node24) ;
        ListNode node21 = new ListNode(1 , node23) ;

        ListNode node36 = new ListNode(6) ;
        ListNode node32 = new ListNode(2 , node36) ;

        ListNode[] list = {node11 , node21 , node32} ;
        //ListNode[] list = {new ListNode()} ;
        ListNode res = obj.mergeKLists(list) ;
        System.out.println(res.val);
    }
}
