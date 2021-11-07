package ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/10/28
 *
 * 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 答案中不可以包含重复的三元组
 **/
public class _8_ThreeSum {
    // 请你找出所有和为 0 且不重复的三元组。
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>() ;

        int len = nums.length ;
        if (len < 3){
            return res ;
        }

        Arrays.sort(nums);

        // 此时的Index指向第一个数字的最后一个值
        for (int index = 0 ; index < len - 2 ; index++){
            if (nums[index] > 0){
                break;
            }
            if (index > 0 && nums[index] == nums[index - 1]){
                continue;
            }
            int target = 0 - nums[index] ;
            int left = index + 1 ;
            int right = len - 1 ;

            while (left < right){
                if (nums[left] + nums[right] == target){
                    res.add(Arrays.asList(nums[index] , nums[left] , nums[right])) ;

                    while (left < right && left < (len - 1) &&nums[left] == nums[left + 1]){
                        left++ ;
                    }
                    while (left < right && right > 1 && nums[right] == nums[right - 1]){
                        right-- ;
                    }
                    left++ ;
                    right-- ;
                }else if (nums[left] + nums[right] < target){
                    left++ ;
                }else{
                    right-- ;
                }
            }
        }

        return res ;
    }
    public static void main(String[] args) {
        _8_ThreeSum obj = new _8_ThreeSum() ;
        int[] nums = {0,0,0} ;
        List<List<Integer>> res = obj.threeSum(nums) ;
        for (int i = 0 ; i < res.size() ; i++){
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
