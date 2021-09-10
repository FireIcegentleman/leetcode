import java.util.HashMap;
import java.util.Map;

/**
 * 2021/2/2
 * leetcode 12
 * */
public class _12_IntegertoRoman {
    public int[] roman_num = {1000 , 900 , 500 , 400 , 100 , 90 , 50 , 40 , 10 , 9 , 5 , 4 , 1} ;
    public String[] roman = {"M" , "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" , "X" , "IX" , "V" , "IV" , "I"};
    public String intToRoman(int num) {
        String res = "" ;
        for(int i = 0 ; i < roman_num.length ; i++){
            while(num >= roman_num[i]){
                num -= roman_num[i] ;
                res += roman[i] ;
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        int num = 3 ;
        _12_IntegertoRoman obj = new _12_IntegertoRoman() ;
        System.out.println(obj.intToRoman(num)) ;
    }
}
/**
 * 事实上，对于没有被包括在内的900，400之类的数字，也需要被包括在其中
 * class Solution {
 *     public String intToRoman(int num) {
 *         StringBuilder sb = new StringBuilder();
 *         int[]values= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
 *         String[]symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
 *
 *         for(int i=0;i<values.length && num >=0; i++){
 *             while(values[i] <=num){
 *                 num -= values[i];
 *                 sb.append(symbols[i]);
 *             }
 *         }
 *         return sb.toString();
 *     }
 * }
 * */