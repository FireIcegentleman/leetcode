package All;

import org.omg.CORBA.MARSHAL;

/**
 * 2021/11/16
 *
 * 跳跃游戏
 *
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * */
public class _55_CanJump {
    public boolean canJump_force(int[] nums) {
        int len = nums.length ;

        // 染色问题，color[i]表示能够从起点到达位置i
        int[] color = new int[len] ;

        for (int i = 0 ; i < len ; i++){
            if (color[i] == 0 && i > 0){
                return false ;
            }
            for (int j = i ; j < (i + nums[i] + 1) && j < len ; j++){
                color[j] = 1 ;
            }
        }
        return color[len - 1] == 1 ;
    }

    public boolean canJump(int[] nums) {
        // 当前能跳到的最远距离
        int k = 0 ;
        for (int i = 0 ; i < nums.length ; i++){
            if (i > k){
                return false ;
            }
            k = Math.max(k , i + nums[i]) ;
        }
        return true ;

    }

    public static void main(String[] args) {
        _55_CanJump obj = new _55_CanJump() ;
        int[] nums = {3,2,1,0,4} ;
        System.out.println(obj.canJump(nums));
    }


}
