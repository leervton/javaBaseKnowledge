package JavaBasicKnowledge.Reflect.ReflectExample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 验证反射机制的灵活性
 *      java代码写一遍，在不该改变java源代码的基础上，可以做到不同对象的实例化
 *      非常之灵活（符合OCP开闭原则：对拓展开放，对修改关闭）
 *
 *后期要学习的是高级框架，而工作过程中，也都是使用高级框架
 * 包括：ssh，ssm
 *      Spring，SpringMVC，myBatis
 *      Spring Struts Hibernate
 *      。。。。。。。。。
 *      这些高级框架底层的实现原理：都采用了反射机制，所以反射机制还是非常重要的，
 *      学会了反射机制有利于理解剖析框架底层的源代码
 *
 *      批量修改就使用数组
 */
public class NewInstance02 {
    public static void main(String[] args) {
        //这种代码就写死了，只能创建一个User对象
        //User user = new User();

        //==============以下代码是灵活的，代码不需要改动，只需要修改配置文件==========
        //通过IO流读取classinfo.properties文件
        FileReader fr=null;
        try {
            fr = new FileReader("JAVASE_Java\\src\\classinfo.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //创建属性类对象Map
        Properties pro = new Properties();//key和value都是String类型的
        //加载
        try {
            pro.load(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //通过key获取value
        String className = pro.getProperty("className");
        System.out.println(className);

        //通过配置文件内容借用反射机制实例化对象
        Class c = null;
        try {
            c = Class.forName(className);
            Object o = c.newInstance();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
