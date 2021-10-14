import org.jetbrains.annotations.Contract;

import java.util.PriorityQueue;

/**
 * 2021/5/10
 * leetcode 23
 * 未做出，使用优先队列，思路简单
 * */
public class _23_MergeKSortedLists {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a,b) ->{
            if(a.val > b.val){
                return 1 ;
            }else if(a.val < b.val){
                return -1 ;
            }
            return 0;
        });

        // put every front node of each listnode into the PriorityQueue
        for(ListNode node : lists){
            if(node != null){
                queue.add(node) ;
            }
        }

        ListNode dummy = new ListNode() ;
        ListNode head = dummy;

        while(!queue.isEmpty()){
            ListNode node = queue.poll() ;// 取出队列头元素
            if(node != null){
                dummy.next = node ;
                dummy = dummy.next ;
                if(node.next != null){
                    queue.add(node.next) ;
                }
            }
        }
        return head.next ;

    }
    public static void main(String[] args) {
        ListNode l1_3 = new ListNode(5);
        ListNode l1_2 = new ListNode(4 , l1_3);
        ListNode l1 = new ListNode(1,l1_2);


        ListNode l2_3 = new ListNode(4);
        ListNode l2_2 = new ListNode(3 , l2_3);
        ListNode l2 = new ListNode(1,l2_2);


        ListNode l3_2 = new ListNode(6);
        ListNode l3 = new ListNode(2,l3_2);
        ListNode[] list = {l1 , l2 , l3} ;
        _23_MergeKSortedLists obj = new _23_MergeKSortedLists() ;
        ListNode res = obj.mergeKLists(list) ;

        while(res != null){
            System.out.print(res.val);
            res = res.next ;
        }
    }
}

/**
 * 这个题目自己做不出来，参考答案给出，相关的知识点罗列在下面
 * 1. Java PriorityQueue
 *    PriorityQueue和Queue的区别在于，它的出队顺序与元素的优先级有关，对PriorityQueue调用remove()或poll()方法，返回的总是优先级最高的元素。
 *    要使用PriorityQueue，我们就必须给每个元素定义“优先级”。
 *  到头来这种解法完全依赖了优先队列对不同队列元素大小的自动判断，不用考虑数据量，思路也就变得尤其简单了
 * */
