package SwordOffer;

import java.util.*;

/**
 * 2021/09/30
 *
 * 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * */
public class _6_ReversePrint {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x , ListNode a) {
            val = x;
            next = a ;
        }
    }

    public int[] reversePrint_(ListNode head) {
        List<Integer> num = new ArrayList<>() ;

        ListNode p = head ;
        while(p != null){
            num.add(p.val) ;
            p = p.next ;
        }
        Collections.reverse(num);
        return num.stream().mapToInt(Integer::intValue).toArray() ;
    }

    // 遍历放在前面
    public int[] reversePrint(ListNode head) {
        Deque<Integer> queue = new ArrayDeque<>() ;
        ListNode p = head ;
        while(p != null){
            queue.addFirst(p.val);
            p = p.next ;
        }

        int[] res = new int[queue.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = queue.pollFirst();
        return res ;
    }
    public static void main(String[] args) {
        _6_ReversePrint obj = new _6_ReversePrint() ;
        ListNode node2 = new ListNode(2 );
        ListNode node3 = new ListNode(3 , node2);
        ListNode node1 = new ListNode(1 , node3 );
        System.out.println(Arrays.toString(obj.reversePrint(node1)));
    }
}
