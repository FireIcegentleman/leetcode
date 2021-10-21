package All;

import java.util.*;

/**
 * 2021/10/15
 *
 * 两数之和
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * */
public class _1_TwoSum {
    // 目标值等于target的两个数，但是需要满足时间复杂度小于O(n^2)
    // 排序的时间复杂度 O(nlogn)
    public int[] twoSum_forcce(int[] nums, int target) {
        // 第一个值存放数值，第二个值为索引
        List<int[]> map = new ArrayList<>() ;

        for (int i = 0 ; i < nums.length ; i++){
            map.add(new int[]{nums[i] , i}) ;
        }

        Collections.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int left = 0 , right = map.size() - 1 ;
        while (left < right){
            if (map.get(left)[0] + map.get(right)[0] < target){
                left++ ;
            }else if(map.get(left)[0] + map.get(right)[0] > target){
                right-- ;
            }else{
                return new int[]{map.get(left)[1] , map.get(right)[1]} ;
            }
        }
        return new int[2] ;
    }

    public int[] twoSum(int[] nums , int target){
        HashMap<Integer , Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]) , i} ;
            }
            map.put(nums[i] , i) ;
        }
        return new int[0] ;
    }

    public static void main(String[] args) {
        _1_TwoSum obj = new _1_TwoSum() ;
        int[] nums = {2,7,11,15} ;
        int target = 9 ;
        System.out.print(Arrays.toString(obj.twoSum(nums, target)));
    }
}
