/**
 * 2021/09/15
 * 乘积最大子数组
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * */
public class _152_MaximumProductSubarray {
    // 动态规划dp
    // 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
    // 出现负数时，需要交换
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0 ;
        }

        int res = Integer.MIN_VALUE ;
        int imin = 1 , imax = 1 ;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < 0){
                int tmp = imin ;
                imin = imax ;
                imax = tmp ;
            }

            imin = Math.min(imin * nums[i] , nums[i]) ;
            imax = Math.max(imax * nums[i] , nums[i]) ;

            res = Math.max(res , imax) ;
        }
        return res ;
    }

    public static void main(String[] args) {
        _152_MaximumProductSubarray obj = new _152_MaximumProductSubarray() ;
        int[] nums = {2,3,-2,4} ;
        System.out.println(obj.maxProduct(nums));
    }
}
