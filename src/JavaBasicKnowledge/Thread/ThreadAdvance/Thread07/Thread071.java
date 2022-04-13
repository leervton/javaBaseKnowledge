package JavaBasicKnowledge.Thread.ThreadAdvance.Thread07;

/**
 * 怎么合理的去终止一个线程的执行，这种方式是很常用的
 */
public class Thread071 {
    public static void main(String[] args) {
        MyRunnable04 r = new MyRunnable04();
        Thread t = new Thread(r);
        t.setName("t");
        t.start();

        //模拟五秒
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //终止线程
        //你想什么时候终止t线程的执行，只需要把打的标记改成false即可
        r.run = false;
    }
}
class MyRunnable04 implements Runnable{
    //打个布尔标记
    boolean run=true;

    @Override
    public void run() {
        if (run) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "----->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            //return就结束了，你在结束之前有什么没保存的
            //在这里可以保存
            //save。。。。。。。

            //终止当前线程
            return;
        }
    }
}