package JavaBasicKnowledge.Thread.TreadOtherContent;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器的作用：
 *      间隔特定的时间，执行特定的程序
 *      每周要进行银行账户的总账操作
 *      每天要进行数据的备份操作
 *      在实际开发中，每隔多久执行一段特定的程序，这种需求是很常见的
 *      那么在java中其实可以采用多种方式实现
 *          可以使用sleep方法，睡眠，设置睡眠时长，每到这个时间点醒来，执行任务
 *          这种方式是最原始的定时器，比较low
 *
 *          在java的类库中已经写好了一个定时器：java.util.Timer,可以直接拿来用
 *          不过，这种方式在目前的开发中也很少用，因为现在有很多高级框架都是支持定时任务的
 *
 *          在实际的开发中，目前使用较多的是Spring框架中提供的SpringTask框架，这个框架只需要进行简单的
 *          配置，就可以完成定时器的任务了
 */
public class CountClock {
    //使用定时器指定任务
    public static void main(String[] args){
        //创建定时器对象
        Timer timer = new Timer();
        //Timer timer = new Timer(true);守护线程的方式

        //指定定时任务
        //timer.schedule(定时任务,第一次执行任务时间,间隔多久执行一次);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date firstTime = null;
        try {
            firstTime = sdf.parse("2020-09-22 09:08:00 000");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //timer.schedule(new LogTimerTask(),firstTime,1000*10);

        //采用匿名内部类的方式
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //编写你需要执行的任务就行了
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(sdf.format(new Date())+":成功完成一次数据备份");
            }
        },firstTime,1000*10);
    }
}
//编写一个定时任务类
//假设这是一个记录日志的定时任务
class LogTimerTask extends TimerTask{
    @Override
    public void run() {
        //编写你需要执行的任务就行了
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date())+":成功完成一次数据备份");
    }
}
