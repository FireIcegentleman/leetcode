import java.util.HashMap;
import java.util.Map;

/**
 * 2021/2/2
 * leetcode 12
 * 如果较小的字母被排在较大的字母之前，则说明要做减法
 * */
public class _13_RomantoInteger {
    public Map<Character , Integer> roman = new HashMap<Character , Integer>() ;
    public int romanToInt(String s) {
        roman.put('I' , 1) ;
        roman.put('V' , 5) ;
        roman.put('X' , 10) ;
        roman.put('L' , 50) ;
        roman.put('C' , 100) ;
        roman.put('D' , 500) ;
        roman.put('M' , 1000) ;

        int res = 0;
        for(int i = 0 ; i < s.length() ; i++){
            int temp = roman.get(s.charAt(i)) ;
            if(i == s.length() - 1 || roman.get(s.charAt(i+1)) <= roman.get(s.charAt(i))){
                res += temp ;
            }else{
                res -= temp ;
            }
        }
        return res ;
    }
    public static void main(String[] args) {
        String s = "III" ;
        _13_RomantoInteger obj = new _13_RomantoInteger();
        System.out.println(obj.romanToInt(s));
    }
}
/**
 * Change the data structure
 * 在时间复杂度上有所降低
 * import java.util.*;
 *
 * class Solution {
 *     public int romanToInt(String s) {
 *         int sum = 0;
 *         int preNum = getValue(s.charAt(0));
 *         for(int i = 1;i < s.length(); i ++) {
 *             int num = getValue(s.charAt(i));
 *             if(preNum < num) {
 *                 sum -= preNum;
 *             } else {
 *                 sum += preNum;
 *             }
 *             preNum = num;
 *         }
 *         sum += preNum;
 *         return sum;
 *     }
 *
 *     private int getValue(char ch) {
 *         switch(ch) {
 *             case 'I': return 1;
 *             case 'V': return 5;
 *             case 'X': return 10;
 *             case 'L': return 50;
 *             case 'C': return 100;
 *             case 'D': return 500;
 *             case 'M': return 1000;
 *             default: return 0;
 *         }
 *     }
 * }
 *
 * 作者：donespeak
 * 链接：https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * */