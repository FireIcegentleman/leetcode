package SwordOffer;

import javax.xml.bind.helpers.AbstractUnmarshallerImpl;

/**
 * 2021/10/02
 *
 * 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * */
public class _27_MirrorOfBinaryTree {
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
    // 二叉树镜像翻转
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null ;
        }
        TreeNode res = new TreeNode(0) ;
        res = build(root);
        return res ;
    }

    private TreeNode build(TreeNode root) {
        TreeNode res ;
        if (root == null){
           return null ;
        }
        res = new TreeNode(root.val) ;
        res.left = build(root.right);
        res.right = build(root.left) ;
        return res ;
    }

    public static void main(String[] args) {
        _27_MirrorOfBinaryTree obj = new _27_MirrorOfBinaryTree() ;
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        TreeNode node2 = new TreeNode(2 , node1 , node3);
        TreeNode node7 = new TreeNode(7 , node6 , node9);

        TreeNode node4 = new TreeNode(4 , node2 , node7);

        TreeNode res = obj.mirrorTree(node4) ;
        System.out.println(res.val);
    }
}
