package SwordOffer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * 2021/10/07
 *
 * 从上到下打印二叉树III
 *
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * */
public class _32_LevelOrderIII {
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
    // 之字形打印
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>() ;
        LinkedList<Integer> out = new LinkedList<>();

        if (root == null){
            return res ;
        }

        Deque<TreeNode> q = new ArrayDeque<>() ;
        q.addLast(root);
        TreeNode tmp = new TreeNode(0) ;

        // true表示正向
        // false表示反向
        int width = 0 ;
        while (!q.isEmpty()){
            width = q.size() ;
            while (width > 0){
                tmp = q.pollFirst() ;
                if (res.size() % 2 != 0){// 偶数层，倒序
                    out.addFirst(tmp.val);
                }else{
                    out.addLast(tmp.val);
                }
                if (tmp.left != null){
                    q.addLast(tmp.left);
                }
                if (tmp.right != null){
                    q.addLast(tmp.right);
                }
                width-- ;
            }
            res.add(new ArrayList<>(out));
            out.clear();
        }
        return res ;
    }

    public static void main(String[] args) {
        _32_LevelOrderIII obj = new _32_LevelOrderIII() ;

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
