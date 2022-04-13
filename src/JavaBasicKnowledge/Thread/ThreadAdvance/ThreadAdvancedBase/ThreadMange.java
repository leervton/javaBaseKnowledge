package JavaBasicKnowledge.Thread.ThreadAdvance.ThreadAdvancedBase;

/**
 * 1.常见的线程调度模型有哪些？
 *      抢占式调度模型
 *          哪个线程的优先级比较高，抢到的cpu时间片的概率就高一些/多一些
 *          java采用的就是抢占式调度模型
 *      均分式调度模型
 *          平均分配cpu时间片，每个线程占有的时间片时间长度一样，平均分配
 *          一切平等
 * 2.java中提供了哪些方法是和线程调度有关的
 *
 *      //这是实例方法，设置线程优先级
 *      void setPriority(int newPriority)
 *
 *      //获取线程优先级
 *       int getPriority()
 *      最低优先级是1
 *      默认优先级是5
 *      最高优先级是10
 *      优先级比较高的获取cpu时间片的可能性会多一些（但也不完全是，大概率是高的）
 *      这里的时间片多一些是指线程处于运行状态的时间多一些
 *      而不是抢夺线程的执行权的概率大一些
 *
 *      //这是一个静态方法，让位方法
 *      static void yield()
 *       暂停当前正在执行的线程对象，并执行其他线程。
 *       该方法不是阻塞方法，让当前线程让位，让给其他线程使用
 *       该方法的执行，会使当前线程从运行状态回到就绪状态，
 *       但当前线程回到就绪状态后，仍然可能会抢到时间片，虽然抢夺的概率是很低的
 *       该方法只是减弱线程的抢夺能力
 *
 *       //实例方法：
 *          void join()
 *          合并线程
 *          class MyThread01 extends Thread{
 *              public void doSome(){
 *                  MyThread02 t = new MyThread02();
 *                  t.join();//当前线程进入阻塞状态，t线程执行，直到t线程结束，当前线程才允许被执行
 *              }
 *          }
 *           class MyThread02 extends Thread{
 *              public void doSome(){
 *
 *              }
 *          }
 */
public class ThreadMange {
}
