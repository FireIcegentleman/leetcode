package SwordOffer;

/**
 * 2021/09/28
 *
 * 数组中的重复数字
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * */
public class _3_RepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int[] path = new int[nums.length] ;
        for (int num : nums){
            path[num]++ ;
            if (path[num] > 1){
                return num ;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        _3_RepeatNumber obj = new _3_RepeatNumber() ;
        int[] nums = {2, 3, 1, 0, 2, 5, 3} ;
        System.out.println(obj.findRepeatNumber(nums));
    }
}
