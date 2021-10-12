package SwordOffer;
/**
 * 2021/10/08
 *
 * 二叉树深度
 *
 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * */
public class _55_MaxDepth {
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

    // 返回二叉树的深度
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0 ;
        }

        return Math.max(maxDepth(root.left) + 1 , maxDepth(root.right) + 1) ;
    }

    public static void main(String[] args) {
        _55_MaxDepth obj = new _55_MaxDepth() ;

        TreeNode node15 = new TreeNode(15) ;
        TreeNode node7 = new TreeNode(7) ;

        TreeNode node9 = new TreeNode(9) ;

        TreeNode node20 = new TreeNode(20 , node15 , node7) ;

        TreeNode node3 = new TreeNode(3 , node9 , node20) ;

        System.out.print(obj.maxDepth(node3));
    }
}
