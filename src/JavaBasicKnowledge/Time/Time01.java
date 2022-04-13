package JavaBasicKnowledge.Time;

/**
 * 获取自1970年1月1日 00：00：00 000 到当前系统时间的总毫秒数
 * 1秒 = 1000毫秒
 *
 * 简单总结一下System类的相关方法
 * System.out【out是System类的静态变量】
 * System.out.println()【println()方法不是System类的，是PrintStream类的方法】
 * System.gc()【建议启动垃圾回收器】
 * System.currentTimeMillis() 【获取自1970年1月1日到系统当前时间的总毫秒数】
 * System.exit(0) 【退出jvm】
 */
public class Time01 {
    public static void main(String[] args) {
        //获取自1970年1月1日 00：00：00 000 到当前系统时间的总毫秒数
        Long timeCount = System.currentTimeMillis();
        System.out.println(timeCount);
        /**
         * 需求：如何统计一个方法执行所耗费的时长
         * 1.在调用目标方法之前，记录一个毫秒数
         * 2.在执行完目标方法之后记录一个毫秒数
         */
        long begin = System.currentTimeMillis();
        Count();
        long end = System.currentTimeMillis();
        System.out.println("耗时："+(end - begin)+"毫秒");

    }
    //需求：统计一个方法执行所耗费的时长
    public static void Count(){
        for(int i = 0;i <1000; i++){
            System.out.println("i="+ i);
        }
    }
}
