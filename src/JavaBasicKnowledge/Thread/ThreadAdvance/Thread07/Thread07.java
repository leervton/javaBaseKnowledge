package JavaBasicKnowledge.Thread.ThreadAdvance.Thread07;

/**
 * 在java中如何强行终止一个线程的执行
 * https://blog.csdn.net/canot/article/details/51087772
 */
public class Thread07 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable03());
        t.setName("t");
        t.start();

        //模拟五秒
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //五秒之后强行终止t线程
        //缺点：如果当时内存内的信息没保存，容易丢失数据，因为这种方式是突然关闭线程，
        //     而线程没有保存数据，类似于突然断电
        t.stop();//已过时，不用了
    }
}
class MyRunnable03 implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}