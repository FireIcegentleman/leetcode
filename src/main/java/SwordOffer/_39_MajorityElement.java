package SwordOffer;
/**
 * 2021/10/06
 *
 * 数组中出现次数超过一半的数字
 *
 * */
public class _39_MajorityElement {
    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int res = 0 ;
        int count = 0 ;

        for (int num : nums){
            if (count == 0){
                res = num ;
            }
            if (num == res){
                count++ ;
            }else{
                count-- ;
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        _39_MajorityElement obj = new _39_MajorityElement() ;
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2} ;
        System.out.println(obj.majorityElement(nums));
    }
}
