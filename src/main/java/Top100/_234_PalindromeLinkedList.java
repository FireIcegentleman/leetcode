import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2021/09/17
 * 回文链表
 *
 * 给你一个单链表的头节点head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * */
public class _234_PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome_store(ListNode head) {
        if (head == null){
            return true ;
        }

        ListNode p = head ;

        List<Integer> num = new ArrayList<>() ;
        while(p != null){
            num.add(p.val) ;
            p = p.next ;
        }

        List<Integer> num_rev = new ArrayList<>(num) ;
        Collections.reverse(num_rev);

        for (int i = 0 ; i < num.size() ; i++){
            if(!num.get(i).equals(num_rev.get(i))){
                return false ;
            }
        }

        return true ;
    }

    public boolean isPalindrome(ListNode head) {
       if (head == null || head.next == null){
           return true ;
       }

       ListNode fast = head , slow = head ;
       ListNode pre = head , prepare = null ;

       while(fast != null && fast.next != null){
           pre = slow ;
           slow = slow.next ;
           fast = fast.next.next ;
           // 反转
           pre.next = prepare ;
           prepare  = pre ;
       }
       if (fast != null){
           slow = slow.next ;
       }

       while (slow != null && pre != null){
           if(slow.val != pre.val){
               return false ;
           }
           slow = slow.next ;
           pre = pre.next ;
       }
       return true ;
    }
    public static void main(String[] args) {
        _234_PalindromeLinkedList obj = new _234_PalindromeLinkedList() ;
        ListNode node1 = new ListNode(1) ;
        ListNode node2 = new ListNode(2 , node1);
        ListNode node_2 = new ListNode(2 , node2);
        ListNode node_1 = new ListNode(1 , node_2);

        System.out.print(obj.isPalindrome(node_1));
    }
}
