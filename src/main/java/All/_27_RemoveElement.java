package All;

/**
 * 2021/10/24
 *
 * 移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * */
public class _27_RemoveElement {
    // 双指针
    public int removeElement(int[] nums, int val) {
        int len = nums.length ;
        // p指示数组，q指示当前正在处理的原数组中的元素

        int p = 0 , q = 0 ;
        while (q < len){
            if(nums[q] != val){
                nums[p] = nums[q] ;
                p++ ;
            }
            q++ ;
        }
        return p + 1 ;
    }
    public static void main(String[] args) {
        _27_RemoveElement obj = new _27_RemoveElement() ;
        int[] nums =  {0,1,2,2,3,0,4,2} ;
        int target = 2 ;
        System.out.println(obj.removeElement(nums , target));
    }
}
