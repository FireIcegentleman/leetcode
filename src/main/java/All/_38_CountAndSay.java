package All;

import javafx.beans.binding.StringBinding;

/**
 * 2021/11/11
 *
 * 外观数列
 *
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 *
 * */
public class _38_CountAndSay {
    // 迭代
    public String countAndSay(int n) {
        String nums = "" ;

        nums += "1" ;
        // 遍历当前的字符数列
        while (n > 1){
            int index = 0 ;
            StringBuilder tmp = new StringBuilder() ;
            while (index < nums.length()){
                char cur = nums.charAt(index) ;
                int count = 1 ;
                while (index < nums.length() - 1 && nums.charAt(index + 1) == cur){
                    count++ ;
                    index++ ;
                }
                tmp.append(count) ;
                tmp.append(cur) ;
                index++ ;
            }
            nums = tmp.toString() ;
            n-- ;
        }
        return nums ;
    }
    public static void main(String[] args) {
        _38_CountAndSay obj = new _38_CountAndSay() ;
        int n = 4 ;
        System.out.println(obj.countAndSay(n));
    }
}
