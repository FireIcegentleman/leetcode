package ByteDance;

import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.HashSet;
import java.util.Set;

/**
 * 2021/10/31
 *
 * 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * */
public class _13_LongestConsecutive {
    // 哈希表
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>() ;

        for (int num : nums){
            s.add(num) ;
        }


        int longestRes = 0 ;

        for (int num : nums){
            // 以nums为起点的序列可能在数组中
            if (!s.contains(num - 1)){
                int currentLength = 1 ;
                int currentNum = num ;

                // 看连续序列后续有多少在这个数组中
                while (s.contains(currentNum + 1)){
                    currentLength++ ;
                    currentNum++ ;
                }
                longestRes = Math.max(longestRes , currentLength) ;
            }
        }
        return longestRes ;
    }
    public static void main(String[] args) {
        _13_LongestConsecutive obj = new _13_LongestConsecutive() ;
        int[] nums = {0,3,7,2,5,8,4,6,0,1} ;
        System.out.println(obj.longestConsecutive(nums));
    }
}
