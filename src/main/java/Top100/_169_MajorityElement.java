import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2021/09/15
 * 多数元素
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * */
public class _169_MajorityElement {
    public int majorityElement(int[] nums) {
        // 一定存在，摩尔投票法
        int res = 0 , cnt = 0 ;

        for (int num : nums){
            if(cnt == 0){
                res = num ;
                cnt++ ;
            }else{
                if (num == res) {
                    cnt++;
                } else {
                    cnt--;
                }
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        _169_MajorityElement obj = new _169_MajorityElement() ;
        int[] nums = {2,2,1,1,1,2,2} ;
        System.out.println(obj.majorityElement(nums)) ;
    }
}
