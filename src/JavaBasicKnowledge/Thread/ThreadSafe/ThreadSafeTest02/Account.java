package JavaBasicKnowledge.Thread.ThreadSafe.ThreadSafeTest02;

public class Account {
    //账号
    private String actNo;
    //余额
    private double balance;

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
    //取款方法

    /**
     * 在实例方法上可以使用synchronized码？可以的，而且一定锁的是this
     * 所以这种方式不灵活，而且整个方法体都会同步，可能会无故扩大同步范围
     * ，导致程序执行效率降低，所以这种方式不常用
     *
     * synchronized使用在实例方法上有什么用处？
     *      代码写的少了，洁简了
     * 如果共享对象就是this，并且需要同步的代码块是整个方法体
     * 建议使用这种方法
     * @param money
     */
    public synchronized void withDraw(double money){

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
