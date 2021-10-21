package All;

import SwordOffer._12_PathInMatrix;

/**
 * 2021/10/20
 *
 * 整数转罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * */
public class _12_IntToRoman {
    public int[] nums = {1 , 4 , 5 , 9 , 10 , 40 , 50 , 90 , 100 , 400 , 500 , 900 , 1000} ;
    public String[] roman = {"I" , "IV" , "V" , "IX" , "X" , "XL" , "L" , "XC" , "C" , "CD" , "D", "CM", "M"} ;
    public String intToRoman(int num) {
        // 从后向前减
        int len = nums.length ;
        int index = len - 1 ;

        StringBuilder res = new StringBuilder() ;
        while (num > 0){
            // 找到num可被拆分的最大的元素
            while (num < nums[index]){
                index-- ;
            }
            num -= nums[index] ;
            res.append(roman[index]) ;
        }
        return res.toString() ;
    }

    public static void main(String[] args) {
        _12_IntToRoman obj = new _12_IntToRoman() ;
        int num = 1994 ;
        System.out.println(obj.intToRoman(num));
    }
}
