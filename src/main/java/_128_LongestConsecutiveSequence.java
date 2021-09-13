import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2021/09/13
 * 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 2020字节二面原题
 * */
public class _128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>() ;
        for (int i = 0 ; i < nums.length ; i++){
            s.add(nums[i]) ;
        }

        int longestStreak = 0 ;
        for (int num : nums){
            // 当前是连续序列的第一个数，对于比num小的数字，之前已经计算过了
            if(! s.contains(num - 1)){
                int currentNum = num ;
                int currentStreak = 1 ;

                // 不断遍历是否还有比当前大1的数字
                while(s.contains(currentNum + 1)){
                    currentNum ++ ;
                    currentStreak ++ ;
                }
                longestStreak = Math.max(longestStreak , currentStreak) ;
            }
        }

        return longestStreak ;
    }

    public static void main(String[] args) {
        _128_LongestConsecutiveSequence obj = new _128_LongestConsecutiveSequence() ;
        int[] nums = {0,3,7,2,5,8,4,6,0,1} ;
        System.out.print(obj.longestConsecutive(nums));
    }
}
