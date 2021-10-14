import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * 2021/09/20
 * 二叉树的序列化与反序列化
 *
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * * */
public class _297_SerializeandDeserializeBinaryTree {
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
    //前序遍历
    private List<Integer> preOrder(TreeNode root , List<Integer> res) {
        if (root == null){
            return res ;
        }

        res.add(root.val) ;
        if (root.left != null){
            preOrder(root.left , res) ;
        }
        if (root.right != null){
            preOrder(root.right , res) ;
        }
        return res ;
    }
    // 中序遍历
    private List<Integer> inOrder(TreeNode root , List<Integer> res) {
        if (root == null){
            return res ;
        }

        if (root.left != null){
            inOrder(root.left , res) ;
        }

        res.add(root.val) ;
        if (root.right != null){
            inOrder(root.right , res) ;
        }
        return res ;
    }

    // Encodes a tree to a single string. 序列化
    // 把一棵树转换为一个字符串
    // 字符串为 “pre:” + 先序遍历 + “in:” + 中序遍历
    public String serialize_pre_in(TreeNode root) {
        String res = "";
        res += "p" ;
        List<Integer> pre = preOrder(root , new ArrayList<>(0)) ;
        res += pre.toString() ;
        res += "i" ;
        List<Integer> in = inOrder(root , new ArrayList<>(0)) ;
        res += in.toString() ;
        return res ;
    }


    // Decodes your encoded data to tree. 反序列化
    // 把字符串还原成一棵树
    // 根据先序遍历和中序遍历建立二叉树
    public TreeNode deserialize_pre_in(String data) {
        List<Integer> pre = new ArrayList<>() ;
        List<Integer> in = new ArrayList<>() ;

        int n = 0;
        int pflag = 0 , iflag = 0 ;
        // 从序列化字符串构造 前序遍历序列 和 中序遍历序列
        // 考虑负数
        while(n < data.length()){
            if (data.charAt(n) == 'p'){
                pflag = 1 ;
            }else if (data.charAt(n) == 'i'){
                pflag = 0 ;
                iflag = 1 ;
            }

            if (pflag == 1 && (data.charAt(n) -'0') >= 0 && (data.charAt(n) -'0') <= 9){
                int tmp = data.charAt(n) - '0' ;
                if (data.charAt(n - 1) == '-'){
                    tmp = 0 - tmp ;
                }
                pre.add(tmp) ;
            }
            if (iflag == 1 && (data.charAt(n) -'0') >= 0 && (data.charAt(n) -'0') <= 9){
                int tmp = data.charAt(n) - '0' ;
                if (data.charAt(n - 1) == '-'){
                    tmp = 0 - tmp ;
                }
                in.add(tmp) ;
            }
            n++ ;
        }

        return buildTree(pre , in) ;
    }
    // 注意迭代时左子树前序遍历数组的右边界赋值【pleft + i - ileft】
    // 不必要直接建立数组，操作索引
    private TreeNode build(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright) {
        if (pleft > pright || ileft > iright){
            return null ;
        }

        int i ;
        for (i = ileft ; i < iright ; i++){
            if (preorder[pleft] == inorder[i]){
                break;
            }
        }

        TreeNode root = new TreeNode(preorder[pleft]) ;
        root.left = build(preorder , pleft + 1 , pleft + i - ileft , inorder , ileft , i - 1) ;
        root.right = build(preorder , pleft + i - ileft + 1 , pright , inorder , i + 1 , iright) ;

        return root ;
    }
    // 从先序遍历序列和中序遍历序列构造二叉树
    private TreeNode buildTree(List<Integer> pre, List<Integer> in) {
        int[] preOrder = new int[pre.size()] ;
        for (int i = 0 ; i < pre.size() ; i++){
            preOrder[i] = pre.get(i) ;
        }
        int[] inOrder = new int[in.size()] ;
        for (int i = 0 ; i < in.size() ; i++){
            inOrder[i] = in.get(i) ;
        }

        return build(preOrder , 0 , preOrder.length - 1 , inOrder , 0 , inOrder.length - 1) ;
    }

    // Encodes a tree to a single string.
    // X占位null
    public String serialize(TreeNode root) {
        if(root == null){
            return "X" ;
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right) ;
    }

    // Decodes your encoded data to tree.
    /**
     * 构建树的函数 buildTree 接收的 “状态” 是 list 数组，由序列化字符串转成
     * 按照前序遍历的顺序：先构建根节点，再构建左子树、右子树
     * 将 list 数组的首项弹出，它是当前子树的 root 节点
     * 如果它为 'X' ，返回 null
     * 如果它不为 'X'，则为它创建节点，并递归调用 buildTree 构建左右子树，当前子树构建完毕，向上返回
     */
    public TreeNode deserialize(String data) {
        String[] tmp = data.split(",") ;
        Deque<String> dp = new LinkedList<>(Arrays.asList(tmp)) ;
        return buildTree(dp) ;
    }

    public TreeNode buildTree(Deque<String> dp){
        String s = dp.poll() ;// 返回当前节点
        if(s.equals("X")){
            return null ;
        }
        TreeNode node = new TreeNode(Integer.parseInt(s)) ;
        node.left = buildTree(dp) ; //构建左子树
        node.right = buildTree(dp) ; //构建右子树
        return node ;
    }
    public static void main(String[] args) {
        _297_SerializeandDeserializeBinaryTree obj = new _297_SerializeandDeserializeBinaryTree() ;
        TreeNode node4 = new TreeNode(4) ;
        TreeNode node5 = new TreeNode(5) ;

        TreeNode node3 = new TreeNode(3 , node4 , node5) ;
        TreeNode node2 = new TreeNode(2) ;

        TreeNode node1 = new TreeNode(1 , node2 , node3) ;
        TreeNode res = obj.deserialize(obj.serialize(node1)) ;
        System.out.print(res.val);
    }
}
