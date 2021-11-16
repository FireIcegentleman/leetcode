package All;

import java.util.Arrays;
import java.util.Map;

/**
 * 2021/11/13
 *
 * 跳跃游戏II
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 * */
public class _45_Jump {
    // 动态规划
    // 105/106
    public int jump_dp(int[] nums) {
        int len = nums.length ;

        // dp[i]表示跳到i位置所需要的最少步数
        int[] dp = new int[len] ;
        Arrays.fill(dp , 1001);

        dp[0] = 0 ;
        for (int i = 1 ; i < len ; i++){
            for (int j = i - 1 ; j >= 0 ; j--){
                if (i - j <= nums[j]){
                    dp[i] = Math.min(dp[i] , dp[j] + 1) ;
                }
            }
        }
        // 返回到末尾位置的最小步数
        return dp[len - 1] ;
    }
    public int jump(int[] nums) {
        int ans = 0 ;
        int start = 0 ;
        int end = 1 ;

        while (end < nums.length){
            int maxPos = 0 ;
            for (int i = start ; i < end ; i++){
                // 在当前的跳跃范围内能跳到最远的距离
                maxPos = Math.max(maxPos , i + nums[i]) ;
            }
            // 更新下一个起跳点的起始位置
            start = end ;
            // 更新下一次起跳点的末尾位置
            end = maxPos + 1 ;
            // 跳跃次数
            ans++ ;
        }
        return ans ;
    }
    public static void main(String[] args) {
        _45_Jump obj = new _45_Jump() ;
        int[] nums = {2,3,1,1,4} ;
        System.out.println(obj.jump(nums));
    }


}
