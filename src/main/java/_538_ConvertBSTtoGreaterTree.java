/**
 * 2021/09/26
 *
 * 把二叉搜索树转换为累加树
 *
 * 给出 二叉搜索树 的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *  1.节点的左子树仅包含键 小于 节点键的节点。
 *  2.节点的右子树仅包含键 大于 节点键的节点。
 *  3.左右子树也必须是二叉搜索树。
 * */
public class _538_ConvertBSTtoGreaterTree {
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

    private int sum = 0 ;
    // 将二叉搜索树变为累加树
    // 每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
    // 每个节点的新值等于包括自己在内的右子树的val之和

    // 反序中序遍历，记录过程中的节点值之和，并不断更新当前遍历到的节点的节点值
    public TreeNode convertBST(TreeNode root) {
        if (root != null){
            convertBST(root.right) ;
            sum += root.val ;
            root.val = sum ;
            convertBST(root.left) ;
        }
        return root ;
    }


    public static void main(String[] args) {
        _538_ConvertBSTtoGreaterTree obj = new _538_ConvertBSTtoGreaterTree() ;
        TreeNode node3 = new TreeNode(3) ;
        TreeNode node0 = new TreeNode(0) ;
        TreeNode node2 = new TreeNode(2 , null , node3) ;

        TreeNode node1 = new TreeNode(1 , node0 , node2) ;

        TreeNode node8 = new TreeNode(8) ;
        TreeNode node5 = new TreeNode(5) ;
        TreeNode node7 = new TreeNode(7 , null , node8) ;

        TreeNode node6 = new TreeNode(6 , node5 , node7) ;

        TreeNode node4 = new TreeNode(4 , node1 , node6) ;

        TreeNode res = obj.convertBST(node4) ;

        System.out.println(res.val);
    }
}
