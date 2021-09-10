import java.util.Arrays;
/**
 * 2021/1/18
 * leetcode 1
 * */
public class _1_TwoSum {
    public int[] nums ;
    public int target ;

    public _1_TwoSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2] ;
        // 这样写实现了数组深拷贝
        // int[] init = nums ;

        //1. 数组浅拷贝
        int[] init = new int[nums.length];
        System.arraycopy(nums, 0, init, 0, nums.length);

        // 2. JAVA数据排序
        Arrays.sort(nums);
        int right = 0 , left = nums.length - 1 ;
        boolean[] flags = new boolean[nums.length];
        for(int i = 0 ; i < flags.length ; i++){
            flags[i] = true ;
        }
        while(right < left){
            if((nums[right] + nums[left]) < target){
                right++ ;
            }else if((nums[right] + nums[left]) > target){
                left-- ;
            }else{
                 for(int i = 0 ; i < init.length ; i++){
                     if(nums[right] == init[i] && flags[right] == true){
                         res[0] = i ;
                         flags[right] = false ;
                     }else if(nums[left] == init[i] && flags[left] == true){
                         res[1] = i ;
                         flags[left] = false ;
                     }
                 }
                return res ;
            }
        }
        return res ;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,5,11} ;
        int target = 10 ;
        _1_TwoSum two = new _1_TwoSum(nums , target);
        int[] res = two.twoSum(nums , target) ;
        for(int num : res){
            System.out.print(num + " ");
        }
    }
}
