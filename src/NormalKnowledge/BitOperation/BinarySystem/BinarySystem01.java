package NormalKnowledge.BitOperation.BinarySystem;

/**
 * 二进制运算
 */
public class BinarySystem01 {
    public static void main(String[] args) {
        /**
         * 位运算符 >>
         *      >>1 右移一位
         *      >>2 右移两位
         *      10的二进制是：1010 =========1*（2^3）+0*(2^2)+1*(2^1)+0*(2^0)
         *                  二进制换算十进制
         *              64  32  16  8  4  2  1
         *       2^(5-1)   2^(4-1)   2^(3-1)  2^(2-1)   2^(1-1)
         *              2^4  2^3  2^2  2^1  2^0
         */
        System.out.println(10>>1);
    }
}
