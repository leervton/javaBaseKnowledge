package JavaBasicKnowledge.Thread.ThreadSafe.Exam01;
//面试题:doOther方法执行的时候需要等待doSome方法的执行吗？
    //需要，因为静态方法是类锁，不管创建了几个对象，类锁只有1把
public class Example04 {
    public static void main(String[] args) {
        MyClass04 mc = new MyClass04();
        MyClass04 mc02 = new MyClass04();
        Thread t1 = new MyClassThread04(mc);
        Thread t2 = new MyClassThread04(mc02);

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
class MyClassThread04 extends Thread{
    private MyClass04 mc;

    public MyClassThread04() {
    }

    public MyClassThread04(MyClass04 mc) {
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
class MyClass04{
    //synchronized出现在实例方法上，表示锁this
    public synchronized static void doSome(){
        System.out.println("doSome Begin");
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("doSome Over");
    }
    public synchronized static void doOther(){
        System.out.println("doOther begin");
        System.out.println("doOther Over");
    }
}