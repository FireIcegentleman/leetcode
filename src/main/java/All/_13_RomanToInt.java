package All;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 2021/10/20
 *
 * 罗马数字转整数
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * */
public class _13_RomanToInt {

    public Map<String , Integer> map = new HashMap<>() ;
    public int romanToInt_force(String s) {
        /**
         * "I" , "IV" , "V" , "IX" , "X" , "XL" , "L" , "XC" , "C" , "CD" , "D", "CM", "M"
         * 1 , 4 , 5 , 9 , 10 , 40 , 50 , 90 , 100 , 400 , 500 , 900 , 1000
         * */
        map.put("I" , 1) ;
        map.put("IV" , 4) ;
        map.put("V" , 5) ;
        map.put("IX" , 9) ;
        map.put("X" , 10) ;
        map.put("XL" , 40) ;
        map.put("L" , 50) ;
        map.put("XC" , 90) ;
        map.put("C" , 100) ;
        map.put("CD" , 400) ;
        map.put("D" , 500) ;
        map.put("CM" , 900) ;
        map.put("M" , 1000) ;
        int res = 0 ;

        int index = 0 ;
        while (index < s.length()){
            if (index < s.length() - 1 && map.containsKey("" + s.charAt(index) + s.charAt(index + 1))){
                res += map.get("" + s.charAt(index) + s.charAt(index + 1)) ;
                index += 2 ;
                continue;
            }else if(map.containsKey("" + s.charAt(index))){
                res += map.get("" + s.charAt(index)) ;
                index++ ;
                continue;
            }
        }

        return res ;
    }

    public int romanToInt_replace(String s) {
        s = s.replace("IV" , "a") ;
        s = s.replace("IX" , "b") ;
        s = s.replace("XL" , "c") ;
        s = s.replace("XC" , "d") ;
        s = s.replace("CD" , "e") ;
        s = s.replace("CM" , "f") ;

        int res = 0 ;
        for (int i = 0 ; i < s.length() ; i++){
            res += getValue_(s.charAt(i)) ;
        }
        return res ;
    }

    public int getValue_(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            case 'a':
                return 4; // IV
            case 'b':
                return 9; // IX
            case 'c':
                return 40; // XL
            case 'd':
                return 90; // XC
            case 'e':
                return 400; // CD
            case 'f':
                return 900; // CM
        }
        return 0 ;
    }


    /**
     * 按照题目的描述，可以总结如下规则：
     *
     * 罗马数字由 I,V,X,L,C,D,M 构成；
     * 当小值在大值的左边，则减小值，如 IV=5-1=4；
     * 当小值在大值的右边，则加小值，如 VI=5+1=6；
     * 由上可知，右值永远为正，因此最后一位必然为正。
     *
     * */
    public int romanToInt(String s) {
        int res = 0 ;
        int prev = getValue(s.charAt(0)) ;

        for (int i = 1 ; i < s.length() ; i++){
            int num = getValue(s.charAt(i)) ;
            if (prev < num){
                res -= prev ;
            }else{
                res += prev ;
            }
            prev = num ;
        }
        res += prev ;
        return res ;
    }
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public static void main(String[] args) {
        _13_RomanToInt obj = new _13_RomanToInt() ;
        String s = "III" ;
        System.out.println(obj.romanToInt(s));
    }


}
