package JavaBasicKnowledge.Thread.ThreadSafe.ThreadSafeTest03;

/**
 * 我们以后开发中应该怎么解决线程安全问题？
 * 是一上来就选择线程同步吗？synchronized
 *      不是，synchronized会让程序的执行效率降低，用户体验不好，
 *      系统的用户吞吐量/并发量降低，用户体验差，在不得已的情况下，再选择线程同步机制
 *
 *      第一种方案：尽量使用局部变量代替“实例变量和静态变量”
 *      第二种方案：如果必须是实例变量，那么可以考虑创建多个对象，这样实例变量的内存就不共享了
 *                （一个线程对应一个对象，100个线程对应100个对象，对象不共享，就没有数据安全问题了）
 *      第三种方案：如果不能使用局部变量，对象也不能创建多个，这个时候就只能使用synchronized了，线程同步机制
 */
public class ThreadSafeConclusion {
}
