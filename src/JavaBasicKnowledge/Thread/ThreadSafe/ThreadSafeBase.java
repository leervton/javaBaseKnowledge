package JavaBasicKnowledge.Thread.ThreadSafe;

/**
 * 1.关于多线程并发环境下，数据安全的问题
 *      为什么这个是重点？
 *              （********）
 *              以后在开发中，我们的项目都是运行在服务器当中的，
 *              而服务器已经将线程的定义，线程的创建，线程的启动等，
 *              都已经实现完了，这些代码我们都不需要编写
 *              最重要的是，你要知道你编写的程序需要放到一个多线程的环境下运行
 *                          你更需要关注的是这些数据在多线程并发的环境下是否安全
 *2.什么时候数据在多线程并发的环境下存在安全问题？
 *      三个条件：
 *          条件1：多线程并发
 *          条件2：有共享数据
 *          条件3：共享数据有修改的行为
 *      满足以上3个条件之后，就会存在线程安全问题
 * 3.怎么解决线程安全问题呢？
 *      当多线程并发的环境下，有共享数据，并且这个数据还会被修改，此时就存在线程安全问题，怎么解决这个问题呢？
 *              线程排队执行（不能并发）
 *              用排队执行解决线程安全问题
 *              这种机制被称为线程同步机制
 *              专业术语叫做：线程同步，实际上就是线程不能并发了，线程必须排队执行
 *
 *           怎么解决线程安全问题？
 *           使用‘线程同步机制’
 *           线程同步就是线程排队了，线程排队了就会牺牲一部分效率，没办法，数据安全第一位
 *           只有数据安全了才可以谈效率，数据不安全就不能谈效率
 * 4.说到线程同步这块，涉及到了这两个专业术语：
 *          可以这么认为：异步就是步调不一致，各自解决各自的
 *                       同步就是步调一致，都是处理同一个问题
 *          异步编程模型：
 *                  就是线程t1和线程t2，各自执行各自的，t1不管t2，t2不管t1，谁也不需要等谁
 *                  这种编程模型就是：异步编程模型
 *                  其实就是多线程并发(效率较高)
 *
 *          同步编程模型：
 *                  线程t1和线程t2，在线程t1执行的时候，必须等待线程t2执行结束
 *                  或者说，在线程t2执行的时候，必须等待线程t1执行结束
 *                  两个线程之间发生了等待关系，这就是同步编程模型
 *                  效率较低，线程排队执行
 */
public class ThreadSafeBase {
}