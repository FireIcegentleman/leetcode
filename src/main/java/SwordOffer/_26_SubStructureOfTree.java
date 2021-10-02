package SwordOffer;

/**
 * 2021/10/01
 *
 * 树的子结构
 *
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * */
public class _26_SubStructureOfTree {
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
    // 判断是否为子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A , B) || isSubStructure(A.left , B) || isSubStructure(A.right, B)) ;
    }

    private boolean recur(TreeNode a, TreeNode b) {
        if (b == null){
            return true ;
        }

        if (a == null || a.val != b.val){
            return false ;
        }

        return recur(a.left , b.left) && recur(a.right , b.right) ;
    }

    public static void main(String[] args) {
        _26_SubStructureOfTree obj = new _26_SubStructureOfTree() ;
        TreeNode node1 = new TreeNode(1) ;
        TreeNode node2 = new TreeNode(2) ;
        TreeNode node4 = new TreeNode(4 , node1 , node2) ;
        TreeNode node5 = new TreeNode(5) ;
        TreeNode node3 = new TreeNode(3 , node4 , node5) ;

        TreeNode nodeb1 = new TreeNode(1) ;
        TreeNode nodeb4 = new TreeNode(4 , nodeb1 , null) ;

        System.out.println(obj.isSubStructure(node3 , nodeb4));
    }
}
