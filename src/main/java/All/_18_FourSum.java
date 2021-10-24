package All;
import java.util.*;

/**
 * 2021/10/22
 *
 * 四数之和
 *
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
 *      1. 0 <= a, b, c, d < n
 *      2. a、b、c 和 d 互不相同
 *      3. nums[a] + nums[b] + nums[c] + nums[d] == target
 *
 * */
public class _18_FourSum {
    // 四数之和
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>() ;

        int len = nums.length ;
        if (len < 4){
            return new ArrayList<>() ;
        }

        int index = 0 ;

        for ( ; index < len - 3 ; index++){
            if (nums[index] + nums[index+1] + nums[index+2] + nums[index+2] > target ){
                break;
            }
            if (index > 0 && nums[index] == nums[index - 1]){
                continue;
            }
            int num_1 = nums[index] ;
            for (int j = index + 1 ; j < len - 2 ; j++){
                int tmp = target - num_1 - nums[j] ;

                int left = j + 1 ;
                int right = len - 1 ;
                while (left < right){
                    if (nums[left] + nums[right] == tmp){
                        res.add(Arrays.asList(num_1 , nums[j] , nums[left] , nums[right])) ;

                        while (left < right && nums[left + 1] == nums[left]){
                            left++ ;
                        }
                        while (left < right && nums[right - 1] == nums[right]){
                            right-- ;
                        }
                        left++ ;
                        right-- ;
                    }else if (nums[left] + nums[right] < tmp){
                        left++ ;
                    }else{
                        right-- ;
                    }
                }
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        _18_FourSum obj = new _18_FourSum() ;
        int[] nums = {2,2,2,2} ;
        int target = 8 ;

        List<List<Integer>> res = obj.fourSum(nums , target) ;
        for (int i = 0 ; i < res.size() ; i++){
            System.out.print("[");
            for (int j = 0 ; j < res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println("]");
        }
    }
}
