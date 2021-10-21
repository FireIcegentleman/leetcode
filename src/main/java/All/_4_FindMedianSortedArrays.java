package All;

import java.util.Arrays;

/**
 * 2021/10/17
 *
 * 寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * */
public class _4_FindMedianSortedArrays {
    // 两个正序数组的中位数
    public double findMedianSortedArrays_force(int[] nums1, int[] nums2) {
        int len1 = nums1.length ;
        int len2 = nums2.length ;

        int[] nums = new int[len1 + len2] ;
        for (int i = 0 ; i < len1 ; i++){
            nums[i] = nums1[i] ;
        }
        for (int i = 0 ; i < len2 ; i++){
            nums[i + len1] = nums2[i] ;
        }
        Arrays.sort(nums);

        int len = len1 + len2 ;
        if ((len) % 2 == 0){// 偶数个数
            return (nums[len / 2 - 1] * 1.0 + nums[len / 2] * 1.0) / 2.0 ;
        }else{// 奇数个数
            return nums[(len - 1) / 2] * 1.0 ;
        }
    }

    // 要求时间复杂度是O(log(m+n))的话，实际上只能想到二分法
    // 换一种思路，题目是求中位数，其实就是求第k小的数字的一种特殊情况
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length ;
        int n = nums2.length ;

        // 因为索引是从0开始的，所以索引为k+1，结合奇偶情况
        int left = (m + n + 1) / 2 ;
        int right = (m + n + 2) / 2 ;

        // 奇数的情况会得到两个相同的值
        return (getKth(nums1 , 0 , m - 1 , nums2 , 0 , n - 1 , left) + getKth(nums1 , 0 , m - 1 , nums2 , 0 , n - 1 , right)) * 0.5 ;
    }

    private double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        // len代表当前数组（也可能是递归排除后的数组），在当前挑选范围内的的元素个数
        int len1 = end1 - start1 + 1 ;
        int len2 = end2 - start2 + 1 ;

        if (len1 > len2){
            return getKth(nums2 , start2 , end2 , nums1, start1 , end1 , k) ;
        }

        if (len1 == 0){
            return nums2[start2 + k - 1] ;
        }

        if (k == 1){
            return Math.min(nums1[start1] , nums2[start2]) ;
        }

        //为了防止数组长度小于 k/2,每次比较都会从当前数组所生长度和k/2作比较，取其中的小的(如果取大的，数组就会越界)
        //然后素组如果len1小于k / 2，表示数组经过下一次遍历就会到末尾，然后后面就会在那个剩余的数组中寻找中位数
        int i = start1 + Math.min(k / 2 , len1) - 1 ;
        int j = start2 + Math.min(k / 2 , len2) - 1 ;

        // 如果nums1[i] > nums2[j]，表示nums2数组中包含j索引，之前的元素，逻辑上全部淘汰，即下次从J+1开始。
        // 而k则变为k - (j - start2 + 1)，即减去逻辑上排出的元素的个数(要加1，因为索引相减，相对于实际排除的时要少一个的)
        if (nums1[i] > nums2[j]){// nums2 中 清除j之前的元素
            return getKth(nums1 , start1 , end1 , nums2 , j + 1 , end2 , k - (j - start2 + 1)) ;
        }else{// nums1 中 清除i之前的元素
            return getKth(nums1 , i + 1 , end1 , nums2 , start2 , end2 , k - (i - start1 + 1)) ;
        }
    }

    public static void main(String[] args) {
        _4_FindMedianSortedArrays obj = new _4_FindMedianSortedArrays() ;
        int[] nums1 = {1,2} ;
        int[] nums2 = {3,4} ;
        System.out.println(obj.findMedianSortedArrays(nums1 , nums2));
    }
}
