package SwordOffer;

import java.util.*;

/**
 * 2021/10/07
 *
 * 从上到下打印二叉树
 *
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * 层次遍历
 * */
public class _32_LevelOrder {
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
    // 层次遍历
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0] ;
        }
        List<Integer> list = new ArrayList<>() ;

        Deque<TreeNode> q = new ArrayDeque<>() ;
        q.addLast(root);

        TreeNode peek = new TreeNode(0) ;
        while (!q.isEmpty()){
            peek = q.poll();
            if (peek != null){
                list.add(peek.val) ;
            }
            if(peek.left != null){
                q.addLast(peek.left);
            }
            if(peek.right != null){
                q.addLast(peek.right);
            }
        }

        int[] res = new int[list.size()] ;
        for (int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i) ;
        }

        return res ;
    }
    public static void main(String[] args) {
        _32_LevelOrder obj = new _32_LevelOrder() ;
        TreeNode node15 = new TreeNode(15) ;
        TreeNode node7 = new TreeNode(7) ;

        TreeNode node9 = new TreeNode(9) ;

        TreeNode node20 = new TreeNode(20 , node15 , node7) ;

        TreeNode node3 = new TreeNode(3 , node9 , node20) ;

        System.out.println(Arrays.toString(obj.levelOrder(node3)));
    }
}
