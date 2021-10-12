package SwordOffer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 2021/10/08
 *
 * 数组中数字出现的次数
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * */
public class _56_SingleNumbers {
    // 哈希表算法，时间复杂度高
    public int[] singleNumbers_force(int[] nums) {
        int len = nums.length ;
        if (len == 2){
            return nums ;
        }
        // 双数相消
        HashMap<Integer , Integer> map = new HashMap<>() ;
        for (int i = 0 ; i < len ; i++){
            if (!map.containsKey(nums[i])){// 不包含
                map.put(nums[i] , 1) ;
            }else{
                map.remove(nums[i]) ;
            }
        }
        int[] res = new int[2] ;
        int i = 0 ;
        for (int n : map.keySet()){
            res[i++] = n ;
        }
        return res ;
    }

    // 分组异或
    public int[] singleNumbers(int[] nums) {
        int ret = 0 ;
        for (int num : nums){
            ret ^= num ;
        }

        int div = 1 ;
        while ((div & ret) == 0){
            // 左移一位
            div <<= 1 ;
        }

        int a = 0 , b = 0 ;
        for (int num : nums){
            if ((num & div) == 0){
                a ^= num ;
            }else{
                b ^= num ;
            }
        }
        return new int[]{a , b} ;
    }
    public static void main(String[] args) {
        _56_SingleNumbers obj = new _56_SingleNumbers() ;
        int[] nums = {1,2,10,4,1,4,3,3} ;
        System.out.print(Arrays.toString(obj.singleNumbers(nums)));
    }
}
