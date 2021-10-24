package All;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.*;

/**
 * 2021/10/23
 *
 * 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * */
public class _23_MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists_PriorityQueue(ListNode[] lists) {
        ListNode dummy = new ListNode(0) ;
        ListNode p = dummy ;

        if (lists.length == 0){
            return dummy.next ;
        }

        // 自定义比较器
        Queue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        }) ;
        for (ListNode node : lists){
            if (node != null){
                queue.add(node);
            }
        }

        while (!queue.isEmpty()){
            // 把头部位置的链表推出来，记录第一个节点，然后后面的加到queue中
            ListNode tmp = queue.poll() ;
            p.next = tmp ;
            p = p.next ;
            if (tmp.next != null){
                queue.add(tmp.next) ;
            }
        }
        return dummy.next ;
    }

    // 分治排序的思路
    // 对于不同组别的ListNode进行分治
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists , 0 , lists.length - 1) ;
    }

    private ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r){
            return lists[l] ;
        }

        if (l > r){
            return null ;
        }

        int mid = (l + r) / 2 ;
        return mergeTwoLists(merge(lists , l , mid) , merge(lists , mid + 1 , r)) ;
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null){
            return a == null ? b : a ;
        }

        ListNode head = new ListNode(0) ;
        ListNode tail = head , aPtr = a , bPtr = b ;

        while (aPtr != null && bPtr != null){
            if (aPtr.val < bPtr.val){
                tail.next = aPtr ;
                tail = tail.next ;
                aPtr = aPtr.next ;
            }else{
                tail.next = bPtr ;
                tail = tail.next ;
                bPtr = bPtr.next ;
            }
        }
        tail.next = aPtr == null ? bPtr : aPtr ;
        return head.next ;
    }

    public static void main(String[] args) {
        _23_MergeKLists obj = new _23_MergeKLists() ;
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
