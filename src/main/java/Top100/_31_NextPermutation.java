import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 2021/5/20
 * 将Int中的数据全排列从小到大排列，然后取出当前的nums对应的下一个
 *
 * 此题目的难点在于如何寻找下一个全排列。从后往前找到第一个开始减小时的数字，与从后往前第一个比他大的数字，然后转置之后的数字
 */
public class _31_NextPermutation {
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public void reverse(int[] nums, int m,int n){
        while(m<n){
            int temp1=nums[m];
            nums[m]=nums[n];
            nums[n]=temp1;
            m++;
            n--;
        }
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        while(i>0 && nums[i-1] >= nums[i]){
            i--;
        }
        if(i == 0){
            reverse(nums,0,nums.length-1);
            return;
        }

        int j = i-1;
        for(int k = nums.length-1 ; k >= 0 ; k--){
            if(nums[k]>nums[j]){
                swap(nums,k,j);
                break;
            }
        }
        reverse(nums,i,nums.length-1);// 如果没有这样的两个数字，则说明当前是最终状态，需要从头开始，直接转置即可
    }

    public static void main(String[] args) {
        _31_NextPermutation obj = new _31_NextPermutation() ;
        int[] nums = new int[]{1,2,3} ;

        obj.nextPermutation(nums);
    }
}
