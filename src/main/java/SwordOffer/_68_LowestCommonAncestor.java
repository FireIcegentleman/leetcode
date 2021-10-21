package SwordOffer;

/**
 * 2021/10/15
 *
 * 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * */
public class _68_LowestCommonAncestor {
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

    // 最近公共祖先
    // 注意是二叉搜索树
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val){
            TreeNode tmp = p ;
            p = q ;
            q = tmp ;
        }

        while (root != null){
            if (root.val < p.val){
                root = root.right ;
            }else if(root.val > q.val){
                root = root.left ;
            }else{
                break;
            }
        }
        return root ;
    }

    public static void main(String[] args) {
        _68_LowestCommonAncestor obj = new _68_LowestCommonAncestor() ;
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
