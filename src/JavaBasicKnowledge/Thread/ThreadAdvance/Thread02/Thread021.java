package JavaBasicKnowledge.Thread.ThreadAdvance.Thread02;

/**
 * 实现线程的第二种方法：编写一个类，实现java.lang.Runnable接口，实现run()方法
 *      1.定义一个可运行的类
 *          实现Runnable接口，即可
 *          注意：实现Runnable接口只是一个可运行类，而不是一个线程
 *      2.创建线程对象，把可运行类封装到线程对象里面
 *      3.实现线程该方法比较好，因为该方法除了实现接口还可以继承其他类，而java对象只支持单继承，第一种方法无法继承其他类了
 */
public class Thread021 {
    public static void main(String[] args) {
        //创建一个可运行的对象
        //MyRunnable mr = new MyRunnable();
        //将可运行的对象封装成一个线程对象
        //Thread t = new Thread(mr);
        //启动线程，创建一个分支线程栈空间

        //合并以上代码
        Thread t = new Thread(new MyRunnable());
        t.start();
        for (int i=0;i<1000;i++){
            System.out.println("主线程-----》"+i);
        }
    }
}
//这并不是一个线程类，只是一个可运行的类，它还不是一个线程
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<1000;i++){
            System.out.println("分支线程-----》"+i);
        }
    }
}