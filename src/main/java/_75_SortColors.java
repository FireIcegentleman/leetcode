import java.util.Arrays;

/**
 * 2021/09/09
 * 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * */
public class _75_SortColors {
    public void sortColors_sort_pollow(int[] nums) {
        // 简单排序
        // Arrays.sort(nums);

        // 原地排序是什么意思？ 冒泡排序
        if(nums.length == 0){
            return ;
        }

        int tmp , i , j;
        for(i = nums.length - 1 ; i >= 0 ; i--){
            for(j = 0 ; j < i ; j++){
                if(nums[j] > nums[i]){
                  tmp = nums[i];
                  nums[i] = nums[j] ;
                  nums[j] = tmp ;
                }
            }
        }
    }
    public void quicksort(int[] nums , int low , int high){
        int i , j , p , tmp ;
        if(low >= high){
            return ;
        }

        i = low ;
        j = high ;
        p = nums[low] ;

        while(i < j){
            while(nums[j] >= p && i < j){
                j-- ;
            }
            while(nums[i] <= p && i < j){
                i++;
            }
            tmp = nums[j] ;
            nums[j] = nums[i] ;
            nums[i] = tmp ;
        }

        nums[low] = nums[i] ;
        nums[i] = p ;
        quicksort(nums , low , j-1);
        quicksort(nums , j + 1 , high);
    }
    public void sortColors(int[] nums) {
        // 三指针解法
        int n = nums.length ;
        int p0 = 0 , p2 = n - 1 ;
        int tmp ;

        for(int i = 0 ; i <= p2 ; i++){
            while(i <= p2 && nums[i] == 2){
                tmp = nums[i] ;
                nums[i] = nums[p2];
                nums[p2] = tmp ;
                p2-- ;
            }

            if(nums[i] == 0){
                tmp = nums[i] ;
                nums[i] = nums[p0];
                nums[p0] = tmp ;
                p0++ ;
            }
        }

    }
    public static void main(String[] args) {
        _75_SortColors obj = new _75_SortColors() ;
        int[] nums = {2,0,2,1,1,0};
        //obj.sortColors(nums);
        obj.quicksort(nums,0 , nums.length - 1) ;
        for (int i = 0 ; i < nums.length ; i++){
            System.out.print(nums[i]);
        }
    }
}
/**
 * 三指针解法
 * class Solution {
 *     public void sortColors(int[] nums) {
 *         int n = nums.length;
 *         int p0 = 0, p2 = n - 1;
 *         for (int i = 0; i <= p2; ++i) {
 *             while (i <= p2 && nums[i] == 2) {
 *                 int temp = nums[i];
 *                 nums[i] = nums[p2];
 *                 nums[p2] = temp;
 *                 --p2;
 *             }
 *             if (nums[i] == 0) {
 *                 int temp = nums[i];
 *                 nums[i] = nums[p0];
 *                 nums[p0] = temp;
 *                 ++p0;
 *             }
 *         }
 *     }
 * }
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * */
