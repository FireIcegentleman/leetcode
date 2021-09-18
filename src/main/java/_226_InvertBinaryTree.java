import sun.reflect.generics.tree.Tree;

/**
 * 2021/09/17
 * 翻转一棵二叉树
 * */
// 不一定对称
public class _226_InvertBinaryTree {
    static class TreeNode {
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

    // 翻转一棵二叉树
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null ;
        }

        TreeNode tmp = root.left ;
        root.left = root.right ;
        root.right = tmp ;

        invertTree(root.left) ;
        invertTree(root.right) ;

        return root ;
    }


    public static void main(String[] args) {
        _226_InvertBinaryTree obj = new _226_InvertBinaryTree() ;

        TreeNode node1 = new TreeNode(1) ;
        TreeNode node3 = new TreeNode(3) ;
        TreeNode node6 = new TreeNode(6) ;
        TreeNode node9 = new TreeNode(9) ;

        TreeNode node2 = new TreeNode(2 , node1 , node3) ;
        TreeNode node7 = new TreeNode(7 , node6 , node9) ;

        TreeNode node4 = new TreeNode(4 , node2 , node7) ;

        //TreeNode res = obj.invertTree(node4) ;
        TreeNode res = obj.invertTree(new TreeNode()) ;

        System.out.print(res.val);
    }
}
