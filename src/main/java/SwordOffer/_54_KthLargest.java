package SwordOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2021/10/11
 *
 * 二叉搜索树的第k大节点
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * */
public class _54_KthLargest {
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

    public List<Integer> num ;
    // 利用二叉搜索树的性质
    // 第k大
    // 1. 简单方法：遍历然后找到第k大的节点
    public int kthLargest_force(TreeNode root, int k) {
        num = new ArrayList<>() ;
        memory(root) ;

        return num.get(num.size() - k) ;
    }

    private void memory(TreeNode root) {
        if (root.left != null){
            memory(root.left);
        }

        if (root == null){
            return;
        }

        num.add(root.val) ;

        if (root.right != null){
            memory(root.right);
        }
    }

    public int k , res ;
    // 性质：二叉搜索树的中序遍历为递增序列
    // 中序遍历倒序则为递减序列，则问题可以转换为 求此树中序遍历倒序的第k个节点
    public int kthLargest(TreeNode root, int k) {
        this.k = k ;
        dfs(root) ;
        return res ;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }
        dfs(root.right) ;
        // 提前终止，即返回
        if (k == 0){
            return;
        }
        if (--k == 0){
            res = root.val ;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        _54_KthLargest obj = new _54_KthLargest() ;
        TreeNode node1 = new TreeNode(1) ;
        TreeNode node2 = new TreeNode(2 , node1 , null) ;
        TreeNode node4 = new TreeNode(4) ;

        TreeNode node3 = new TreeNode(3 , node2 , node4) ;

        TreeNode node6 = new TreeNode(6) ;

        TreeNode node5 = new TreeNode(5 , node3 , node6) ;

        System.out.print(obj.kthLargest(node5 , 3));
    }
}
