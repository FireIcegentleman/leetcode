package SwordOffer;

import java.util.HashMap;

/**
 * 2021/10/09
 *
 * 数组中数字出现的次数 II
 *
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * */
public class _56_SingleNumberII {
    // 除了这个数字之外，其余数字都出现了三次
    public int singleNumber_force(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>() ;
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num , 1) ;
            }else if(map.get(num) == 1){
                map.put(num , 2) ;
            }else if(map.get(num) == 2){
                map.remove(num) ;
            }
        }
        for (int key : map.keySet()){
            return key ;
        }
        return 0 ;
    }

    // 考虑数字的二进制形式，对于出现三次的数字，各个二进制位出现的次数都是3的背书。
    // 因此统计所有数字的各二进制中1的出现的次数，并对3求余，则结果为只出现一次的数字
    public int singleNumber_count(int[] nums) {
        int[] count = new int[32] ;

        // 记录所有数字的二进制1总和
        for (int num : nums){
            for (int j = 0 ; j < 32 ; j++){
                count[j] += num & 1 ;
                num >>>= 1 ;
            }
        }

        int res = 0 , m = 3 ;
        for (int i = 0 ; i < 32 ; i++){
            res <<= 1 ;
            res |= count[31 - i] % m ;
        }
        return res ;
    }

    // 位运算
    public int singleNumber(int[] nums) {
        int one = 0 , two = 0 ;
        for (int num : nums){
            one = one ^ num & ~two ;
            two = two ^ num & ~one ;
        }
        return one ;
    }
    public static void main(String[] args) {
        _56_SingleNumberII obj = new _56_SingleNumberII() ;
        int[] nums = {3,3,4,3} ;
        System.out.print(obj.singleNumber(nums));
    }
}
