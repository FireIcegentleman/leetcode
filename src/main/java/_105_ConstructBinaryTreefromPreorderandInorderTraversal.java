/**
 * 2021/09/13
 * 从前序与中序遍历序列构造二叉树
 *
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * */
public class _105_ConstructBinaryTreefromPreorderandInorderTraversal {
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

    // 注意迭代时左子树前序遍历数组的右边界赋值【pleft + i - ileft】
    // 不必要直接建立数组，操作索引
    private TreeNode build(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {
        if(pleft > pright || ileft > iright){
            return null ;
        }

        int i = 0 ;
        for (i = ileft ; i < iright ; i++){
            if(preorder[pleft] == inorder[i]){
                break;
            }
        }
        TreeNode cur = new TreeNode(preorder[pleft]) ;
        // 前序序列的左边界
        cur.left = build(preorder , pleft + 1 , pleft + i - ileft , inorder , ileft , i - 1) ;
        cur.right = build(preorder , pleft + i - ileft + 1 , pright , inorder , i + 1, iright) ;

        return cur ;
    }

    // 给定前序遍历和中序遍历的序列，构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder , 0 , preorder.length - 1 , inorder , 0 , inorder.length - 1) ;
    }


    public static void main(String[] args) {
        _105_ConstructBinaryTreefromPreorderandInorderTraversal obj = new _105_ConstructBinaryTreefromPreorderandInorderTraversal() ;
        int[] preorder = {3,9,20,15,7} ;
        int[] inorder = {9,3,15,20,7} ;
        TreeNode root = obj.buildTree(preorder , inorder) ;
        return ;
    }
}
