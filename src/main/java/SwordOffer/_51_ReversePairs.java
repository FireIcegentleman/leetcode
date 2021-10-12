package SwordOffer;
/**
 * 2021/10/08
 *
 * 数组中的逆序对
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * */
public class _51_ReversePairs {
    //  求逆序对个数，若前一个大于后面的数字，则是一个逆序对
    public int reversePairs(int[] nums) {
        // O(n^2) 36 / 139
//        int res = 0 ;
//        for (int i = 0 ; i < nums.length ; i++){
//            for (int j = i ; j < nums.length ; j++){
//                if (nums[i] > nums[j]){
//                    res++ ;
//                }
//            }
//        }
//        return res ;
        // 一定存在O(nlogn)时间复杂度的算法
        // 归并排序
        int len = nums.length ;

        if (len < 2){
            return 0 ;
        }
        int[] copy = new int[len] ;

        for (int i = 0 ; i < len ; i++){
            copy[i] = nums[i];
        }

        int[] temp = new int[len] ;

        return reversePairs(copy , 0 , len - 1 , temp) ;
    }

    // 基于归并排序
    private int reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right){
            return 0 ;
        }

        int mid = left + (right - left) / 2 ;
        int leftPairs = reversePairs(nums , left , mid , temp);
        int rightPairs = reversePairs(nums , mid + 1 , right , temp);

        // 左右半边完成后恰好符合规律
        if (nums[mid] <= nums[mid + 1]){
            return leftPairs + rightPairs ;
        }

        int crossPairs = mergeAndCount(nums , left , mid , right , temp) ;
        return leftPairs + rightPairs + crossPairs ;
    }

    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left ; i <= right ; i++){
            temp[i] = nums[i] ;
        }

        // 左右半边的比较
        int i = left ;
        int j = mid + 1 ;

        int count = 0 ;
        for (int k = left ; k <= right ; k++){
            if (i == mid + 1){// 右边数组遍历完成
                nums[k] = temp[j] ;
                j++ ;
            }else if (j == right + 1){// 左边数组遍历完成
                nums[k] = temp[i] ;
                i++ ;
            }else if (temp[i] <= temp[j]){// 左边小，则直接合并
                nums[k] = temp[i] ;
                i++ ;
            }else{// 右边小，合并后需要看逆序的贡献
                nums[k] = temp[j] ;
                j++ ;
                count += (mid - i + 1) ;
            }
        }
        return count ;
    }

    public static void main(String[] args) {
        _51_ReversePairs obj = new _51_ReversePairs() ;
        int[] nums = {7,5,6,4} ;

        System.out.print(obj.reversePairs(nums));
    }
}
