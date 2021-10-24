package All;

import SwordOffer._19_IsMatch;
import org.w3c.dom.ls.LSException;

import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import java.util.List;

/**
 * 2021/10/22
 *
 * 删除链表的倒数第N个节点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * */
public class _19_RemoveNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // 用一趟扫描实现
    // 双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0 , head) ;
        ListNode fast = dummy.next ;
        ListNode slow = dummy.next ;
        ListNode prev = dummy;

        while (n > 0){
            fast = fast.next ;
            n-- ;
        }

        while (fast != null){
            slow = slow.next ;
            prev = prev.next;
            fast = fast.next ;
        }

        prev.next = slow.next ;
        return dummy.next ;
    }
    public static void main(String[] args) {
        _19_RemoveNthFromEnd obj = new _19_RemoveNthFromEnd() ;
        /*ListNode node5 = new ListNode(5) ;
        ListNode node4 = new ListNode(4 , node5) ;
        ListNode node3 = new ListNode(3 , node4) ;
        ListNode node2 = new ListNode(2 , node3) ;*/
        ListNode node1 = new ListNode(1) ;

        ListNode res = obj.removeNthFromEnd(node1,1) ;
        System.out.print(res.val);
    }
}
