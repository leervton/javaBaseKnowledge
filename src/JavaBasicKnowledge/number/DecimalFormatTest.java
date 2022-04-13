package JavaBasicKnowledge.number;

import java.text.DecimalFormat;

/**
 * 数字格式化
 */
public class DecimalFormatTest {
    public static void main(String[] args) {
        //java.text.DecimalFormatTest 专门负责数字的格式化
        //DecimalFormat df = new DecimalFormat("数字格式");
        /**
         * 数字格式有哪些？
         * #代表任意数字
         * ，代表千分位
         * .代表小数点
         * 0代表不够时补0
         * ---------------------------
         * ###，##.##
         *      表示：加入千分位，保留两位小数
         */
        DecimalFormat df = new DecimalFormat("###,##.##");
        String s = df.format(1234.56);
    }
}
