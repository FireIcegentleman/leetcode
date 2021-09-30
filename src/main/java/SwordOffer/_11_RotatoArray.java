package SwordOffer;
/**
 * 2021/09/29
 *
 * 旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * */
public class _11_RotatoArray {
    // 找到最小元素
    public int minArray(int[] numbers) {
        int n = numbers.length;
        if (n == 0){
            return 0 ;
        }

        for (int i = n - 1 ; i >= 1 ; i--){
            if (numbers[i] < numbers[i - 1]){
                return numbers[i] ;
            }
        }
        return numbers[0] ;
    }

    public static void main(String[] args) {
        _11_RotatoArray obj = new _11_RotatoArray() ;
        int[] nums = {2,2,2,0,1} ;
        System.out.println(obj.minArray(nums));
    }
}
