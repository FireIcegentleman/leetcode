package Top100; /**
 * 2021/1/19
 * leetcode 4
 * Runtime: 3 ms, faster than 40.71% of Java online submissions for Median of Two Sorted Arrays.
 * Memory Usage: 40.2 MB, less than 69.41% of Java online submissions for Median of Two Sorted Arrays.
 * */

import java.util.Arrays;

public class _4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] all = new int[nums1.length + nums2.length] ;
        for(int i = 0 ; i < nums1.length ; i++){
            all[i] = nums1[i] ;
        }
        for(int i = nums1.length ; i < nums1.length + nums2.length ; i++){
            all[i] = nums2[i - nums1.length] ;
        }
        Arrays.sort(all);
        if((nums1.length + nums2.length) % 2 == 0){
            return (all[all.length / 2] + all[all.length / 2 - 1]) / 2.0 ;
        }else {
            return all[(all.length - 1) / 2] * 1.0 ;
        }

    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2} ;
        int[] num2 = new int[]{3,4} ;

        _4_MedianOfTwoSortedArrays obj  = new _4_MedianOfTwoSortedArrays() ;
        System.out.println(obj.findMedianSortedArrays(num1 , num2));
    }
}
/**
 * 然而这道题目的主要难点是规定了时间复杂度为O(log(m+n))
 * 普通解法需要遍历两个数组，时间复杂度为O(m+n)
 * class Solution {
 *     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
 *         int n1 = nums1.length;
 *         int n2 = nums2.length;
 *         if (n1>n2)
 *             return findMedianSortedArrays(nums2, nums1);
 *         int k = (n1 + n2 + 1)/2;
 *         int left = 0;
 *         int right = n1;
 *         while(left < right){
 *             int m1 = left +(right - left)/2;
 *             int m2 = k - m1;
 *             if (nums1[m1] < nums2[m2-1])
 *                 left = m1 + 1;
 *             else
 *                 right = m1;
 *         }
 *         int m1 = left;
 *         int m2 = k - left;
 *         int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1-1],
 *                          m2 <= 0 ? Integer.MIN_VALUE : nums2[m2-1]);
 *         if ((n1 + n2) % 2 == 1)
 *             return c1;
 *         int c2 = Math.min( m1 >= n1 ? Integer.MAX_VALUE :nums1[m1],
 *                          m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
 *         return (c1 + c2) * 0.5;
 *
 *     }
 * }
 *
 * */
