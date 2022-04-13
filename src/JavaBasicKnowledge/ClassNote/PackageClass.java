package JavaBasicKnowledge.ClassNote;

/**
 * https://www.cnblogs.com/huashanlin/archive/2007/05/16/749359.html
 * 8种基本数据类型所对应的包装类型名称是什么？
 * byte                          java.lang.Byte
 * int                           java.lang.Integer
 * short                         java.lang.Short
 * long                          java.lang.Long
 * float                         java.lang.Float
 * double                        java.lang.Double
 * boolean                       java.lang.Boolean
 * char                          java.lang.Character
 *------------------------------------------------------
 * 以上八种基本数据类型的包装类父类都是number，但是number的父类又是object
 * ------------------------拆箱方法----------------------------
 *  byte byteValue()
 *           以 byte 形式返回指定的数值。
 * abstract  double doubleValue()
 *           以 double 形式返回指定的数值。
 * abstract  float floatValue()
 *           以 float 形式返回指定的数值。
 * abstract  int intValue()
 *           以 int 形式返回指定的数值。
 * abstract  long longValue()
 *           以 long 形式返回指定的数值。
 *  short shortValue()
 *           以 short 形式返回指定的数值。
 */
public class PackageClass {
    public static void main(String[] args) {
        //123这个基本数据类型，进行构造方法的包装达到了：基本数据类型向引用数据类型的转换
        //基本数据类型-----》引用数据类型（装箱）
        Integer i = new Integer(123);

        //引用数据类型-----》基本数据类型（拆箱）
        float l = i.floatValue();
        float k = (float)i;//强转,向下转型
        System.out.println(l+":"+ k + "=" + (l+k));
        /**
         * ----------------------------------------------------
         * 在jdk1.5之后，支持自动拆箱和自动装箱
         */
        //自动装箱
       Integer x = 100;

        //自动拆箱
        int y = x;

        //为什么x是引用数据类型，而100是基本数据类型，x+1却没报错？
        //因为x是包装类，不属于基本数据类型，这里会进行自动拆箱机制，将x转换成基本数据类型
        System.out.println(x+1);
    }
}
