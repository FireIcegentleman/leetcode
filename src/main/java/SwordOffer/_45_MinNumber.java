package SwordOffer;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2021/10/09
 *
 * 把数组排成最小的数
 *
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * */
public class _45_MinNumber {
    // 按照字典序排列
    public String minNumber(int[] nums) {
        if (nums.length == 0){
            return "" ;
        }

        String[] asStrs = new String[nums.length] ;
        for (int i = 0 ; i < nums.length ; i++){
            asStrs[i] = String.valueOf(nums[i]) ;
        }

        Arrays.sort(asStrs , (x , y) -> (x + y).compareTo(y + x));
        StringBuilder res = new StringBuilder() ;
        for (int i = 0 ; i < asStrs.length ; i++){
            res.append(asStrs[i])  ;
        }
        return res.toString() ;
    }


    public static void main(String[] args) {
        _45_MinNumber obj = new _45_MinNumber() ;
        int[] nums = {3,30,34,5,9} ;
        System.out.print(obj.minNumber(nums));
    }
}
