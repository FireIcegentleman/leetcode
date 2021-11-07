package ByteDance;
/**
 * 2021/10/28
 *
 * 字符串相乘
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 **/
public class _4_Multiply {
    /**
     * 计算形式
     *    num1
     *  x num2
     *  ------
     *  result
     */
    // 返回字符串形式表示的乘积
    // 不能换成整型数或者long类型去做，因为会出现类型溢出
    // 字符类型，逐位运算
    public String multiply(String num1, String num2) {
        if (num1.equals("0")  || num2.equals("0")){
            return "0" ;
        }

        String res = "0" ;

        for (int i = num2.length() - 1 ; i >= 0 ; i--){
            // 当前num2中的当前第i位
            int n2 = num2.charAt(i) - '0' ;

            StringBuilder tmp = new StringBuilder() ;

            // 补0
            for (int j = 0 ; j < num2.length() - i - 1 ; j++){
                tmp.append(0) ;
            }
            int carry = 0 ;

            for (int j = num1.length() - 1 ; j >= 0 || carry != 0 ; j--){
                // 当前num1中的当前位数
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0' ;
                int sum = (n1 * n2 + carry) % 10 ;
                carry = (n1 * n2 + carry) / 10 ;
                tmp.append(sum) ;
            }

            res = addString(res , tmp.reverse().toString()) ;
        }
        return res ;
    }

    // 两个字符串的相加，倒过来加之后，再倒过来返回结果
    private String addString(String res, String tmp) {
        StringBuilder result = new StringBuilder() ;
        int carry = 0 ;

        for (int i = res.length() - 1 , j = tmp.length() - 1 ; i >= 0 || j >= 0 || carry != 0 ; i-- , j--){
            int x = i < 0 ? 0 : res.charAt(i) - '0' ;
            int y = j < 0 ? 0 : tmp.charAt(j) - '0' ;
            int sum = (x + y + carry) % 10 ;
            carry = (x + y + carry) / 10 ;
            result.append(sum) ;
        }
        return result.reverse().toString() ;
    }

    // 优化竖式，使用数组
    /**
     * 乘数 num1 位数为 MM，被乘数 num2 位数为 NN， num1 x num2 结果 res 最大总位数为 M+N
     * num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。
     * */
    public String multiply_(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0" ;
        }

        int[] res = new int[num1.length() + num2.length()] ;

        for (int i = num1.length() - 1 ; i >= 0 ; i--){
            int n1 = num1.charAt(i) - '0' ;
            for (int j = num2.length() - 1 ; j >= 0 ; j--){
                int n2 = num2.charAt(j) - '0' ;
                int sum = (res[i + j + 1] + n1 * n2) ;
                res[i + j + 1] = sum % 10 ;
                res[i + j] += sum / 10 ;
            }
        }

        StringBuilder ans = new StringBuilder() ;
        for (int i = 0 ; i < res.length ; i++){
            if (res[0] == 0 && i == 0){
                continue;
            }
            ans.append(res[i]) ;
        }
        return ans.toString() ;
    }
    public static void main(String[] args) {
        _4_Multiply obj = new _4_Multiply() ;
        String num1 = "123" ;
        String num2 = "456" ;
        System.out.println(obj.multiply_(num1 , num2));
    }
}
