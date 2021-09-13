import java.util.ArrayList;
import java.util.List;

/**
 * 2021/09/13
 * 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *      1. 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 *      2. 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * */
public class _114_FlattenBinaryTreetoLinkedList {
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

    //先序遍历记录遇到的所有数值
    private void preorder(TreeNode root, List<Integer> num) {
        if(root == null){
            return ;
        }

        num.add(root.val) ;

        if(root.left != null){
            preorder(root.left , num);
        }
        if(root.right != null){
            preorder(root.right , num);
        }
    }
    // 利用先序遍历存储遇到的所有值，然后基于这个值构造新的二叉树
    public void flatten_memory(TreeNode root) {
        if(root == null){
            return ;
        }
        List<Integer> num = new ArrayList<>() ;
        preorder(root , num) ;
        TreeNode p = root ;

        for(int i = 1 ; i < num.size() ; i++){
            p.right = new TreeNode(num.get(i)) ;
            p = p.right ;
        }
        root.left = null ;
        return ;
    }

    // 空间复杂度为O(1)的算法
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }

        // 对左子树展开
        if(root.left != null){
            flatten(root.left);
        }
        // 对右子树展开
        if(root.right != null){
            flatten(root.right);
        }

        // 记录当前右子树
        TreeNode tmp = root.right ;
        // 更换后的右子树首先是之前展开的左子树
        root.right = root.left ;
        // 更换后左子树为空
        root.left = null ;

        // 指针指向之前左子树的最后一个值
        while(root.right != null){
            root = root.right ;
        }
        // 和右子树连起来
        root.right = tmp ;
    }

    public static void main(String[] args) {
        _114_FlattenBinaryTreetoLinkedList obj = new _114_FlattenBinaryTreetoLinkedList() ;
        TreeNode node3 = new TreeNode(3) ;
        TreeNode node4 = new TreeNode(4) ;
        TreeNode node2 = new TreeNode(2 , node3 , node4) ;
        TreeNode node6 = new TreeNode(6) ;
        TreeNode node5 = new TreeNode(5 , null , node6) ;
        TreeNode node1 = new TreeNode(1 , node2 , node5) ;

        obj.flatten(node1);
        return;
    }
}
