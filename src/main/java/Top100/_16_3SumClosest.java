import java.util.*;

/**
 * 2021/2/4
 * leetcode 16
 * Runtime: 9 ms, faster than 22.74% of Java online submissions for 3Sum Closest.
 * Memory Usage: 39.7 MB, less than 10.26% of Java online submissions for 3Sum Closest.
 * */
public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0 ;
        int min_closet = Integer.MAX_VALUE ;
        if(nums.length == 0){
            return 0 ;
        }
        // sort
        Arrays.sort(nums);
        int  left , right , sum;
        for(int i = 0 ; i < nums.length ; i++){
            left = i + 1 ;
            right = nums.length - 1 ;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right] ;
                if(sum == target){
                    return target ;
                }
                if(sum < target){
                    if(Math.abs(sum - target) < min_closet){
                        min_closet = Math.abs(sum - target) ;
                        res = sum ;
                    }
                    left++ ;
                }else if(sum > target){
                    if(Math.abs(sum - target) < min_closet){
                        res = sum ;
                        min_closet = Math.abs(sum - target) ;
                    }
                    right-- ;
                }
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        int[] nums = {0,2,1,-3} ;
        int target = 0 ;
        _16_3SumClosest obj = new _16_3SumClosest() ;
        System.out.println(obj.threeSumClosest(nums,target));
    }
}
