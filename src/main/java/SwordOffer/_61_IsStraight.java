package SwordOffer;

import javax.swing.plaf.IconUIResource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2021/10/13
 *
 * 扑克牌中的顺子
 *
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 * A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * */
public class _61_IsStraight {
//    public boolean isStraight(int[] nums) {
//        Arrays.sort(nums);
//        // 如果背身就是顺子，则直接返回true
//        int i = 1 ;
//        for ( ; i < nums.length ; i++){
//            if (nums[i - 1] != nums[i] - 1){
//                break;
//            }
//        }
//        if (i == nums.length){
//            return true ;
//        }
//
//        int count = 0 ;
//        for (int j = 0 ; j < nums.length ; j++){
//            if (nums[j] == 0){
//                count++ ;
//            }
//        }
//
//        i = 1 ;
//        for ( ; i < nums.length ; i++){
//            if (nums[i] != 0){
//                break;
//            }
//        }
//        for ( ; i < nums.length ; i++){
//            if (nums[i - 1] != nums[i] - 1){
//                count--;
//                if (count < 0){
//                    break;
//                }
//            }
//        }
//        if (i == nums.length){
//            return true ;
//        }else{
//            return false ;
//        }
//    }

    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>() ;
        int max = 0 , min = 14 ;
        for (int num : nums){
            if (num == 0){
                continue;
            }
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if (set.contains(num)){
                return false ;
            }
            set.add(num) ;
        }
        return max - min < 5 ;
    }
    public static void main(String[] args) {
        _61_IsStraight obj = new _61_IsStraight() ;
        int[] nums = {0,0,1,2,5} ;
        System.out.print(obj.isStraight(nums));
    }

}
