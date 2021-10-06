package SwordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 2021/10/06
 *
 * 二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * */
public class _36_TreeToDoublyList {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public List<Node> list ;
    public Node treeToDoublyList_(Node root) {
        if (root == null){
            return null ;
        }

        list = new ArrayList<>() ;
        getEntry(root) ;

        if (list.size() == 1){
            root.left = root ;
            root.right = root ;
            return root ;
        }
        Node[] node_arr = list.toArray(new Node[list.size()]) ;
        // 按照数值大小排序
        Arrays.sort(node_arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });

        Node head = node_arr[0] ;
        Node tail = node_arr[node_arr.length - 1] ;

        for (int i = 1 ; i < node_arr.length - 1 ; i++){
            node_arr[i].left = node_arr[i - 1] ;
            node_arr[i].right = node_arr[i + 1] ;
        }

        node_arr[0].left = tail ;
        node_arr[0].right = node_arr[1] ;

        node_arr[node_arr.length - 1].left = node_arr[node_arr.length - 2] ;
        node_arr[node_arr.length - 1].right = node_arr[0] ;

        return head ;
    }

    // 记录所有的节点数据
    private void getEntry(Node root) {
        if (root == null){
            return  ;
        }
        list.add(root) ;
        getEntry(root.left);
        getEntry(root.right);
    }


    Node pre , head ;
    // 二叉搜索树内含中序遍历可以从小到大访问节点
    // 考虑使用中序遍历访问树的各节点 cur ；并在访问每个节点时构建 cur 和前驱节点 pre 的引用指向；
    // 中序遍历完成后，最后构建头节点和尾节点的引用指向即可。
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null ;
        }
        dfs(root) ;
        head.left = pre ;
        pre.right = head ;
        return head ;
    }

    private void dfs(Node cur) {
        if (cur == null){
            return;
        }

        dfs(cur.left);
        if (pre != null){
            pre.right = cur ;
        }else{
            head = cur ;
        }

        cur.left = pre ;
        pre = cur ;

        dfs(cur.right);
    }

    public static void main(String[] args) {
        _36_TreeToDoublyList obj = new _36_TreeToDoublyList() ;
        Node node1 = new Node(1) ;
        Node node3 = new Node(3) ;

        Node node2 = new Node(2 , node1 , node3) ;
        Node node5 = new Node(5) ;

        Node node4 = new Node(4 , node2 , node5) ;
        Node res = obj.treeToDoublyList(node4) ;
        System.out.println(res.val);
    }
}
