package JavaBasicKnowledge.Thread.ThreadAdvance.ThreadAdvancedBase;

/**
 * 了解：关于线程的优先级
 */
public class ThreadManagement {
    public static void main(String[] args) {
        //设置主线程的优先级为1
        Thread.currentThread().setPriority(1);
       /*System.out.println("最高优先级"+Thread.MAX_PRIORITY);
        System.out.println("最低优先级"+Thread.MIN_PRIORITY);
        System.out.println("默认优先级"+Thread.NORM_PRIORITY);
        */

        //获取当前线程对象，获取当前线程的优先级
        Thread currentThread =Thread.currentThread();
        //main线程的默认优先级是5
        //System.out.println(currentThread.getName()+"线程的默认优先级是："+currentThread.getPriority());

        Thread t = new Thread(new MyRunnable04());
        t.setPriority(10);
        t.setName("t");
        t.start();
        //优先级较高的，抢到的cpu时间片相对多一些
        for (int i =0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"------->"+i);
        }
    }
}

class MyRunnable04 implements Runnable{
    @Override
    public void run() {
        //获取线程的优先级
        //System.out.println(Thread.currentThread().getName()+"线程的默认优先级是："+Thread.currentThread().getPriority());
        for (int i =0;i<1000;i++){
            System.out.println(Thread.currentThread().getName()+"------->"+i);
        }
    }
}