/**
 * 2021/5/12
 * 缅怀2008汶川地震中丧失的同胞们
 *
 * 这道题也太难了。。。
 * 分组操作的思路，确顶每一次的pre都是下一组的前置节点
 * 尤其注意循环条件的设定
 * */
public class _25_ReverseNodesInK_Group {
    public static class ListNode {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0) ;
        ListNode pre = dummy ;
        ListNode cur = dummy ;
        dummy.next = head ;
        int num = 0 ; // 节点总数

        while(cur.next != null){
            num += 1 ;
            cur = cur.next ;
        }

        while(num >= k){
            cur = pre.next ;

            for(int i = 1 ; i < k ; i++){// 这里为什么是1，因为需要经过k-1次转换
                ListNode t = cur.next ;
                cur.next = t.next ;
                t.next = pre.next ;
                pre.next = t ;
            }

            pre = cur ;
            num -= k ;
        }

        return dummy.next ;
    }

    public static void main(String[] args) {
        _25_ReverseNodesInK_Group obj = new _25_ReverseNodesInK_Group() ;

        ListNode l1_5 = new ListNode(5);
        ListNode l1_4 = new ListNode(4 , l1_5);
        ListNode l1_3 = new ListNode(3 , l1_4);
        ListNode l1_2 = new ListNode(2 , l1_3);
        ListNode l1 = new ListNode(1 , l1_2);

        ListNode res = obj.reverseKGroup(l1 , 2) ;

        while(res != null){
            System.out.print(res.val);
            res = res.next ;
        }
    }
}
