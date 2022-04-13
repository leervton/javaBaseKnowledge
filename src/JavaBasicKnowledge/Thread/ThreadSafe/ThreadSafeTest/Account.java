package JavaBasicKnowledge.Thread.ThreadSafe.ThreadSafeTest;

/**
 * 银行账户
 *      不使用线程同步机制，多线程对同一个账户进行取款，出现线程安全问题
 */
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

    //取款方法,这里的this可写可不写，系统会默认补上
    //t1和t2线程并发这个方法（t1和t2是两个栈，但是堆内存是共享的，所以两个栈操作堆中的同一个对象）
    public void withDraw(double money){
        //取款之前的余额是多少
        double before =this.getBalance();
        //取款之后的余额是多少
        double after = before - money;

        //在这里模拟一下网络延迟，100%会出问题
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //更新余额
        //思考：t1执行到这里，但是还没来得及执行这行代码，t2线程进来withDraw方法获取账户余额了，此时一定出现问题
            //即你在银行甲取钱，取完钱之后，银行没来得及更新余额。你妻子在银行乙取钱，银行获取账户余额，这时候的余额却是没取钱之前的余额
        //当然也有可能不出现问题
        this.setBalance(after);
    }
}
