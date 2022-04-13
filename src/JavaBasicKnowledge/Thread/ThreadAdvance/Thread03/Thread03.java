package JavaBasicKnowledge.Thread.ThreadAdvance.Thread03;

/**
 * 匿名内部类
 */
public class Thread03 {
    public static void main(String[] args) {
        //创建线程对象，采用匿名内部类方式
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;i++){
                    System.out.println("分支线程-----》"+i);
                }
            }
        });

        //启动线程
        t.start();

        for (int i=0;i<1000;i++){
            System.out.println("分支线程-----》"+i);
        }
    }
}
