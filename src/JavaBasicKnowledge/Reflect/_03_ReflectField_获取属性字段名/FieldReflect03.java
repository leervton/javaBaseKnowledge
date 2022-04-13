package JavaBasicKnowledge.Reflect._03_ReflectField_获取属性字段名;

import JavaBasicKnowledge.Reflect.entity.Student;

import java.lang.reflect.Field;

/**
 * 必须掌握：
 *      怎么通过反射机制访问一个java对象的属性呢？
 *              给属性赋值set
 *              获取属性的值get
 */
public class FieldReflect03 {
    public static void main(String[] args) throws Exception{
        //我们不使用反射机制，怎么去访问一个对象的属性呢？
        Student s = new Student();

        //给属性赋值
        s.no = 1111;//三要素：给s对象的no属性赋值1111
                    //要素1：对象s
                    //要素2：no属性
                    //要素3：1111

        //读属性值
        //获取s对象no属性的值
        System.out.println(s.no);

        //使用反射机制，怎么去访问一个对象的属性（set get）
        Class studentClass=Class.forName("JavaBasicKnowledge.Reflect.entity.Student");
        Object o = studentClass.newInstance();//o就是Student对象（底层调用其无参数构造方法）

        //获取no属性(属性和属性之间依靠名字区分)
        Field noField = studentClass.getDeclaredField("no");

        //给o对象（Student对象）的no属性赋值
        /*
        虽然使用了反射机制，但是三要素还是缺一不可
        //要素1：对象s
        //要素2：no属性
        //要素3：2222
        反射机制让代码复杂了，但是却让代码更灵活了
         */
        noField.set(o,2222);//给o对象（Student对象）的no属性赋值2222

        //读取属性的值
        //两个要素：获取o对象的no属性的值
        System.out.println(noField.get(o));

        //可以访问私有属性吗？
        //此时不能，报IllegalAccessException，所以提供方法是打破封装便可以
        Field nameField = studentClass.getDeclaredField("name");

        //打破封装(反射机制的缺点，打破封装可能会给不法分子留下机会)
        //这样设置完之后，在外部也是可以访问private的
        nameField.setAccessible(true);

        //给name属性赋值
        nameField.set(o,"liSi");
        //获取name属性的值
        System.out.println(nameField.get(o));
    }
}
