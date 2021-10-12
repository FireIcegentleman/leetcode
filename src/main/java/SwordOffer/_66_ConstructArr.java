package SwordOffer;

import java.util.Arrays;

/**
 * 2021/10/11
 *
 * 构建乘积数组
 *
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * */
public class _66_ConstructArr {
    public int[] constructArr(int[] a) {
        int len = a.length ;
        int[] left = new int[len] ;
        int[] right = new int[len] ;
        int[] res = new int[len] ;

        int leftNum = 1 ;
        for (int i = 0 ; i < len ; i++){
            left[i] = leftNum ;
            leftNum *= a[i] ;
        }

        int rightNum = 1 ;
        for (int i = len - 1 ; i >= 0 ; i--){
            right[i] = rightNum ;
            rightNum *= a[i] ;
        }

        for (int i = 0 ; i < len ; i++){
            res[i] = left[i] * right[i] ;
        }
        return res ;
    }

    public static void main(String[] args) {
        _66_ConstructArr obj = new _66_ConstructArr() ;
        int[] a = {1,2,3,4,5} ;
        System.out.print(Arrays.toString(obj.constructArr(a)));
    }
}
