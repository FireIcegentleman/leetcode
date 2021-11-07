package ByteDance;

import com.sun.prism.shader.AlphaOne_RadialGradient_AlphaTest_Loader;

/**
 * 2021/11/5
 *
 * 二叉树的公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * */
public class _25_LowestCommonAncestor {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找到相关的点
        if (root == null || root == p || root == q){
            return root ;
        }

        TreeNode left = lowestCommonAncestor(root.left , p , q);
        TreeNode right = lowestCommonAncestor(root.right , p , q) ;

        // 若左返回值为空，则说明在右边
        if (left == null){
            return right ;
        }
        // 若右返回值为空，则说明在左边
        if (right == null){
            return left ;
        }
        // 左右同时不为空，且在root两侧，则返回root
        return root ;
    }

    public static void main(String[] args) {
        _25_LowestCommonAncestor obj = new _25_LowestCommonAncestor() ;
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
