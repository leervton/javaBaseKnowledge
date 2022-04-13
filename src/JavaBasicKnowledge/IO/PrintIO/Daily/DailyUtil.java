package JavaBasicKnowledge.IO.PrintIO.Daily;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 利用标准输出流制成日志工具
 */
public class DailyUtil {
    /*
    记录日志的方法
     */
    public static void log(String arg) {
        try {
            //指向一个日志文件地址
            PrintStream ps = new PrintStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\java\\date",true));
            //改变输出方法
            System.setOut(ps);
            //日期当前时间
            Date nowTime = new Date();
            //日期格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
            //日期格式化
            String str = sdf.format(nowTime);

            System.out.println(str +":"+arg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
