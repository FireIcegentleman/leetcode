/**
 * 2021/09/11
 * 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树定义如下：
 *  1. 节点的左子树只包含 小于 当前节点的数。
 *  2. 节点的右子树只包含 大于 当前节点的数。
 *  3. 所有左子树和右子树自身必须也是二叉搜索树。
 * */
public class _98_ValidateBinarySearchTree {
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
    // 不能保证左右分支上的所有数字都满足条件
    /*private boolean frontorder(TreeNode root, boolean flag) {
        if(root == null || flag == false){
            return flag ;
        }

        if(root.left != null){
            flag = flag && (root.val > root.left.val) ;
            frontorder(root.left , flag) ;
        }
        if(root.right != null){
            flag = flag && (root.val < root.right.val) ;
            frontorder(root.right , flag) ;
        }
        return flag ;
    }*/

    private boolean nogreat(TreeNode root, int val) {
        if(root == null){
            return true ;
        }

        if(root.val >= val){
            return false ;
        }
        // 传递判断
        return nogreat(root.left , val) && nogreat(root.right , val) ;
    }
    private boolean noless(TreeNode root, int val) {
        if(root == null){
            return true ;
        }

        if(root.val <= val){
            return false ;
        }

        return noless(root.left , val) && noless(root.right , val);
    }

    // 判断二叉树是否合法，在遍历的过程中添加判定条件
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true ;
        }

        //return frontorder(root , flag) ;
        if(nogreat(root.left , root.val) && noless(root.right , root.val)){
            return isValidBST(root.left) && isValidBST(root.right) ;
        }else{
            return false;
        }
    }

    private boolean isValidBST_standard(TreeNode root) {
        return helper(root , Long.MIN_VALUE , Long.MAX_VALUE) ;
    }

    private boolean helper(TreeNode root, long lower, long uper) {
        if(root == null){
            return true ;
        }

        if(root.val  <= lower || root.val >= uper){
            return false ;
        }

        return helper(root.left , lower , root.val) && helper(root.right , root.val, uper) ;
    }

    public static void main(String[] args) {
        _98_ValidateBinarySearchTree obj = new _98_ValidateBinarySearchTree() ;
        /*TreeNode node1 = new TreeNode(1) ;
        TreeNode node3 = new TreeNode(3) ;
        TreeNode node2 = new TreeNode(2 , node1 ,node3) ;
        System.out.println(obj.isValidBST(node2));*/
        TreeNode node4 = new TreeNode(4) ;
        TreeNode node3 = new TreeNode(3) ;
        TreeNode node7 = new TreeNode(8) ;
        TreeNode node6 = new TreeNode(6 , node3 , node7) ;
        TreeNode node5 = new TreeNode(5 , node4 , node6) ;
        System.out.println(obj.isValidBST_standard(node5));
    }

}
