/**
 * 2021/09/13
 * 二叉树中的最大路径和
 *
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。
 * 该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * */

public class _124_BinaryTreeMaximumPathSum {
    public static int maxSum = Integer.MIN_VALUE ;

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

    private int maxGain(TreeNode root) {
        if(root == null){
            return 0 ;
        }

        // 递归左右子树的最大贡献值
        // 只有贡献值大于0，才会选择此节点
        int left_gain = Math.max(maxGain(root.left) , 0) ;
        int right_gain = Math.max(maxGain(root.right),  0) ;

        // 节点的最大路径和取决于该节点的值于该节点的左右节点的最大贡献值
        // 经过根节点，一个子树内部的最大路径和 = 左子树提供的最大路径和 + 根节点值 + 右子树提供的最大路径
        // 当前子树内部的最大路径和
        int priceNewPath = root.val + left_gain + right_gain ;

        // 挑战最大路径，以当前节点为根节点的子树是否满足条件？
        maxSum = Math.max(maxSum , priceNewPath);

        // 当前路径对外提供的最大和
        return root.val + Math.max(left_gain , right_gain) ;
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root) ;
        return maxSum ;
    }


    public static void main(String[] args) {
        _124_BinaryTreeMaximumPathSum obj = new _124_BinaryTreeMaximumPathSum() ;
        TreeNode node9 = new TreeNode(0) ;
        /*TreeNode node15 = new TreeNode(15) ;
        TreeNode node7 = new TreeNode(7) ;
        TreeNode node20 = new TreeNode(20 , node15 , node7) ;
        TreeNode node_10 = new TreeNode(-10 , node9 , node20) ;*/
        System.out.print(obj.maxPathSum(node9));
    }
}
