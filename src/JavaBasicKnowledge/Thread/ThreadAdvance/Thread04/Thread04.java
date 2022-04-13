package JavaBasicKnowledge.Thread.ThreadAdvance.Thread04;

/**
 * 1.怎么获取当前线程对象？
 *      java.lang.Thread.CurrentThread();
 *      该方法是静态方法
 *      Thread t = Thread.CurrentThread();
 * 2.获取线程对象的名字
 *      String name = 线程对象.getName();
 * 3.修改线程对象的名字
 *      线程对象.setName("线程名字");
 * 4.当线程没有设置名字的时候，默认的名字有什么规律？(了解一下)
 *      Thread-0
 *      Thread-1
 *      Thread-2
 *      Thread-3
 *      ......
 */
public class Thread04 {
    public  void doSome(){
        //这样就不行了
        //this.getName();
        //super.getName();
        //但是这样可以
        String s = Thread.currentThread().getName();
        System.out.println("当前线程的名字："+s);
    }
    public static void main(String[] args) {
        new Thread04().doSome();
        //=========================================================================
        //t就是当前线程对象
        //这个代码出现在main方法当中，所以当前线程就是主线程
        Thread t = Thread.currentThread();
        System.out.println(t.getName());
        //创建线程对象
        MyThread02 thread = new MyThread02();
        //设置线程名字
        //默认线程名字叫做：Thread-排序数字
        thread.setName("t1");
        //获取线程名字
        String s = thread.getName();
        System.out.println(s);

        //启动线程
        thread.start();
        //==============================================================================
        //线程2
        Thread t2 = new Thread();
        t2.setName("t2");
        System.out.println(t2.getName());

        //启动t2线程
        t2.start();

    }
}

class MyThread02 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            //t就是当前线程对象，当前线程是谁呢？
            //当t1线程执行run()方法，那么这个当前线程就是t1
            //当t2线程执行run()方法，那么这个当前线程就是t2
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+"分支线程："+i);
        }
    }
}