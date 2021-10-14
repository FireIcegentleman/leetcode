/**
 * 2021/09/11
 * 不同的二叉搜索树II
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 * 可以按 任意顺序 返回答案。
 * */

public class _95_UniqueBinarySearchTreesII {
    public static class TreeNode {
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
    public int numTrees(int n) {
        int[] dp = new int[n + 1] ;
        dp[0] = dp[1] = 1 ;

        for(int i = 2 ; i < n + 1 ; i++){
            for(int j = 1 ; j < i + 1 ; j++){
                dp[i] += dp[j - 1] * dp[i - j] ;
            }
        }
        return dp[n] ;
    }
    public static void main(String[] args) {
        _95_UniqueBinarySearchTreesII obj = new _95_UniqueBinarySearchTreesII() ;
        int n = 3 ;
        System.out.print(obj.numTrees(n));
    }
}
