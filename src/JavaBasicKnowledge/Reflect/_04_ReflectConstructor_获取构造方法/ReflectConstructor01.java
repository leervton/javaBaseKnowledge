package JavaBasicKnowledge.Reflect._04_ReflectConstructor_获取构造方法;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 反编译一个类的constructor构造方法
 *
 */
public class ReflectConstructor01 {
    public static void main(String[] args) throws Exception {
        StringBuilder s = new StringBuilder();
        Class vipClass = Class.forName("JavaBasicKnowledge.Reflect._04_ReflectConstructor_获取构造方法.Vip");
        s.append(Modifier.toString(vipClass.getModifiers()));
        s.append(" class ");
        s.append(vipClass.getSimpleName());
        s.append("{\n");
        //拼接构造方法
        Constructor[] constructors = vipClass.getConstructors();
        for (Constructor con:constructors){
            s.append("\t");
            s.append(Modifier.toString(con.getModifiers()));
            s.append(" ");
            s.append(con.getName());
            s.append("(");
            //获得形参
            Class[] c = con.getParameterTypes();
            for (Class ck:c){
                s.append(ck.getSimpleName()+",");
            }
            //删除最后下标位置上的字符
            if (c.length>0){
                s.deleteCharAt(s.length()-1);
            }
            s.append("){}\n");
        }
        s.append("}");
        System.out.println(s);

    }
}
