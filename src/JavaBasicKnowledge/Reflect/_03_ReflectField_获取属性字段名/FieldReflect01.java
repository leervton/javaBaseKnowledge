package JavaBasicKnowledge.Reflect._03_ReflectField_获取属性字段名;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 反射student类当中的所有Field
 */
public class FieldReflect01 {
    public static void main(String[] args) {
        //获取整个类
        //Class StudentClass = new Student().getClass();
        Class StudentClass = null;
        try {
            StudentClass = Class.forName("JavaBasicKnowledge.Reflect.entity.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //获取类的名字
        String className = StudentClass.getName();
        System.out.println("完整类名"+className);

        String simpleName = StudentClass.getSimpleName();
        System.out.println("简类名"+simpleName);

        //获取类中所有的public修饰的Field
        Field[] fields = StudentClass.getFields();
        System.out.println(fields.length);//测试得知数组长度只有1

        //取出这个Field
        Field f = fields[0];
        //取出这个field的名字
        String fieldName = f.getName();
        System.out.println(fieldName);

        //获取所有的Field
        Field[] fields1 = StudentClass.getDeclaredFields();
        System.out.println(fields1.length);//4

        System.out.println("==========================");
        //遍历
        for (Field fe:fields1){
            //获取属性的修饰符列表.修饰符有可能有多个，返回值是int类型，表示的是修饰符的代号
            int i = fe.getModifiers();
            //将修饰符代号转换成字符串
            String modifierString = Modifier.toString(i);
            System.out.println(modifierString);

            //获取属性的名字
            System.out.println(fe.getName());

            //获取属性的类型
            Class fieldType = fe.getType();
            //String fName = fieldType.getName();
            String fName = fieldType.getSimpleName();
            System.out.println(fName);
        }

    }
}
