/**
 * 2021/09/26
 *
 * 合并二叉树
 *
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 *
 * */
public class _617_MergeTwoBinaryTrees {
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

    // 合并两个二叉树
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return null ;
        }else if (root1 != null && root2 == null){
            return root1 ;
        }else if (root1 == null && root2 != null){
            return root2 ;
        }

        TreeNode root = new TreeNode(root1.val + root2.val) ;
        root.left = mergeTrees(root1.left , root2.left) ;
        root.right = mergeTrees(root1.right , root2.right) ;

        return root ;
    }
    public static void main(String[] args) {
        _617_MergeTwoBinaryTrees obj = new _617_MergeTwoBinaryTrees() ;
        TreeNode node15 = new TreeNode(5) ;
        TreeNode node13 = new TreeNode(3 , node15 , null) ;
        TreeNode node12 = new TreeNode(2) ;
        TreeNode node11 = new TreeNode(1 , node13 , node12) ;


        TreeNode node24 = new TreeNode(4) ;
        TreeNode node27 = new TreeNode(7) ;
        TreeNode node21 = new TreeNode(1 , null , node24) ;
        TreeNode node23 = new TreeNode(3 , null , node27) ;
        TreeNode node22 = new TreeNode(2 , node21 , node23) ;

        TreeNode res = obj.mergeTrees(node11 , node22) ;
        System.out.println(res.val);
        System.out.println();
    }
}
