/**
 * 2021/09/11
 * 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * */
import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class _94_BinaryTreeInorderTraversal {
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

    private void inorder(TreeNode root, List<Integer> res) {
        if(root == null){
            return;
        }

        if(root.left != null){
            inorder(root.left , res) ;
        }

        res.add(root.val) ;


        if(root.right != null){
            inorder(root.right , res) ;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // 中序遍历
        List<Integer> res = new ArrayList<>() ;
        if(root == null){
            return res ;
        }

        inorder(root , res) ;
        return res ;
    }


    public static void main(String[] args) {
        _94_BinaryTreeInorderTraversal obj = new _94_BinaryTreeInorderTraversal() ;
        TreeNode node1 = new TreeNode(3) ;
        TreeNode node2 = new TreeNode(2 , node1 , null) ;
        TreeNode root  = new TreeNode(1 , null ,node2) ;
        List<Integer> res = obj.inorderTraversal(root) ;

        for(int i = 0 ; i < res.size() ; i++){
            System.out.print(res.get(i));
        }
    }
}
