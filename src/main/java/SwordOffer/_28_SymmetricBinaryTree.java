package SwordOffer;
/**
 * 2021/10/02
 *
 * 对称二叉树
 *
 * 判断一棵树是否为对称二叉树
 * */
public class _28_SymmetricBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x , TreeNode left , TreeNode right){
            val = x ;
            this.left = left ;
            this.right = right ;
        }
    }

    // 判断二叉树是不是对称的
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true ;
        }
        TreeNode p = root.left ;
        TreeNode q = root.right ;
        if ((p == null && q != null) ||(p != null && q == null)){
            return false;
        }
        return check(p , q) ;
    }

    private boolean check(TreeNode p, TreeNode q) {
        if ((p == null && q != null) ||(p != null && q == null)){
            return false;
        }

        if ((p == null && q == null)){
            return true;
        }

        if ((p != null && q != null &&p.val == q.val)){
            return check(p.left , q.right) && check(p.right , q.left) ;
        }
        return false ;
    }

    public static void main(String[] args) {
        _28_SymmetricBinaryTree obj = new _28_SymmetricBinaryTree() ;
        TreeNode nodel3 = new TreeNode(3) ;
        TreeNode nodel4 = new TreeNode(4) ;
        TreeNode noder4 = new TreeNode(4) ;
        TreeNode noder3 = new TreeNode(3) ;

        TreeNode nodel2 = new TreeNode(2 , nodel3 , nodel4) ;
        TreeNode noder2 = new TreeNode(2 , noder4 , noder3) ;

        TreeNode node1 = new TreeNode(1 , nodel2 , noder2) ;
        System.out.println(obj.isSymmetric(node1));

    }
}
