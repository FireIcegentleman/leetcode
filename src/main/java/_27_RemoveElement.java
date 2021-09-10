/**
 * 2021/5/13
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
 * Memory Usage: 37.9 MB, less than 6.73% of Java online submissions for Remove Element.
 *
 * 自己编写通过
 * */
public class _27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0 ;

        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] != val){
                nums[i] = nums[j] ;
                i++ ;
            }
        }
        return i ;
    }

    public static void main(String[] args) {
        _27_RemoveElement obj = new _27_RemoveElement() ;
        int[] nums = new int[]{3 , 2 , 2 , 3} ;
        int val = 3 ;

        int res = obj.removeElement(nums , val) ;
        System.out.println(res);
    }
}
