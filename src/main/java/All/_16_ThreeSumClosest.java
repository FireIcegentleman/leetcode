package All;

import SwordOffer._16_Pow;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.Map;

/**
 * 2021/10/21
 *
 * 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * */
public class _16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = 0 ;
        int len = nums.length ;
        int min_clost = Integer.MAX_VALUE ;

        for (int i = 0 ; i < len ; i++){
            int left = i + 1 ;
            int right = len - 1 ;
            while (left < right){
                int tmp = nums[i] + nums[left] + nums[right] ;
                if (tmp == target){
                    return target ;
                }else if (tmp < target){
                    if (Math.abs(tmp - target) < min_clost){
                        res = tmp ;
                        min_clost = Math.abs(tmp - target) ;
                    }
                    left++ ;
                }else{
                    if (Math.abs(tmp - target) < min_clost){
                        res = tmp ;
                        min_clost = Math.abs(tmp - target) ;
                    }
                    right-- ;
                }
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        _16_ThreeSumClosest obj = new _16_ThreeSumClosest() ;
        int[] nums = {0,2,1,-3} ;
        int target = 1 ;
        System.out.println(obj.threeSumClosest(nums , target));
    }
}
