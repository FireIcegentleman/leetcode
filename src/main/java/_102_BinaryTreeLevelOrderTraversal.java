import java.util.*;

/**
 * 2021/09/13
 *  二叉树的层序遍历
 *
 *  给你一个二叉树，请你返回其按 层序遍历 得到的节点值。（即逐层地，从左到右访问所有节点）。
 * */

public class _102_BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 宽度优先遍历，借助队列的方案
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>() ;

        if(root == null){
            return res ;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root) ;

        // 当队列不为空的时候
        while(!q.isEmpty()){
            // 宽度等于本轮队列里的个数
            int width = q.size() ;
            List<Integer> out = new ArrayList<>() ;
            for(int i = 0 ; i < width ; i++){
                // 返回上一层的每一格元素
                TreeNode p = q.pop();
                out.add(p.val) ;
                if(p.left != null){
                    q.addLast(p.left);
                }
                if(p.right != null){
                    q.addLast(p.right) ;
                }
            }
            res.add(out) ;
        }

        return res ;
    }
    public static void main(String[] args) {
        _102_BinaryTreeLevelOrderTraversal obj = new _102_BinaryTreeLevelOrderTraversal() ;
        TreeNode node15 = new TreeNode(15) ;
        TreeNode node7 = new TreeNode(7) ;
        TreeNode node20 = new TreeNode(20 , node15 , node7) ;
        TreeNode node9 = new TreeNode(9) ;
        TreeNode node3 = new TreeNode(3 , node9 , node20) ;

        List<List<Integer>> res = obj.levelOrder(node3) ;
        for(int i = 0 ; i < res.size() ; i++){
            System.out.print("[");
            for(int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println("]");
        }
    }
}
