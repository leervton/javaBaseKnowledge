package JavaBasicKnowledge.Thread.ThreadAdvance.Thread01;


/**
 * 大家分析以下程序，有几个线程
 *      除垃圾回收线程之外有几个线程？
 *      只有一个主线程，主栈
 *      没有启动分支栈，没有启动分支线程
 *      所以这个只有一个主线程
 *      main begin
 *      m1 begin
 *      m2 begin
 *      m3 execute
 *      m2 over
 *      m1 over
 *      main over
 *          一个栈中，自上而下的顺序依次逐行执行
 *
 */
public class Thread01 {
    public static void main(String[] args) {
        System.out.println("main begin");
        m1();
        System.out.println("main over");
    }

    private static void m1() {
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 over");
    }

    private static void m2() {
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 over");
    }

    private static void m3() {
        System.out.println("m3 execute");
    }
}
