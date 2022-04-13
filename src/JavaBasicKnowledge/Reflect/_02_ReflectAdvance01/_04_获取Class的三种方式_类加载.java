package JavaBasicKnowledge.Reflect._02_ReflectAdvance01;

public class _04_获取Class的三种方式_类加载 {
    public static void main(String[] args) throws Exception {
        //注意：类加载并不是创建

        //获取第一种方式
        //本质上说:c1引用指向的是方法区中类的字节码文件(方法区中最先有数据，在类加载时有数据)
        //c1代表的是String.class字节码文件
        //该方式必须填写类的全名，譬如此处：java.lang不能省略
        Class c1 = Class.forName("java.lang.String");

        //第二种方式
        Class c2 = String.class;
        //输出true，表示String.class字节码文件在方法区只有一份
        System.out.println(c1==c2);

        //第三种方式
        Class c3 = "abc".getClass();
        //其中该方法是成员方法，需要new对象，而"abc"就是一个实例对象
        System.out.println(c1==c3);

        //c1,c2,c3都代表java.lang.String.class字节码文件，也代表String类型
    }
}
