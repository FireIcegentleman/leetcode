/**
 * 2021/09/07
 * 贪心算法
 * */

public class _45_JumpGameII {

    public int jump(int[] nums) {
        int position = nums.length - 1 ;
        int step = 0 ;
        while(position > 0){
            for(int i = 0 ; i < position ; i++){
                if(i + nums[i] >= position){
                    position = i ;
                    step++ ;
                    break;
                }
            }
        }
        return step ;
    }

    public static void main(String[] args) {
        _45_JumpGameII obj = new _45_JumpGameII() ;
        int[] nums = {2,3,1,1,4} ;
        System.out.println(obj.jump(nums));
    }
}
