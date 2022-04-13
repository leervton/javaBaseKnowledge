package JavaBasicKnowledge.Thread.ThreadSafe.LockPool;

/**
 * 死锁：不出异常，也不出错误
 *      程序一直僵持在那里
 *      这种错误最难处理
 *  例子：当两个程序相向运行时，t1线程锁住对象o1，t2线程锁住对象o2
 *       t1线程如果执行完程序代码块，需要锁住o2，结果发现对象o2已经被锁住
 *       t1进入就绪状态，t2同理也无法锁住o1
 */
public class DeadLock {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();

        Thread t1 = new MyThread01(o1,o2);
        Thread t2 = new MyThread02(o1,o2);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        t2.start();
    }
}
//因为是两个并发线程，他们是随机并发的，所以有可能不会产生死锁，
// 即线程t1或者线程t2抢到的时间片比较多，完全够单个线程执行完毕，呈现同步状态
class MyThread01 extends Thread{
    Object o1;
    Object o2;

    public MyThread01(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){

            }
        }
    }
}

class MyThread02 extends Thread{
    Object o1;
    Object o2;

    public MyThread02(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    @Override
    public void run() {
        synchronized (o2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){

            }
        }
    }
}