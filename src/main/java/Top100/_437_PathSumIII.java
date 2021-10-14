import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2021/09/25
 *
 * 路经总和III
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 前缀和
 * */

public class _437_PathSumIII {
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
    public static int count ;

    // 递归每一个节点，寻找这样的值
    private void find(TreeNode root , int targetSum) {
        if (root == null){
            return;
        }

        //分别向左、右子树寻找
        pathTarget(root , 0 , targetSum);

        if (root.left != null){
            pathTarget(root.left , 0 , targetSum);
        }
        if (root.right != null){
            pathTarget(root.right , 0 , targetSum);
        }
    }

    // 找到从当前节点向下的路径中有没有一条路能找到路径上的值为target
    private void pathTarget(TreeNode root, int now , int targetSum) {
        if (now == targetSum){
            count++ ;
            return ;
        }

        if (root == null){
            return;
        }

        now += root.val ;

        // 继续向左下遍历
        pathTarget(root.left , now , targetSum) ;
        // 继续向右下遍历
        pathTarget(root.right , now , targetSum) ;

    }
    // 路径只能是从父结点向下的
    public int pathSum_(TreeNode root, int targetSum) {
        count = 0 ;
        //pathTarget(root , 0 , targetSum) ;
        find(root , targetSum) ;
        return count / 2 ;
    }

    // 前缀和
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer , Integer> prefixSumCount = new HashMap<>() ;
        prefixSumCount.put(0 , 1) ;
        return recursionPathSum(root , prefixSumCount , targetSum , 0) ;
    }


    private int recursionPathSum(TreeNode root, Map<Integer, Integer> prefixSumCount, int targetSum, int currSum) {
        if (root == null){
            return 0 ;
        }

        int res = 0 ;
        // 当前和
        currSum += root.val ;

        // target为两个节点的前缀和的差值
        res += prefixSumCount.getOrDefault(currSum - targetSum, 0) ;

        prefixSumCount.put(currSum , prefixSumCount.getOrDefault(currSum , 0) + 1) ;

        int left = recursionPathSum(root.left , prefixSumCount , targetSum , currSum) ;
        int right = recursionPathSum(root.right , prefixSumCount , targetSum , currSum) ;

        res = res + left + right ;

        prefixSumCount.put(currSum , prefixSumCount.get(currSum) - 1) ;

        // 路径数
        return res ;
    }

    public static void main(String[] args) {
        _437_PathSumIII obj = new _437_PathSumIII() ;
        /*TreeNode node3 = new TreeNode(3) ;
        TreeNode node_2 = new TreeNode(2) ;

        TreeNode nodetop3 = new TreeNode(3 , node3 , node_2) ;

        TreeNode node1 = new TreeNode(1) ;
        TreeNode node2 = new TreeNode(2 , null , node1) ;

        TreeNode node5 = new TreeNode(5 , nodetop3 , node2) ;

        TreeNode node11 = new TreeNode(11) ;
        TreeNode node_3 = new TreeNode(-3 , null , node11) ;

        TreeNode node10 = new TreeNode(10 , node5 , node_3) ;*/
        /*TreeNode node7 = new TreeNode(7) ;
        TreeNode node2 = new TreeNode(2) ;
        TreeNode node11 = new TreeNode(11 , node7 , node2) ;

        TreeNode node5 = new TreeNode(5) ;
        TreeNode node1 = new TreeNode(1) ;
        TreeNode node4 = new TreeNode(4 , node5 , node1) ;

        TreeNode node13 = new TreeNode(13) ;

        TreeNode node8 = new TreeNode(8 , node13 , node4) ;
        TreeNode nodetop4 = new TreeNode(4 , node11 , null) ;

        TreeNode nodetop5 = new TreeNode(5 , nodetop4 , node8) ;*/

        TreeNode node2 = new TreeNode(2) ;
        TreeNode node1 = new TreeNode(1 , node2 , null) ;

        System.out.println(obj.pathSum(node1 , 0));
    }
}
