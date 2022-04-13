package JavaBasicKnowledge.Thread.TreadOtherContent;

/**
 * java语言中线程分为两个个大类：
 *  1.用户线程
 *  2.守护线程（后台线程）
 *  其中具有代表性的就是：垃圾回收线程（守护线程）
 *  守护线程的特点：
 *      一般守护线程是一个死循环，所有的用户线程只要结束
 *      守护线程自动结束
 *
 *    注意：主线程main方法是一个用户线程
 *    守护线程用在什么方法？
 *      每天00：00的时候系统数据自动备份
 *      这个时候需要使用到定时器，并且我们可以将定时器设置为守护线程
 *      一直在那看着，每到00：00的时候就备份一次，所有的用户线程结束了
 *      守护线程自动退出
 *
 */
public class ThreadDefend {
    public static void main(String[] args) {
        Thread t = new BakDataThread();
        t.setName("数据备份线程");

        //启动线程之前，将线程设置成守护线程
        t.setDaemon(true);

        t.start();

        //主线程是用户线程
        for (int i= 0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"---------->"+(i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class BakDataThread extends Thread{
    @Override
    public void run() {
        int i = 0;
        //即使是死循环，但由于该线程是守护者，当用户线程结束，守护线程自动终止
        while(true){
            System.out.println(Thread.currentThread().getName()+"---------->"+(++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}