package SwordOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 2021/10/07
 *
 * 从上到下打印二叉树II
 *
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 层次遍历
 * */
public class _32_LevelOrderII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x , TreeNode left , TreeNode right) {
            val = x;
            this.left = left ;
            this.right = right ;
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>(0) ;
        }

        List<List<Integer>> res = new ArrayList<>() ;
        List<Integer> out = new ArrayList<>() ;

        Deque<TreeNode> q = new ArrayDeque<>() ;
        q.addLast(root);
        int width = 0 ;
        TreeNode tmp = new TreeNode(0) ;

        while (!q.isEmpty()){
            width = q.size() ;
            while (width > 0){
                tmp = q.pollFirst() ;
                out.add(tmp.val) ;
                if (tmp.left != null){
                    q.addLast(tmp.left);
                }
                if (tmp.right != null){
                    q.addLast(tmp.right);
                }
                width -- ;
            }
            res.add(new ArrayList<>(out)) ;
            out.clear();
        }

        return res ;
    }

    public static void main(String[] args) {
        _32_LevelOrderII obj = new _32_LevelOrderII() ;
        TreeNode node15 = new TreeNode(15) ;
        TreeNode node7 = new TreeNode(7) ;

        TreeNode node9 = new TreeNode(9) ;

        TreeNode node20 = new TreeNode(20 , node15 , node7) ;

        TreeNode node3 = new TreeNode(3 , node9 , node20) ;

        List<List<Integer>> res = obj.levelOrder(node3) ;

        System.out.print("[");
        for (int i = 0 ; i < res.size() ; i++){
            System.out.print("[");
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println("]");
        }
        System.out.print("]");

    }
}
