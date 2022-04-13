package JavaBasicKnowledge.Reflect._01_ReflectBase;

/**
 * 要操作一个类的字节码，需要首先获取到这个类的字节码，怎么获取java.lang.Class实例？
 *      三种方式
 *          第一种：Class c = Class.forName();
 *          第二种：Class c = 对象.getClass();
 *          第三种：Class c = 任何类型.class;
 */
public class ReflectBase02 {
    public static void main(String[] args) {
        /*
            Class.forName()
                1.静态方法
                2.方法的参数是一个字符串
                3.字符串需要的是一个完整的类名
                4.完整的类名必须带有包名，java.lang包也不能省
         */
        Class c1=null;
        Class c2=null;
        Class c3=null;
        Class c4=null;
        try {
            c1= Class.forName("java.lang.String");//c1代表String.class文件，或者说c1代表String类型
            c2 = Class.forName("java.util.Date");//c2代表Date类型
            c3 = Class.forName("java.lang.Integer");//c3代表Integer类型
            c4 = Class.forName("java.lang.System");//c4代表System类型
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //java中任何一个对象都有一个方法：getClass()
        String s ="abc";
        Class x = s.getClass();//x代表String.class字节码文件，x代表String类型
        System.out.println(c1 == x);//true

        //java语言中任何一种类型，包括基本数据类型，它都有.class属性
        Class z =String.class;//z代表String类型
        Class a = Integer.class;//a代表Integer类型
        Class e = int.class;//e代表int类型
        Class k = double.class;//k代表double类型
        System.out.println(z=x);//true
    }
}
