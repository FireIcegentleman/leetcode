package SwordOffer;
/**
 * 2021/10/07
 *
 * 二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * */
public class _33_VerifyPostOrder {
    // 从后往前递归
    public boolean verifyPostorder(int[] postorder) {
        int len = postorder.length ;
        if (len == 0){
            return true ;
        }

        return verify(postorder , 0 , len - 1) ;
    }

    private boolean verify(int[] postorder, int begin , int end) {
        if (begin >= end){
            return true ;
        }
        int root = postorder[end] ;
        int index = begin ;

        for ( ; index < end ; index++){
            if (postorder[index] > root){
                break;
            }
        }

        for (int i = index ; i < end ; i++){
            if (postorder[i] < root){
                return false ;
            }
        }

        return verify(postorder , begin , index - 1) && verify(postorder , index , end - 1) ;
    }

    public static void main(String[] args) {
        _33_VerifyPostOrder obj = new _33_VerifyPostOrder() ;
        int[] postorder = {1,2,5,10,6,9,4,3} ;
        System.out.println(obj.verifyPostorder(postorder));
    }
}
