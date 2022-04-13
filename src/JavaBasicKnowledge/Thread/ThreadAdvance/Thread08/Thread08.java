package JavaBasicKnowledge.Thread.ThreadAdvance.Thread08;

/**
 * 让位，当前线程暂停，回到就绪状态，让给其他线程
 * 静态方法：Thread.yield()
 */
public class Thread08 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.setName("t");
        t.start();

        for (int i=0;i<10000;i++){
            System.out.println(Thread.currentThread().getName()+"------->"+i);

        }
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<10000;i++){
            //每一百次让位一次
            if (i%100==0){
                Thread.yield();//当前线程暂停，回到就绪状态，重新抢夺时间片，让给主线程
                System.out.println("回到就绪状态");
            }
            System.out.println(Thread.currentThread().getName()+"------->"+i);

        }
    }
}