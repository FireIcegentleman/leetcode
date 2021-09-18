import java.util.ArrayList;
import java.util.List;

/**
 * 2021/09/18
 * 二叉树的最近公共祖先
 * */

public class _236_LowestCommonAncestorofaBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 在树中寻找节点p，并将经过的节点数值加入list

    // 寻找p,q的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root ;
        }
        TreeNode left = lowestCommonAncestor(root.left , p , q) ;
        TreeNode right = lowestCommonAncestor(root.right , p , q) ;

        if (left == null){
            return right ;
        }
        if(right == null){
            return left ;
        }
        return root ;
    }


    public static void main(String[] args) {
        _236_LowestCommonAncestorofaBinaryTree obj = new _236_LowestCommonAncestorofaBinaryTree() ;
        TreeNode node7 = new TreeNode(7) ;
        TreeNode node4 = new TreeNode(4) ;

        TreeNode node6 = new TreeNode(6) ;
        TreeNode node2 = new TreeNode(2 , node7 , node4) ;
        TreeNode node0 = new TreeNode(0) ;
        TreeNode node8 = new TreeNode(8) ;

        TreeNode node5 = new TreeNode(5 , node6 , node2) ;
        TreeNode node1 = new TreeNode(1 , node0 , node8) ;
        TreeNode node3 = new TreeNode(3 , node5 , node1) ;

        TreeNode res = obj.lowestCommonAncestor(node3 , node5 , node4) ;
        System.out.print(res.val);
    }
}
