import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

/**
 * 2021/09/08
 * 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 *
 * 动态规划
 * */
public class _55_JumpGame {
    public boolean canJump_dp(int[] nums) {
        /**
         * 标准dp
         * */
        int[] dp = new int[nums.length];
        dp[0] = 0 ;

        for (int i = 1 ; i < nums.length ; i++){
            dp[i] = Math.max(dp[i - 1] , nums[i - 1]) - 1 ;
            if(dp[i] < 0)
                return false ;
        }

        return dp[nums.length - 1]  >= 0;
    }

    /**
     * 模拟法
     * */
    public boolean canJump(int[] nums) {
        int k = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(i > k){
                return false ;
            }
            k = Math.max(k , i + nums[i]) ;
        }
        return true ;
    }

    public static void main(String[] args) {
        _55_JumpGame obj = new _55_JumpGame() ;
        int[] nums = {2,3,1,1,4} ;
        System.out.println(obj.canJump(nums));
    }
}
