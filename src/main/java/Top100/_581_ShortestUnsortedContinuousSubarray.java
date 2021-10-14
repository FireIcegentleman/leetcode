/**
 * 2021/09/26
 *
 * 最短无序连续子数组
 *
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * */
public class _581_ShortestUnsortedContinuousSubarray {
    // 整数数组 nums ，连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    // 连续子数组。假设这个数组从L到R，那么满足L-R中的所有数字大于nums[L-1]且小于nums[R+1]

    public int findUnsortedSubarray_(int[] nums) {
        int n = nums.length ;
        if (n <= 1){
            return 0 ;
        }
        if (n == 2){
            if (nums[0] <= nums[1]){
                return 0 ;
            }else{
                return 2 ;
            }
        }
        int L = 0 , R = n - 1 ;

        while (nums[L] <= nums[L + 1] && L < n - 2){
            L++ ;
        }

        while (nums[R] >= nums[R - 1] && R > 1){
            R-- ;
        }
        // 所有数字符合要求
        if (R <= L){
            return 0 ;
        }
        return R - L + 1 ;
    }

    // 倒着的逻辑
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length ;
        int maxn = Integer.MIN_VALUE , L = -1 ;
        int minn = Integer.MAX_VALUE , R = -1 ;

        for (int i = 0 ; i < n ; i++){
            if (maxn > nums[i]){
                R = i ;
            }else{
                maxn = nums[i] ;
            }

            if (minn < nums[n - i - 1]){
                L = n - i - 1 ;
            }else{
                minn = nums[n - i - 1] ;
            }
        }
        return R == -1 ? 0 : R - L + 1 ;
    }
    public static void main(String[] args) {
        _581_ShortestUnsortedContinuousSubarray obj = new _581_ShortestUnsortedContinuousSubarray() ;
        int[] nums = //{2,6,4,8,10,9,15} ;
                {1,2,3,3,3} ;
        System.out.println(obj.findUnsortedSubarray(nums));
    }
}
