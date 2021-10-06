package SwordOffer;

import java.lang.reflect.AnnotatedType;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 2021/10/06
 *
 * 序列化二叉树
 *
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * */
public class _37_SerializeTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x , TreeNode left , TreeNode right){
            val = x ;
            this.left = left ;
            this.right = right ;
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "X" ;
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right) ;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_char = data.split(",") ;
        Deque<String> dp = new LinkedList<>(Arrays.asList(data_char)) ;
        return buildTree(dp) ;
    }

    private TreeNode buildTree(Deque<String> dp) {
        String cur = dp.poll() ;// 当前节点
        if (cur.equals("X")){
            return null ;
        }

        TreeNode root = new TreeNode(Integer.parseInt(cur)) ;
        root.left = buildTree(dp) ;
        root.right = buildTree(dp) ;
        return root ;
    }


    public static void main(String[] args) {
        _37_SerializeTree obj = new _37_SerializeTree() ;
        TreeNode node4 = new TreeNode(4) ;
        TreeNode node5 = new TreeNode(5) ;

        TreeNode node3 = new TreeNode(3 , node4 , node5) ;
        TreeNode node2 = new TreeNode(2) ;

        TreeNode node1 = new TreeNode(1 , node2 , node3) ;
        String serialization = obj.serialize(node1) ;
        TreeNode res = obj.deserialize(serialization) ;
        System.out.print(res.val);
    }
}
