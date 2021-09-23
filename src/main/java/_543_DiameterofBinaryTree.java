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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0 ;
        }
        int res = 0 ;


        return res ;
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
