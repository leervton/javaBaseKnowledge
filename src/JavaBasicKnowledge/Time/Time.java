package JavaBasicKnowledge.Time;
//alt+Enter,快捷键导包
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
    public static void main(String[] args) throws Exception {
        //获取当前系统时间（精确到毫秒的系统当前时间）
        Date nowTime = new Date();
        //java.util.Date类的toString()方法已经被重写
        System.out.println(nowTime.toString());//Mon Jul 13 20:31:37 CST 2020

        //日期格式化？将日期类型Date，按照指定的格式类型进行转换：date----转换成具有一定格式的日期字符串----》String
        //SimpleDateFormat是java.text包下专门负责日期格式化的
        /**
         * yyyy年（年是4位）
         * MM  月（月是2位）
         * dd  日（日是2位）
         * HH  时（2）
         * mm  分（2）
         * ss  秒（2）
         * SSS 毫秒（毫秒是三位数，最高999，1000毫秒=1秒）
         * 注意：在日期格式中，除了y M d H m s S这些字符不能随便写之外，剩下的符号格式，自己随意组织
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");

        String nowTimeString = sdf.format(nowTime);

        System.out.println(nowTimeString);

        /**
         * ------------------------------------------------------------------------------------------------
         */
        //假设现在有一个日期字符串String,怎么转换成Date类型？
        String time = "2008-08-05 08:08:08 888";
        //格式不能随便写，要和日期字符串格式相同
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date date = sdf2.parse(time);//此处报错是有异常发生，在方法区扔出异常即可

        System.out.println(date);
    }
}
