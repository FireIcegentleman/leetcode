package SwordOffer;
/**
 * 2021/10/11
 *
 * 左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * */
public class _58_ReverseLeftWords{
    // 左旋转
    public String reverseLeftWords(String s, int n) {
        String str_back = s.substring(0 , n) ;
        String str_front = s.substring(n , s.length()) ;

        return str_front + str_back ;
    }
    public static void main(String[] args) {
        _58_ReverseLeftWords obj = new _58_ReverseLeftWords() ;
        String s = "abcdefg" ;
        int k = 2 ;
        System.out.print(obj.reverseLeftWords(s , k));
    }
}
