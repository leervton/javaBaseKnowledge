package JavaBasicKnowledge.Reflect._03_ReflectField_获取属性字段名;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 通过反射机制，反编译一个类的属性Field
 */
public class FieldReflect02 {
    public static void main(String[] args) throws Exception {
        //创建这个是为了拼接字符串
        StringBuilder sb = new StringBuilder();
        Class studentClass = Class.forName("JavaBasicKnowledge.Reflect.entity.Student");
        sb.append(Modifier.toString(studentClass.getModifiers())+ " class "+ studentClass.getSimpleName()+ "{\n" +
                "    public static void main(String[] args) throws Exception {\n");
        Field[] fields = studentClass.getDeclaredFields();
        for (Field f:fields){
            sb.append("\t\t");
            sb.append(Modifier.toString(f.getModifiers()));
            sb.append(" ");
            sb.append(f.getType().getSimpleName());
            sb.append(" ");
            sb.append(f.getName());
            sb.append(";\n");
        }
        sb.append("    }\n" +
                "}");
        System.out.println(sb);
    }
}
