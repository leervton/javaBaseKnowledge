package JavaBasicKnowledge.Time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time02 {
    public static void main(String[] args) {
        //这个时间是什么时间？
        //1970/1/1 00：00：00 001
        Date time = new Date(1);//注意：此处参数是一个毫秒

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss sss");
        String s = sdf.format(time);

        //北京是东8区，与格林威治这个标准国际时间差8个小时
        System.out.println(s);//1970-01-01 08:00:00 000


        //获取昨天的此时的时间
        /**
         * 1.获取今天到1970-1-1的总毫秒数
         * 2.减去今天的24个小时所包含的毫秒数
         * 3.通过SimpleDateFormat来格式化
         */
        Date time01 = new Date(System.currentTimeMillis()-1000*60*60*24);
        String str = sdf.format(time01);
        System.out.println(str);//2020-07-12 23:02:53 053

        //获取去年的今天的此时时间
    }
}
