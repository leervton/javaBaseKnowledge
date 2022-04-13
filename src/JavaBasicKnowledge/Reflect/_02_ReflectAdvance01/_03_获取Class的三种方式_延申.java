package JavaBasicKnowledge.Reflect._02_ReflectAdvance01;
/**
 * Class.forName("完整的类名");
 *      如果只是单纯的想使用类加载机制，则可以不返回任何值
 * Class c = Class.forName("完整的类名");
 *      如果希望操作这个类中的其他字节码，例如方法，构造函数，字段，可以返回值
 * */
public class _03_获取Class的三种方式_延申 {
    public static void main(String[] args) throws Exception {
        //这就是为了使用类加载功能而不返回值
        Class.forName("JavaBasicKnowledge.Reflect._02_ReflectAdvance01.T");
        //这就是为了更加容易操作T1类中的方法，字段，构造函数，所以必须接受返回值
        Class c = Class.forName("JavaBasicKnowledge.Reflect._02_ReflectAdvance01.T1");
    }
}

class T{
    //静态代码块，在类的加载时加载
    static {
        System.out.println("static......");
    }
}

class T1{
    private String name;

    public T1() {
    }

    public void setName(String name) {
        this.name = name;
    }
}