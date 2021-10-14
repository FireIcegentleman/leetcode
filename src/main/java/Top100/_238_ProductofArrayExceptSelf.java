import java.util.Arrays;

/**
 * 2021/09/18
 * 除自身以外数组的乘积
 *
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * */
public class _238_ProductofArrayExceptSelf {
    // 限制条件：不能使用除法、时间复杂度为O(n)
    // 左索引数组 * 右索引数组
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length ;
        int[] res = new int[n] ;

        // 先构造左索引数组
        res[0] = 1 ;
        for (int i = 1 ; i < n ; i++){
            res[i] = res[i - 1] * nums[i - 1] ;
        }

        // 从后往前进行右索引的的加入
        int right = 1 ;
        for (int i = n - 1 ; i >= 0 ; i--){
            res[i] = res[i] * right ;
            right *= nums[i] ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _238_ProductofArrayExceptSelf obj = new _238_ProductofArrayExceptSelf() ;
        int[] nums = {1,2,3,4} ;
        System.out.println(Arrays.toString(obj.productExceptSelf(nums)));
    }
}
