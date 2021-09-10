import java.util.*;
import java.util.stream.Collectors;

/**
 * 2021/2/3
 * leetcode 15
 * Runtime: 455 ms, faster than 20.00% of Java online submissions for 3Sum.
 * Memory Usage: 43.7 MB, less than 35.19% of Java online submissions for 3Sum.
 * */
public class _15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>() ;
        }
        Set<List<Integer>> res = new HashSet<>();
        // sort
        Arrays.sort(nums);
        int target , left , right , sum;
        for(int i = 0 ; i < nums.length ; i++){
            target = 0 - nums[i] ;
            left = i + 1 ;
            right = nums.length - 1 ;
            while(left < right){
                sum = nums[left] + nums[right] ;
                if(sum == target){
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(nums[i]) ;
                    tmp.add(nums[left]) ;
                    tmp.add(nums[right]) ;
                    res.add(tmp) ;
                    //start new round
                    left++ ;
                    if(left == right){
                        break ;
                    }
                }else if(sum < target){
                    left++ ;
                }else if(sum > target){
                    right-- ;
                }
            }
        }

        List<List<Integer>> res_list = new ArrayList<>() ;
        Iterator it = res.iterator() ;
        while(it.hasNext()){
            res_list.add((List<Integer>) it.next()) ;
        }
        return res_list ;
    }
    public static void main(String[] args) {
        int[] num = {-2,0,1,1,2};
        _15_3Sum obj = new _15_3Sum() ;
        List<List<Integer>> res = obj.threeSum(num) ;
        System.out.println(res);
    }
}

/**
 * 添加一些限制条件
 * class Solution {
 *     public List<List<Integer>> threeSum(int[] nums) {
 *         List<List<Integer>> result = new ArrayList<>();
 *         if (nums == null || nums.length < 3) {
 *             return result;
 *         }
 *
 *         Arrays.sort(nums);
 *
 *         for (int i = 0; i < nums.length; i++) {
 *             if (i > 0 && nums[i] == nums[i - 1]) {
 *                 continue;
 *             }
 *
 *             int target = -nums[i];
 *             int left = i + 1;
 *             int right = nums.length - 1;
 *             while (left < right) {
 *                 int sum = nums[left] + nums[right];
 *                 if (sum < target) {
 *                     left++;
 *                 } else if (sum > target) {
 *                     right--;
 *                 } else {
 *                     result.add(Arrays.asList(nums[i], nums[left], nums[right]));
 *                     left++;
 *                     right--;
 *                     while (left < right && nums[left] == nums[left - 1]) {
 *                         left++;
 *                     }
 *                 }
 *             }
 *         }
 *         return result;
 *     }
 * }
 * Runtime: 17 ms, faster than 93.78% of Java online submissions for 3Sum.
 * Memory Usage: 43.1 MB, less than 57.02% of Java online submissions for 3Sum.
 * */

/**
 * 315/318 时间爆了
 *     public List<List<Integer>> threeSum(int[] nums) {
 *         if(nums.length == 0){
 *             return new ArrayList<>() ;
 *         }
 *         Set<List<Integer>> res = new HashSet<>();
 *         // sort
 *         Arrays.sort(nums);
 *         for(int i = 0 ; i < nums.length ; i++){
 *             for(int j = i + 1 ; j < nums.length ; j++){
 *                 for(int k = j + 1 ; k < nums.length ; k++){
 *                     if(nums[i] + nums[j] + nums[k] == 0){
 *                         List<Integer> tmp = new ArrayList<Integer>();
 *                         tmp.add(nums[i]) ;
 *                         tmp.add(nums[j]) ;
 *                         tmp.add(nums[k]) ;
 *                         res.add(tmp) ;
 *                     }
 *                 }
 *             }
 *         }
 *
 *         List<List<Integer>> res_list = new ArrayList<>() ;
 *         Iterator it = res.iterator() ;
 *         while(it.hasNext()){
 *             res_list.add((List<Integer>) it.next()) ;
 *         }
 *         return res_list ;
 *     }
 * */