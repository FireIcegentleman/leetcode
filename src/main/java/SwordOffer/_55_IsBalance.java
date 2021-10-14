package SwordOffer;
/**
 * 2021/10/14
 *
 * 平衡二叉树
 *
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * */
public class _55_IsBalance {
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

    // 判断一棵树是否为平衡二叉树
    public boolean isBalanced_more_time(TreeNode root) {
        if (root == null){
            return true ;
        }

        if(Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1){
            return isBalanced_more_time(root.left) && isBalanced_more_time(root.right) ;
        }

        return false ;
    }

    // 计算二叉树深度
    private int getDepth(TreeNode root) {
        if (root == null){
            return 0 ;
        }

        return Math.max(getDepth(root.left) + 1 , getDepth(root.right) + 1) ;
    }

    // 后序遍历 + 剪枝（从底到顶）
    public boolean isBalanced(TreeNode root){
        if (root == null){
            return true ;
        }

        return recur(root) != -1 ;
    }

    // 递归判断当前
    private int recur(TreeNode root) {
        if (root == null){
            return 0 ;
        }

        int left = recur(root.left) ;
        if(left == -1){
            return -1 ;
        }
        int right = recur(root.right) ;
        if(right == -1){
            return -1 ;
        }

        return Math.abs(left - right) < 2 ? Math.max(left , right) + 1 : -1 ;
    }

    public static void main(String[] args) {
        _55_IsBalance obj = new _55_IsBalance() ;

        TreeNode node0 = new TreeNode(0) ;
        TreeNode node15 = new TreeNode(15) ;
        TreeNode node7 = new TreeNode(7 , node0 , null) ;

        TreeNode node9 = new TreeNode(9) ;

        TreeNode node20 = new TreeNode(20 , node15 , node7) ;

        TreeNode node3 = new TreeNode(3 , node9 , node20) ;

        System.out.print(obj.isBalanced(node3));
    }
}
