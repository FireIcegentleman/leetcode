package ByteDance;

import java.util.*;
/**
 * 2021/11/5
 *
 * 二叉树的锯齿形层序遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * */
public class _26_ZigzagLevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
        TreeNode(int x, TreeNode left, TreeNode right){
            val = x ;
            this.left = left ;
            this.right = right ;
        }
    }

    // 锯齿形层序遍历
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>() ;

        if (root == null){
            return res ;
        }

        Deque<TreeNode> queue = new ArrayDeque<>() ;
        queue.addLast(root);

        // 这一遍是正向的
        boolean flag = true ;

        while (!queue.isEmpty()){
            // 本轮的宽度
            int width = queue.size() ;
            List<Integer> tmp = new ArrayList<>() ;
            while (width > 0){
                TreeNode cur = queue.pollFirst() ;
                tmp.add(cur.val) ;
                if (cur.left != null){
                    queue.addLast(cur.left);
                }
                if (cur.right != null){
                    queue.addLast(cur.right);
                }
                width-- ;
            }
            if (flag){
                res.add(tmp) ;
                flag = false ;
            }else{
                Collections.reverse(tmp);
                res.add(tmp) ;
                flag = true ;
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        _26_ZigzagLevelOrder obj = new _26_ZigzagLevelOrder() ;
        TreeNode node15 = new TreeNode(15) ;
        TreeNode node7 = new TreeNode(7) ;
        TreeNode node20 = new TreeNode(20 , node15 , node7) ;

        TreeNode node9 = new TreeNode(9) ;

        TreeNode node3 = new TreeNode(3 , node9 , node20);

        List<List<Integer>> res = obj.zigzagLevelOrder(node3);
        for (int i = 0 ; i < res.size() ; i++){
            System.out.print("[");
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println("]");
        }
    }
}
