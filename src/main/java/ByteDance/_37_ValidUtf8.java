package ByteDance;

import io.ipfs.multibase.BinaryDecoder;

/**
 * 2021/11/11
 *
 * UTF-8 编码验证
 *
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 *
 * 对于 1 字节的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 * 这是 UTF-8 编码的工作方式：
 *
 * 给定一个表示数据的整数数组，返回它是否为有效的 utf-8 编码。
 * */
public class _37_ValidUtf8 {
    // 对于 1 字节的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
    // 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，
    // 后面字节的前两位一律设为 10 。剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
    // 40/49
    public boolean validUtf8_ope(int[] data) {
        // 所有字节长度
        int len = data.length ;

        int cur = 0 ;
        int index = 0 ;
        // 本轮次剩余的字节数
        int round_last = 0 ;

        for ( ; index < len ; index++){
            // 说明当前受前面数字的辐射影响
            if (round_last != 0){
                if (!(data[index] >= 128 && data[index] <= 191)){
                    return false ;
                }
                round_last-- ;
            }else{
                // 重新开始新的一轮
                // 最高4位为1
                cur = data[index] ;
                if (isFirstFour(cur)){
                    round_last = 3 ;
                }else if(isFirstThree(cur)){
                    // 最高3位为1
                    round_last = 2 ;
                }else if(isFirstTwo(cur)){
                    // 最高2位为1
                    round_last = 1 ;
                }else if(isFirstOne(cur)){
                    // 最高1位为1
                    round_last = 0 ;
                }else{
                    // 应该为单字节
                    if (cur >= 128){
                        return false ;
                    }
                }
            }

        }

        if (round_last == 0){
            return true ;
        }else{
            return false ;
        }
    }

    private boolean isFirstOne(int cur) {
        return (cur >= 128 && cur <= 191) ;
    }

    private boolean isFirstTwo(int cur) {
        return (cur >= 192 && cur <= 223) ;
    }

    private boolean isFirstThree(int cur) {
        return (cur >= 224 && cur <= 239) ;
    }

    private boolean isFirstFour(int cur) {
        return (cur >= 240 && cur <= 245);
    }
    public boolean validUtf8(int[] data) {
        // Number of bytes in the current UTF-8 character
        int numberOfByteToProcess = 0 ;

        // Masks to check two most significant bits in a byte.
        // 创建掩码
        int mask1 = 1 << 7 ;
        int mask2 = 1 << 6 ;

        for (int i = 0 ; i < data.length ; i++){
            // If this is the case then we are to start processing a new UTF-8 character.
            if (numberOfByteToProcess == 0){
                int mask = 1 << 7 ;
                while ((mask & data[i]) != 0){
                    numberOfByteToProcess++ ;
                    mask = mask >> 1 ;
                }

                // 1 byte characters
                if (numberOfByteToProcess == 0){
                    continue;
                }

                // Invalid scenarios according to the rules of the problem.
                if (numberOfByteToProcess > 4 || numberOfByteToProcess == 1){
                    return false ;
                }
            }else{
                // data[i] should have most significant bit set and
                // second most significant bit unset. So, we use the two masks
                // to make sure this is the case.
                if (!((data[i] & mask1) != 0 && (data[i] & mask2) == 0)){
                    return false ;
                }
            }

            // We reduce the number of bytes to process by 1 after each integer.
            numberOfByteToProcess -- ;
        }

        return numberOfByteToProcess == 0 ;
    }

    public static void main(String[] args) {
        _37_ValidUtf8 obj = new _37_ValidUtf8() ;
        int[] data = {145} ;
        System.out.println(obj.validUtf8(data));
    }


}
