package All;

/**
 * 2021/11/16
 *
 * 最后一个单词的长度
 *
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * */
public class _58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1 ;

        int left = s.length() - 1 ;
        int right = s.length() - 1 ;

        while (index >= 0){
            if(s.charAt(index) == ' '){
                index-- ;
            }else{
                break;
            }
        }

        right = index ;

        while (index >= 0){
            if (s.charAt(index) != ' '){
                left = index ;
            }else{
                break;
            }
            index--;
        }

        return right - left  + 1 ;
    }

    public static void main(String[] args) {
        _58_LengthOfLastWord obj = new _58_LengthOfLastWord() ;
        String s = "   fly me   to   the moon  " ;
        System.out.println(obj.lengthOfLastWord(s));
    }
}
