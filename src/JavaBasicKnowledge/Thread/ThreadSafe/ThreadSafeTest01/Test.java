package JavaBasicKnowledge.Thread.ThreadSafe.ThreadSafeTest01;

public class Test {
    public static void main(String[] args) {
        //创建账户对象（只创建一个）
        Account act = new Account("act-01",10000);
        //创建两个线程
        Thread t1 = new AccountThread(act);
        Thread t2 = new AccountThread(act);

        Account act01 = new Account("act-01",10000);
        Thread t3 = new AccountThread(act01);

        //设置name
        t1.setName("t1");
        t2.setName("t2");
        //启动线程取款
        t1.start();
        t2.start();
    }
}
