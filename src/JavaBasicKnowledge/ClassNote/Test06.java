package JavaBasicKnowledge.ClassNote;
import static java.lang.Math.*;

public class Test06 {
    /**
     * 目标：对数值进行取整操作。
     *
     *          方式：
     *
     *          1、四舍五入：Math.round（result）;
     *
     *          记忆方式：单词round，是“附近”的意思
     *
     *          2、向上取整 ：Math.ceil(result)
     *
     *          记忆方式：单词ceil，是“天花板”的意思
     *
     *          3、向下取整 ：Math.floor(result);
     *
     *          记忆方式：单词floor，是“地板”的意思
     *
     */

        public static void main(String[] args) {
            double d1 = 17;
            double d2 = 3;

            double result = d1 / d2;

            /**
             * 四舍五入
             */
            int roundNum = (int) round(result);
            /**
             * 向上取整
             */
            int ceilNum = (int) ceil(result);
            /**
             * 向下取整
             */
            int floorNum = (int) floor(result);

            System.out.println("除法商值：" + result);
            System.out.println("四舍五入：" + roundNum);
            System.out.println("向上取整：" + ceilNum);
            System.out.println("向下取整：" + floorNum);
        }

}
