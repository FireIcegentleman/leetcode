package All;

import java.util.*;

/**
 * 2021/10/21
 *
 * 三数之和
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * */
public class _15_ThreeSum {
    // 和为0且个数为3个元素，过慢了
    public List<List<Integer>> threeSum_force(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>() ;
        if (nums.length < 3){
            return new ArrayList<>() ;
        }
        if (nums[0] > 0){
            return new ArrayList<>() ;
        }

        for (int i = 0 ; i < nums.length  - 2 ; i++){
            int target = 0 - nums[i] ;
            int left = i + 1 ;
            int right = nums.length - 1 ;

            while (left < right){
                if (nums[left] + nums[right] < target){
                    left++ ;
                }else if (nums[left] + nums[right] > target){
                    right-- ;
                }else{
                    List<Integer> tmp = new ArrayList<>() ;
                    tmp.add(nums[i]) ;
                    tmp.add(nums[left]) ;
                    tmp.add(nums[right]) ;
                    res.add(tmp) ;
                    left++ ;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>() ;
        Iterator<List<Integer>> it = res.iterator() ;
        while (it.hasNext()){
            result.add(it.next()) ;
        }
        return result ;
    }

    // 本题的难点在于如何去除重复解
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>() ;

        if (nums.length < 3){
            return new ArrayList<>() ;
        }
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length - 2 ; i++){
            if (nums[i] > 0){
                break ;
            }

            // 去除重复情况，重点1
            if (i > 0 && nums[i] == nums[i - 1]){
                continue ;
            }

            int target = 0 - nums[i] ;

            int left = i + 1 ;
            int right = nums.length - 1 ;
            while (left < right){
                if (nums[left] + nums[right] < target){
                    left++ ;
                }else if (nums[left] + nums[right] > target){
                    right-- ;
                }else{
                    res.add(Arrays.asList(nums[i] , nums[left] , nums[right])) ;
                    //重点2
                    while (left < right && nums[left + 1] == nums[left]){
                        left++ ;
                    }

                    while (left < right && nums[right - 1] == nums[right]){
                        right-- ;
                    }
                    left++ ;
                    right-- ;
                }
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        _15_ThreeSum obj = new _15_ThreeSum() ;
        int[] nums = {-1,0,1,2,-1,-4} ;
        List<List<Integer>> res = obj.threeSum(nums) ;

        for (int i = 0 ; i < res.size() ; i++){
            System.out.print("[");
            for (int j = 0 ; j <res.get(i).size() ; j++){
                System.out.print(res.get(i).get(j) + ",");
            }
            System.out.println("]");
        }
    }
}
