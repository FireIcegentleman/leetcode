import java.rmi.server.UnicastRemoteObject;
import java.util.*;

/**
 * 2021/09/16
 * 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * */
public class _206_ReverseLinkedList {
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
    public ListNode reverseList_num(ListNode head) {
        ListNode p = head ;
        List<Integer> num = new ArrayList<>() ;

        while(p != null){
            num.add(p.val) ;
            p = p.next ;
        }
        // 数组反转
        Collections.reverse(num);

        ListNode dummy = new ListNode(0 , head) ;
        p = dummy ;
        for(int i = 0 ; i < num.size() ; i++){
            ListNode t = new ListNode(num.get(i)) ;
            p.next = t ;
            p = p.next ;
        }

        return dummy.next ;
    }

    public ListNode reverseList(ListNode head) {
       ListNode prev = null ;
       ListNode cur = head ;

       while(cur != null){
           // 记录原本的下一个节点
           ListNode nextTmp = cur.next ;
           // 指向前一个节点
           cur.next = prev ;
           // 更新最近节点
           prev = cur ;
           cur = nextTmp ;
       }
       return prev ;
    }
    public static void main(String[] args) {
        _206_ReverseLinkedList obj = new _206_ReverseLinkedList() ;
        ListNode node5 = new ListNode(5) ;
        ListNode node4 = new ListNode(4 , node5) ;
        ListNode node3 = new ListNode(3 , node4) ;
        ListNode node2 = new ListNode(2 , node3) ;
        ListNode node1 = new ListNode(1 , node2) ;

        ListNode res = obj.reverseList(node1) ;
        System.out.println(res.val);
    }
}
