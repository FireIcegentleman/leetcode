package SwordOffer;

import sun.reflect.generics.tree.Tree;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 2021/10/08
 *
 * 二叉树中和为某一值的路径
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 * */
public class _34_PathSum {
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

    // 遍历所有根节点到叶节点的路径，如果大于target则剪枝，到达叶节点则判断是否等于target，如果等于则加入到结果里
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>() ;
        List<Integer> out = new ArrayList<>() ;

        if (root == null){
            return res ;
        }
        path(root , res , out , 0 , target) ;
        return res ;
    }

    private void path(TreeNode root, List<List<Integer>> res, List<Integer> out, int cur, int target) {
        cur += root.val ;
        out.add(root.val) ;

        if (root.left == null && root.right == null){// 到达叶节点
            if (cur == target){
                res.add(new ArrayList<>(out)) ;
            }else{
                return;
            }
        }
        // 继续遍历左右子树
        if (root.left != null){
            path(root.left , res , out , cur , target) ;
            out.remove(out.size() - 1) ;
        }

        if (root.right != null){
            path(root.right , res , out , cur , target) ;
            out.remove(out.size() - 1) ;
        }
    }

    public static void main(String[] args) {
        _34_PathSum obj  = new _34_PathSum() ;
        /*TreeNode node7 = new TreeNode(7) ;
        TreeNode node2 = new TreeNode(2) ;
        TreeNode node5 = new TreeNode(5) ;
        TreeNode node1 = new TreeNode(1) ;

        TreeNode node11 = new TreeNode(11 , node7 , node2) ;
        TreeNode node13 = new TreeNode(13) ;

        TreeNode node4 = new TreeNode(4 , node5 , node1) ;


        TreeNode nodetop4 = new TreeNode(4 , node11 , null) ;
        TreeNode node8 = new TreeNode(8 , node13 , node4) ;

        TreeNode nodetop5 = new TreeNode(5 , nodetop4 , node8) ;

        int target = 22 ;*/
        TreeNode node_3 = new TreeNode(-3) ;
        TreeNode node_2 = new TreeNode(-2 , null , node_3) ;
        List<List<Integer>> res = obj.pathSum(node_2 , -5) ;

        for (int i = 0 ; i < res.size() ; i++){
            System.out.print("[");
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.print("]");
        }
    }
}
