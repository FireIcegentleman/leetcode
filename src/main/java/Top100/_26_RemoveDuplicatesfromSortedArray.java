/**
 * 2021/5/12
 * 缅怀2008汶川地震中丧失的同胞们
 * */
public class _26_RemoveDuplicatesfromSortedArray {
    // 要求原地去重，并且返回新数组的长度
    public int removeDuplicates(int[] nums) {
        int k = nums.length ;
        if(k == 0){
            return 0 ;
        }

        int i = 0 ;
        for(int j = 0 ; j < k ; j++){
            if(nums[i] != nums[j]){
                i++ ;
                nums[i] = nums[j] ;
            }
        }
        return i + 1 ;
    }

    public static void main(String[] args) {
        _26_RemoveDuplicatesfromSortedArray obj = new _26_RemoveDuplicatesfromSortedArray() ;
        int[] nums = new int[]{1,1,2} ;

        int res = obj.removeDuplicates(nums) ;

        System.out.println(res);
    }
}
