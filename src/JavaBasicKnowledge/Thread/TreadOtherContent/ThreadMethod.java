package JavaBasicKnowledge.Thread.TreadOtherContent;

/**
 * 关于Object类中的wait和notify方法（生产者和消费者模式）
 *      第一，wait和notify方法不是线程对象的方法，是java中任何一个java对象
 *           都有的方法，因为这两个方法是Object类中自带的
 *              wait方法和notify方法不是通过线程对象调用
 *              不是这样的：t.wait(),也不是这样的：t.notify()
 *      第二：wait()作用
 *          Object o = new Object();
 *          o.wait();
 *          表示：
 *              让正在o对象上活动的线程进入等待状态，而且是无限期等待
 *              直到被唤醒为止
 *              o.wait(正在o对象上活动的线程);会让当前线程进入等待状态
 *      第三：notify()作用
 *          o.notify()可以让正在o对象上等待的线程被唤醒
 *          Object o = new Object();
 *          o.notify();
 *
 *          表示：
 *              唤醒正在o对象上等待的线程
 *
 *              还有一个notifyAll()方法：
 *                  这个方法是唤醒o对象上处于等待的所有线程
 */
public class ThreadMethod {
}
