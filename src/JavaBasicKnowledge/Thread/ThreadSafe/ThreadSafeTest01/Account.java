package JavaBasicKnowledge.Thread.ThreadSafe.ThreadSafeTest01;

/**
 * 银行账户
 *      使用线程同步机制，解决线程安全问题。
 *
 */
public class Account {
    //账号
    private String actNo;
    //余额
    private double balance;

    Object o = new Object();

    public Account() {
    }

    public Account(String actNo, double balance) {
        this.actNo = actNo;
        this.balance = balance;
    }

    public String getActNo() {
        return actNo;
    }

    public void setActNo(String actNo) {
        this.actNo = actNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public void withDraw(double money){
        //以下几行代码必须是线程排队的，不能是线程并发
        //一个线程把这里的代码全部执行结束之后，另一个线程才能进来
        /*
        线程同步机制的语法是什么？
                 synchronized (){
                    //线程同步代码块
                 }
         synchronized(){}后面的小括号的传的数据是相当关键的，
         这个数据必须是多线程共享的数据，才能达到多线程排队

         ()中写什么？
            那要看你想让哪些线程同步
                假设t1，t2，t3，t4，t5有5个线程
                你只希望t1，t2，t3排队，t4，t5不需要排队，怎么办？
                你一定要在()中写一个t1，t2，t3共享的对象，
                而这个对象对于t4，t5来说不是共享的

                这里的共享对象是：账户对象
                账户对象是共享，那么this就是账户对象吧
                不一定是this,这里只要是多线程共享的那个对象就行

                在java语言中，任何一个对象都有一把“锁”，其实这把锁就是标记。（只是把它叫做锁）
                100个对象100把锁，一个对象一把锁

                以下代码的执行原理是什么？
                    1.假设t1和t2线程并发，开始执行以下代码的时候，肯定有一个先有一个后
                    2.假设t1先执行，遇到了synchronized，这个时候自动寻找“后面共享对象”的对象锁
                      找到之后，并占有这把锁，然后执行同步代码块中的程序，在程序执行的过程中一直都是占有这把锁的
                      直到同步代码块代码执行结束，这把锁才会释放
                    3.假设t1已经占有这把锁，此时t2也遇到了synchronized关键字，也会去占有后面共享对象的这把锁，结果这把锁
                      已经被t1占有了，t2只能在同步代码块外面等待t1的结束，直到t1把同步代码块执行结束了，t1会归还这把锁，此时t2
                      终于等到这把锁，，然后t2占有这把锁之后，进入同步代码块执行

                      这样就达到了线程排队执行
                      这里需要注意的是这个共享对象一定要选好，这个共享对象一定是你需要排队执行的这些线程所共享的
                        =======================实现方法===================================
                      线程在运行状态下遇见synchronized关键字时，会进入对象的锁池寻找共享对象的对象锁，
                      在进入锁池中寻找共享对象的对象锁的时候，会释放之前占有的cpu时间片，有可能找到了
                      也有可能没找到，没找到则在锁池中等待，如果找到了便会进入就绪状态继续抢夺cpu时间片

         */
        //t1和t2共享Account对象，所以可以用this
        //t1和t2共享Object对象o，所以也可以用o
        //所以这里只要放一个几个线程的共享对象就行了，这个共享对象只是起到一个标记作用
        synchronized(this){
        //synchronized(o){
        //synchronized("abc"){//这个可以，因为"abc"在字符串常量池中，即所有线程都会因为共享字符串常量池而同步，无法作出区别
        //Object o1 = new Object();
        //synchronized(o1){//这种就不行了，因为o1是局部变量，两个线程执行该方法都会new出o1对象，所以两个线程不共享对象
            double before =this.getBalance();
            double after = before - money;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.setBalance(after);
        }
    }
}
