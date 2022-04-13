package JavaBasicKnowledge.Thread.ThreadSafe.Exam01;
//面试题:doOther方法执行的时候需要等待doSome方法的执行吗？
        /*
            不需要，因为doOther方法上没有synchronized，不需要对象锁，不用排队
         */
public class Example01 {
    public static void main(String[] args) {
        MyClass mc = new MyClass();

        Thread t1 = new MyClassThread(mc);
        Thread t2 = new MyClassThread(mc);

        t1.setName("t1");
        t2.setName("t2");

        t1.start();
        try {
            Thread.sleep(1000);//这个睡眠的作用是保证t1线程先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
class MyClassThread extends Thread{
    private MyClass mc;

    public MyClassThread() {
    }

    public MyClassThread(MyClass mc) {
        this.mc = mc;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t1")){
            mc.doSome();
        }
        if (Thread.currentThread().getName().equals("t2")){
            mc.doOther();
        }
    }
}
class MyClass{
    //synchronized出现在实例方法上，表示锁this
    public synchronized void doSome(){
        System.out.println("doSome Begin");
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome Over");
    }
    public void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther Over");
    }
}