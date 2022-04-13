package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *异常对象有两个非常重要的方法：
 *  *
 *  *      获取异常简单的描述信息：
 *  *          String msg = exception.getMessage();
 *  *
 *  *      打印异常追踪的栈堆信息
 *  *          exception.printStackTrace();
 *
 *------------------------------------------------------
 * 我们以后查看异常的追踪信息，我们该怎么看，可以快速调试程序呢？
 *      java.io.FileNotFoundException: C:\Users\李玉堂\Desktop\java (拒绝访问。)
 * 	        at java.base/java.io.FileInputStream.open0(Native Method)
 * 	        at java.base/java.io.FileInputStream.open(FileInputStream.java:212)
 * 	        at java.base/java.io.FileInputStream.<init>(FileInputStream.java:154)
 * 	        at java.base/java.io.FileInputStream.<init>(FileInputStream.java:109)
 * 	        at Test.Exception01.ExceptionBase.ExceptionCheck.m4(ExceptionCheck.java:47)
 * 	        at Test.Exception01.ExceptionBase.ExceptionCheck.m3(ExceptionCheck.java:43)
 * 	        at Test.Exception01.ExceptionBase.ExceptionCheck.m2(ExceptionCheck.java:40)
 * 	        at Test.Exception01.ExceptionBase.ExceptionCheck.m1(ExceptionCheck.java:37)
 *      	at Test.Exception01.ExceptionBase.ExceptionCheck.main(ExceptionCheck.java:23)
 *                  因为47行出问题导致了43
 *                  43出问题导致了40行
 *                  40行错误导致了37
 *                  37错误导致了23
 *                  应该先查看47行代码，47行是代码错误的根源
 *      ------------------------------------------------------------------------
 *      1.异常追踪信息从上往下一行一行往下看，但是注意的是sun公司写的代码就不用看了，主要的问题出现在自己编写的代码上
 *      2.sun公司写的代码和自己写的代码区别在于类名，看包名也可以区分开
 *
 */

public class ExceptionCheck {
    public static void main(String[] args) {
        try {
            m1();
        } catch (FileNotFoundException e) {
           String str = e.getMessage();
            System.out.println(str);
            //打印异常的栈堆追踪信息
            //在实际开发中，建议使用这个，养成好习惯，不然出问题你也不知道
            e.printStackTrace();
        }
        /**
         * 后续的代码会继续执行，不会停，所以异常机制会使程序更健壮
         * 百度的服务器不能随便停，当服务器出现异常之后，应该继续往下走，很健壮（服务器不会因为异常而宕机，死机）
         */
        System.out.println("hello");
    }

    private static void m1() throws FileNotFoundException {
        m2();
    }
    private static void m2() throws FileNotFoundException {
        m3();
    }
    private static void m3() throws FileNotFoundException {
        m4();
    }
    private static void m4() throws FileNotFoundException {
        //这里并不是异常对象
        new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");
    }

}

