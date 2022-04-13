package JavaBasicKnowledge.Thread.ThreadAdvance.Thread06;

/**
 * 关于Thread.sleep();的一道面试题
 */
public class Thread061 {
    public static void main(String[] args) {
        //创建线程对象
        Thread myThread03 = new MyThread03();
        myThread03.setName("t");
        myThread03.start();

        //调用sleep()方法
        try {
            //这行代码会让线程myThread03进入休眠状态吗？
            //不会，因为静态方法属于类的，即使myThread03.sleep(1000*5);这样写，最后都会修改成Thread.sleep(1000*5);
            //Thread.sleep(1000*5);这行代码是让当前线程进入休眠，即main方法会进入休眠
            myThread03.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyThread03 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i<10000;i++){
            System.out.println(Thread.currentThread().getName()+"---->"+i);
        }
    }
}