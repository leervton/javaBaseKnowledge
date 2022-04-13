package JavaBasicKnowledge.Thread.ThreadAdvance.Thread06;

/**
 * sleep()睡眠太久了，如果希望半道上醒来，你应该怎么办？也就是说怎么唤醒一个正在休眠的线程
 * 这个不是中断线程的执行，是中止线程的睡眠
 */
public class Thread062 {
    public static void main(String[] args) {
        //手中的活干完了，想唤醒线程
        Thread t = new Thread(new MyRunnable01());
        t.setName("t");
        //启动线程，线程进入休眠状态
        t.start();

        //希望5秒之后，t线程醒来，这里线程计时5秒之后手里的活就干完了
        try {
            t.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //中断t线程的睡眠，这种中断睡眠的方式依靠了java的异常处理机制
        t.interrupt();//干扰，一盆冷水过去！然后让MyRunnable的run方法里的Thread.sleep()方法（39行代码）直接出现异常
                      //然后进入catch语句块，从而使tr....catch结束。

    }
}
class MyRunnable01 implements Runnable{
    /**
     * 从父类继承的run()方法中的异常只能try...catch，不能抛出异常的原因：
     * 因为run()方法是从父类继承过来的方法，该方法在父类中没有抛出任何异常子类重写不能抛出比父类更多更宽泛的异常
     * 实现接口也是一种继承
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---------->begin");
        try {
            //睡眠1年
            Thread.sleep(1000*3600*24*365);
        } catch (InterruptedException e) {
            //打印异常信息
            //e.printStackTrace();
        }
        //1年之后才会执行到这里
        System.out.println(Thread.currentThread().getName()+"---------->end");

        /*
        try {
            doSome();
        } catch (Exception e) {
            e.printStackTrace();
        }
         */
    }
    //该方法不是从父类继承的方法，所以可以随意
    /*public void doSome() throws Exception{

    }*/
}