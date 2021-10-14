/**
 * 2021/09/26
 *
 * 二叉树的直径
 *
 * */

public class _543_DiameterofBinaryTree {
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
    // 直径长度是任意两个节点路径长度中的最大值
    // 迭代，计算左右子树分别能提供的最大路径数，
    public int diameterOfBinaryTree_(TreeNode root) {
        if (root == null){
            return 0 ;
        }
        int L = calculate(root.left) ;
        int R = calculate(root.right) ;
        return L + R ;
    }

    // 计算二叉树的深度
    private int calculate(TreeNode root) {
        int res = 0 ;
        if (root == null){
            return 0 ;
        }
        return getMaxdepth(root , res) ;
    }

    private int getMaxdepth(TreeNode root, int res) {
        if (root == null){
            return res ;
        }
        return Math.max(getMaxdepth(root.left , res + 1) , getMaxdepth(root.right , res  + 1)) ;
    }

    public int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root){
        maxDepth = 0 ;
        getdepth(root) ;
        return maxDepth ;
    }

    private int getdepth(TreeNode root) {
        if (root == null){
            return 0 ;
        }

        int L = getdepth(root.left) ;
        int R = getdepth(root.right) ;

        maxDepth = Math.max(L + R , maxDepth) ; // 将每一个节点的最大直径与当前最大直径作比较
        return Math.max(L , R) + 1 ; // 返回节点深度
    }

    public static void main(String[] args) {
        _543_DiameterofBinaryTree obj = new _543_DiameterofBinaryTree() ;
        TreeNode node4 = new TreeNode(4) ;
        TreeNode node5 = new TreeNode(5) ;

        TreeNode node2 = new TreeNode(2 , node4 , node5) ;

        TreeNode node3 = new TreeNode(3) ;

        TreeNode node1 = new TreeNode(1 , node2 , node3) ;

        System.out.println(obj.diameterOfBinaryTree(node1));
    }
}
