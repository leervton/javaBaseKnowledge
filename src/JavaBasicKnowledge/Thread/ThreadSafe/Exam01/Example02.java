package JavaBasicKnowledge.Thread.ThreadSafe.Exam01;
//面试题:doOther方法执行的时候需要等待doSome方法的执行吗？
    /*
        不需要，因为doOther方法上没有synchronized，不需要对象锁，不用排队
     */
public class Example02 {
    public static void main(String[] args) {
        MyClass01 mck = new MyClass01();
        Thread t01 = new MyClassThread01();
        Thread t02 = new MyClassThread01(mck);

        t01.setName("t01");
        t02.setName("t02");

        t01.start();
        try {
            Thread.sleep(1000);//这个睡眠的作用是保证t1线程先执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t02.start();
    }
}
class MyClassThread01 extends Thread{
    private MyClass01 mc;

    public MyClassThread01() {
    }

    public MyClassThread01(MyClass01 mc) {
        this.mc = mc;
    }

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("t01")){
            mc.doSome();
        }
        if (Thread.currentThread().getName().equals("t02")){
            mc.doOther();
        }
    }
}
class MyClass01{
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