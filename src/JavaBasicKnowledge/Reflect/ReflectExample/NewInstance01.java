package JavaBasicKnowledge.Reflect.ReflectExample;

/**
 * 获取到class能干什么？
 *      通过Class的newInstance()方法来实例化对象
 *      注意：newInstance()方法内部实际上调用了无参构造方法，必须保证无参构造存在才可以
 *      反射机制更加灵活，灵活在哪？
 *
 */
public class NewInstance01 {
    public static void main(String[] args) {
        //这是不使用反射机制，创建对象
        User u = new User();
        System.out.println(u);

        //这是以反射机制的方式创建对象
        try {
            //通过反射机制，获取Class，通过Class来实例化对象
            Class c = Class.forName("JavaBasicKnowledge.Reflect.ReflectExample.User");

            //newInstance()这个方法会调用User这个类的无参数构造方法，完成对象的创建
            //重点是：newInstance()调用的是无参构造，必须保证无参构造是存在的
            Object o  = c.newInstance();

            System.out.println(o);//JavaBasicKnowledge.Reflect.ReflectExample.User@10f87f48
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
