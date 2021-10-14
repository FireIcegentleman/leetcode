import java.util.*;

/**
 * 2021/2/5
 * leetcode 18
 * Runtime: 16 ms, faster than 55.55% of Java online submissions for 4Sum.
 * Memory Usage: 39.4 MB, less than 79.95% of Java online submissions for 4Sum.
 * 常规思路，left,right.注意满足要求时 left++ , right--
 * */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < (nums.length - 3) ; i++){
            for(int j = i + 1 ; j < (nums.length - 2) ; j++){
                if(j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1 ;
                int right = nums.length - 1 ;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right] ;
                    if(sum == target){
                        List<Integer> tmp = new LinkedList<>() ;
                        tmp.add(nums[i]) ;
                        tmp.add(nums[j]) ;
                        tmp.add(nums[left]) ;
                        tmp.add(nums[right]) ;
                        res.add(tmp) ;
                        left++ ;
                        //right-- ;
                    }else if(sum < target){
                        left++ ;
                    }else if(sum > target){
                        right-- ;
                    }
                }
            }
        }
        Iterator it = res.iterator() ;
        List<List<Integer>> res_list = new LinkedList<>() ;
        while(it.hasNext()){
            res_list.add((List<Integer>) it.next()) ;
        }
        return res_list ;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1,-1,1,1,2,2} ;
        int target = 0 ;
        _18_4Sum obj = new _18_4Sum() ;
        System.out.println(obj.fourSum(nums , target));
    }
}
