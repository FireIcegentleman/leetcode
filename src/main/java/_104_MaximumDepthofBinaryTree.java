/**
 * 2021/09/13
 * 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点.
 * */
public class _104_MaximumDepthofBinaryTree {
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
    private int getmaxDepth(TreeNode root, int res) {
        if(root == null){
            return res ;
        }
        return Math.max(getmaxDepth(root.left , res + 1) , getmaxDepth(root.right , res + 1)) ;
    }

    // 求解二叉树的最大深度
    public int maxDepth(TreeNode root) {
        int res = 0 ;
        if(root == null){
            return res ;
        }

        return getmaxDepth(root , res) ;
    }

    public static void main(String[] args) {
        _104_MaximumDepthofBinaryTree obj = new _104_MaximumDepthofBinaryTree() ;
        TreeNode node15 = new TreeNode(15) ;
        TreeNode node7 = new TreeNode(7) ;
        TreeNode node20 = new TreeNode(20 , node15 , node7) ;
        TreeNode node9 = new TreeNode(9) ;
        TreeNode node3 = new TreeNode(3 , node9 , node20) ;
        System.out.print(obj.maxDepth(node3));
    }
}
