/**
 * 2021/05/13
 * */
public class _28_ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;

        int h_len = haystack.length();
        int n_len = needle.length();

        for (int i = 0; i < h_len - n_len + 1; i++) {// 控制搜寻条件的边界值
            if (haystack.substring(i, i + n_len).equals(needle)){
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        _28_ImplementstrStr obj = new _28_ImplementstrStr() ;
        int index = 0 ;

        String haystack = "a" ;
        String needle = "" ;
        index = obj.strStr(haystack , needle) ;

        System.out.println(index);
    }
}
