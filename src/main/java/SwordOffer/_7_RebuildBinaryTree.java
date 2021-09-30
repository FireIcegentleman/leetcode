package SwordOffer;

import sun.reflect.generics.tree.Tree;

/**
 * 2021/09/30
 *
 * 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * */
public class _7_RebuildBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 前序遍历和中序遍历建立二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
            return null ;
        }

        TreeNode res = build(preorder , 0 , preorder.length - 1 , inorder , 0 , inorder.length - 1) ;
        return res ;
    }

    private TreeNode build(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {
        if (pleft > pright || ileft > iright){
            return null ;
        }
        int index = ileft ;
        for ( ; index < iright ; index++){
            if (preorder[pleft] == inorder[index]){
                break;
            }
        }

        TreeNode res = new TreeNode(inorder[index]) ;

        res.left = build(preorder , pleft + 1 , pleft - ileft + index , inorder , ileft , index - 1);
        res.right = build(preorder , pleft - ileft + index + 1 , pright , inorder , index + 1 , iright);
        return res ;
    }

    public static void main(String[] args) {
        _7_RebuildBinaryTree obj = new _7_RebuildBinaryTree() ;
        int[] preorder = {3,9,20,15,7} ;
        int[] inorder = {9,3,15,20,7} ;
        TreeNode res = obj.buildTree(preorder , inorder) ;
        System.out.println(res.val);
    }
}
