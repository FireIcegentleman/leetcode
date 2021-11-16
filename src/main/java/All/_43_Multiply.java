package All;
/**
 * 2021/11/13
 *
 * 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * */
public class _43_Multiply {
    // 两个字符串相乘
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0" ;
        }
        String res = "0" ;

        for (int i = num2.length() - 1 ; i >= 0 ; i--){
            int n2 = num2.charAt(i) - '0' ;
            StringBuilder tmp = new StringBuilder() ;

            // 补零
            // 有颠倒的操作，颠倒0就去后面了，有*10 *100的效果
            for (int j = 0 ; j < num2.length() - i - 1 ; j++){
                tmp.append("0") ;
            }

            int carry = 0 ;

            for (int j = num1.length() - 1 ; j >= 0 || carry != 0 ; j--){
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0' ;
                int sum = (n1 * n2 + carry) % 10 ;
                carry = (n1 * n2 + carry) / 10 ;
                tmp.append(sum) ;
            }
            res = addString(res , tmp.reverse().toString()) ;
        }
        return res ;
    }

    // 字符串相加
    private String addString(String res, String toString) {
        StringBuilder result = new StringBuilder() ;
        int carry = 0 ;

        for (int i = res.length() - 1 ,  j = toString.length() - 1 ; i >= 0 || j >= 0 || carry != 0 ; i-- , j--){
            int x = i < 0 ? 0 : res.charAt(i) - '0' ;
            int y = j < 0 ? 0 : toString.charAt(j) - '0' ;
            int sum = (x + y + carry) % 10 ;
            carry = (x + y + carry) / 10 ;
            result.append(sum) ;
        }
        return result.reverse().toString() ;
    }


    public static void main(String[] args) {
        _43_Multiply obj = new _43_Multiply() ;
        String num1 = "123" ;
        String num2 = "456" ;

        System.out.println(obj.multiply(num1 , num2));
    }
}
