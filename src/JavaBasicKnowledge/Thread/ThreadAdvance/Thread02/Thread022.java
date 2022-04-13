package JavaBasicKnowledge.Thread.ThreadAdvance.Thread02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;//JUC包下的，属于java的并发包，老Jdk中没有这个包，新特性

/**
 * 实现线程的第三种方式：
 *          实现callable接口
 *      这种方式实现的线程可以获取线程的返回值
 *      之前讲解的那两种方式是无法获取线程的返回值的，因为run()方法返回void
 *
 *      思考：
 *          系统委派一个线程去执行一个任务，该线程执行完任务之后，可能会有一个执行结果，
 *          我们怎么能拿到这个执行结果呢？
 *              使用第三种方式：
 *                  实现callable接口方式
 *                  这种方式的优点：可以获取到线程的执行结果
 *                  这种方式的缺点：效率比较低，在获取t线程执行结果的时候，当前线程受阻塞，效率较低
 *
 */
public class Thread022 {
    public static void main(String[] args) {
        //第一步：创建一个“创建一个未来任务类”对象
        FutureTask task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {//call()方法相当于run()方法，只不过有返回值
                //线程执行一个任务，执行之后可能会有一个执行结果
                //模拟执行
                System.out.println("call method begin");
                Thread.sleep(1000*10);
                System.out.println("call method over");
                int a =100;
                int b = 200;
                return a+b;//自动装箱变成Integer

            }
        });

        //创建线程对象
        Thread t = new Thread(task);
        //启动线程
        t.start();
        //这里是main方法，在主线程中
        //在主线程中，怎么获取t线程的执行结果？
        //get方法的执行，会导致当前线程的阻塞
        try {
            Object o=task.get();
            System.out.println("当前线程的执行结果："+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //main方法这里的程序想要执行必须等待get()方法的结束
        //而get()方法可能需要很久，因为get()方法是为了拿另一个线程的执行结果
        //另一个线程执行是需要时间的
        System.out.println("hello world");
    }
}
