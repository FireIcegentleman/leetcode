package SwordOffer;
/**
 * 2021/10/04
 *
 * 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * */
public class _35_CpoyComplexList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // 复制复杂链表
    public Node copyRandomList(Node head) {
        if (head == null){
            return null ;
        }
        //1. 创建新节点，放在原节点后面
        Node p = head ;
        while (p != null){
            Node newp = new Node(p.val) ;
            newp.next = p.next ;
            p.next = newp ;
            p = newp.next ;
        }

        //2. 跟着旧节点调整新节点的random
        p = head ;
        while(p != null){
            if (p.random == null){
                p.next.random = null ;
            }else{
                p.next.random = p.random.next;
            }
            p = p.next.next ;
        }

        p = head.next;
        Node pre = head, res = head.next;
        while(p.next != null) {
            pre.next = pre.next.next;
            p.next = p.next.next;
            pre = pre.next;
            p = p.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点
    }

    public static void main(String[] args) {
        _35_CpoyComplexList obj = new _35_CpoyComplexList() ;
        Node node7 = new Node(7 );
        Node node13 = new Node(13) ;
        Node node11 = new Node(11) ;
        Node node10 = new Node(10) ;
        Node node1 = new Node(1) ;

        node7.next = node13 ;
        node7.random = null ;

        node13.next = node11 ;
        node13.random = node7 ;

        node11.next = node10 ;
        node11.random = node1 ;

        node10.next = node1 ;
        node10.random = node11 ;

        node1.next = null ;
        node1.random = node7 ;

        System.out.println(obj.copyRandomList(node7).val) ;
    }
}
