package SwordOffer;

public class _68_lowestCommonAncestorII {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root ;
        }

        TreeNode left = lowestCommonAncestor(root.left , p , q) ;
        TreeNode right = lowestCommonAncestor(root.right , p , q) ;
        if (left == null && right == null){
            return null ;
        }
        if (left == null){
            return right ;
        }
        if (right == null){
            return left ;
        }
        return root ;
    }
    public static void main(String[] args) {
        _68_lowestCommonAncestorII obj = new _68_lowestCommonAncestorII() ;

        TreeNode node3 = new TreeNode(3) ;
        TreeNode node5 = new TreeNode(5) ;

        TreeNode node0 = new TreeNode(0) ;
        TreeNode node4 = new TreeNode(4 , node3 , node5) ;
        TreeNode node7 = new TreeNode(7) ;
        TreeNode node9 = new TreeNode(9) ;

        TreeNode node2 = new TreeNode(2 , node0 , node4) ;
        TreeNode node8 = new TreeNode(8 , node7 , node9) ;
        TreeNode node6 = new TreeNode(6 , node2 , node8) ;

        TreeNode res = obj.lowestCommonAncestor(node6 , node8 , node7) ;
        System.out.print(res.val);
    }
}
