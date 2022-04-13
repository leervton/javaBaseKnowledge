package JavaBasicKnowledge.Reflect._02_ReflectAdvance;

/**
 * 研究一下路径的事
 * 怎么获取一个文件的绝对路径，以下讲解的这种方式是通用的，但是前提是文件需要在类路径下，才能用这种方式
 */
public class AboutPath {
    public static void main(String[] args) {
        //这种方式的路径缺点是：移植性差，在IDEA中默认的当前路径是Project的根
        //这个代码假设离开了IDEA，换到了其他位置，可能当前路径就不是project的根了，这时这个路径就无效了
        //FileReader fr=new FileReader("JavaBasicKnowledge.Reflect.ReflectAdvance.MyClass");

        //接下来说一种比较通用的一种路径，即使代码换位置了，这样编写仍然是通用的
        //注意：使用以下通用方式的前提是：这个文件必须在类路径下
        //什么是类路径下？凡是在src下的都是类路径下
        //src是类的根路径
        /*
        Thread.currentThread()  当前线程对象
        getContextClassLoader() 是线程对象的方法，可以获取到当前线程的类加载器对象
        getResource("")        【获取资源】这是类加载器对象的方法，当前线程的类加载器默认从类的根路径下加载资源
         */
        String path = Thread.currentThread().getContextClassLoader().getResource("classinfo.properties").getPath();
        //采用以上代码可以拿到一个文件的绝对路径
        System.out.println(path);


        //获取introduction的绝对路径(必须从类的根路径下作为起点开始)
        //String path01 = Thread.currentThread().getContextClassLoader().getResource("NormalKnowledge.BitOperation.Introduction").getPath();//NullPointerException
        String path01 = Thread.currentThread().getContextClassLoader()
                        .getResource("classinfo01.properties").getPath();
        System.out.println(path01);

        String path02 = Thread.currentThread().getContextClassLoader()
                        .getResource("classinfo01.properties").getPath();
        System.out.println(path02);
    }
}
