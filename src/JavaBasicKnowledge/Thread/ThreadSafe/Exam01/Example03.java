package JavaBasicKnowledge.Thread.ThreadSafe.Exam01;
//面试题:doOther方法执行的时候需要等待doSome方法的执行吗？
    //不需要，因为MyClass有两个对象，是两把锁
public class Example03 {
    public static void main(String[] args) {
        MyClass03 mc01 = new MyClass03();
        MyClass03 mc02 = new MyClass03();
        Thread t1 = new MyClassThread03(mc01);
        Thread t2 = new MyClassThread03(mc02);

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
class MyClassThread03 extends Thread{
    private MyClass03 mc;

    public MyClassThread03() {
    }

    public MyClassThread03(MyClass03 mc) {
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
class MyClass03{
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
    public synchronized void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther Over");
    }
}