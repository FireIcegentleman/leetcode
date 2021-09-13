import sun.reflect.generics.tree.Tree;

/**
 * 2021/09/12
 *
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * */
public class _101_SymmetricTree {
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

    private boolean check(TreeNode p , TreeNode q){
        if(p == null && q == null){
            return true;
        }else if((p == null || q == null) ||(p.val != q.val)){
            return false ;
        }

        return check(p.left , q.right) && check(p.right , q.left) ;
    }
    // 对称，设定标志位指向当前判断的两个节点
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true ;
        }

        return check(root.left , root.right) ;
    }
    public static void main(String[] args) {
        _101_SymmetricTree obj = new _101_SymmetricTree() ;
        TreeNode node3l = new TreeNode(3) ;
        TreeNode node4l = new TreeNode(4) ;
        TreeNode node3r = new TreeNode(3) ;
        TreeNode node4r = new TreeNode(4) ;
        TreeNode node2l = new TreeNode(2 , node3l , node4l) ;
        TreeNode node2r = new TreeNode(2 , node4r , node3r) ;
        TreeNode node1 = new TreeNode(1 , node2l , node2r) ;

        System.out.println(obj.isSymmetric(node1));
    }
}
