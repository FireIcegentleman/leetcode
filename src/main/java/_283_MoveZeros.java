import java.util.Arrays;

/**
 * 2021/09/18
 * 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * */
public class _283_MoveZeros {
    // 将i位置之后的所有的数字向前移一位，并在数组最后添加一个0
    private void ope(int[] nums, int i) {
        for ( ; i < nums.length - 1 ; i++){
            nums[i] = nums[i + 1] ;
        }
        nums[nums.length - 1] = 0 ;
    }

    // 编写函数，将所有的零移动到数组末尾，同时保持非零元素的顺序
    // 必须在原数组上操作，不能拷贝额外的数组
    // 尽量减少操作次数
    public void moveZeroes_5(int[] nums) {
        int n = nums.length ;
        if (n == 0){
            return ;
        }

        for (int i = 0 ; i < n ; i++){
            if (nums[i] == 0){
                ope(nums , i ) ;
                i = -1 ;
                n -- ;
            }
        }
    }

    // 两个指针扫
    public void moveZeroes(int[] nums) {
        if (nums.length == 0){
            return ;
        }

        int i , j = 0 ;

        for (i = 0 ; i < nums.length ; i++){
            if (nums[i] != 0){
                nums[j++] = nums[i] ;
            }
        }

        for (; j < nums.length ; j++){
            nums[j] = 0 ;
        }
    }
    public static void main(String[] args) {
        _283_MoveZeros obj = new _283_MoveZeros() ;
        int[] nums = {0,0,1} ;
        obj.moveZeroes(nums);
        System.out.print(Arrays.toString(nums));
    }
}
