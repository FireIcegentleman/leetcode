package SwordOffer;
/**
 * 2021/10/06
 *
 * 1～n 整数中 1 出现的次数
 *
 * 京东技术面
 * */
public class _43_CountDigitOne {
    public int res ;
    // 1~n中字符‘1’出现的次数
    // 超时 35/39
    public int countDigitOne_force(int n) {
        res = 0 ;

        for (int i = 1 ; i <= n ; i++){
            cal(i) ;
        }

        return res ;
    }

    // 计算i的十进制表示中有几个1？
    private void cal(int i) {
        String str = String.valueOf(i) ;
        char[] c = str.toCharArray() ;
        for (int j = 0 ; j < c.length ; j++){
            if (c[j] == '1'){
                res++ ;
            }
        }
    }

    // 1~n中字符‘1’出现的次数
    public int countDigitOne_(int n) {
        res = 0 ;
        int mod = 0 ;
        int k = 0 ;
        while(n > 0){// 通过条件判断一个数字中有几个1
            k = n ;
            while(k >= 10){
                mod = k % 10 ;
                if (mod == 1){
                    res++ ;
                }
                k /= 10 ;
            }
            if (k == 1){
                res++ ;
            }
            n-- ;
        }
        return res ;
    }

    // 高低位
    public int countDigitOne(int n){
        int digit = 1 , res = 0 ;
        int high = n / 10 , cur = n % 10 , low = 0 ;
        while (high != 0 || cur != 0){
            if (cur == 0){
                res += high * digit ;
            }else if(cur == 1){
                res += high * digit + low + 1 ;
            }else{
                res += (high + 1) * digit ;
            }
            low = low + cur * digit ;
            cur = high % 10 ;
            high /= 10 ;
            digit *= 10 ;
        }
        return res ;
    }
    public static void main(String[] args) {
        _43_CountDigitOne obj = new _43_CountDigitOne() ;
        int n = 12 ;
        System.out.println(obj.countDigitOne(n));
    }
}
