import java.util.HashMap;

/**
 * 20201/09/22
 * 打家劫舍 III
 *
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 *
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * */
// 动态规划的树形版本
public class _337_HouseRobberIII {
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

    // 两个直接相连的房子在同一天被打劫则会触发警报
    // 连续三层，比较（1+3）和2
    // 超时——122/124
    public int rob_force(TreeNode root) {
        if(root == null){
            return 0 ;
        }
        int money = root.val ;
        if (root.left != null){
            money += rob(root.left.left) + rob(root.left.right) ;
        }
        if (root.right != null){
            money += rob(root.right.right) + rob(root.right.left) ;
        }

        int res = Math.max(money , rob(root.left) + rob(root.right)) ;
        return res ;
    }

    // 记忆化解决重复问题
    // 每个节点充当爷爷、儿子、孙子节点的时候每次都要计算一次自己的值，记忆化存储
    // 二叉树不适合使用数组存储dp，使用哈希表存储，TreeNode充当key，能偷的钱当作value
    public int rob_memory(TreeNode root) {
        HashMap<TreeNode , Integer> map = new HashMap<>() ;
        return robInternal(root , map) ;
    }

    private int robInternal(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null){
            return 0 ;
        }
        if (map.containsKey(root)){
            return map.get(root) ;
        }

        int money = root.val ;
        if (root.left != null){
            money += robInternal(root.left.left , map) + robInternal(root.left.right , map) ;
        }
        if (root.right != null){
            money += robInternal(root.right.left , map) + robInternal(root.right.right , map) ;
        }

        int res = Math.max(money , robInternal(root.left , map) + robInternal(root.right , map)) ;
        map.put(root , res) ;
        return res ;
    }

    // 上面两种解法用到了孙子节点，计算爷爷节点能偷的钱还要同时去计算孙子节点投的钱，虽然有了记忆化，但是还是有性能损耗。
    public int rob(TreeNode root) {
        int[] result = robInter(root) ;
        return Math.max(result[0] , result[1]) ;
    }

    private int[] robInter(TreeNode root) {
        if (root == null){
            return new int[2] ;
        }
        int[] result = new int[2] ;

        int[] left= robInter(root.left) ;
        int[] right= robInter(root.right) ;

        //0对应当前不偷，则返回左右子树能返回的最大结果
        result[0] = Math.max(left[0] , left[1]) + Math.max(right[0] , right[1]) ;
        //1对应当前偷，则下一个不能偷
        result[1] = left[0] + right[0] + root.val ;
        return result ;
    }

    public static void main(String[] args) {
        _337_HouseRobberIII obj = new _337_HouseRobberIII() ;
        TreeNode node3 = new TreeNode(3) ;
        TreeNode node2 = new TreeNode(2 , null , node3) ;
        TreeNode node1 = new TreeNode(1) ;
        TreeNode node_3 = new TreeNode(3 , null , node1) ;

        TreeNode node_top_3 = new TreeNode(3 , node2 , node_3) ;

        System.out.println(obj.rob(node_top_3));
    }
}
