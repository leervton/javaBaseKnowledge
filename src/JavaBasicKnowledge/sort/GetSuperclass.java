package JavaBasicKnowledge.sort;

/**
 * 获取父类代码测试
 */
public class GetSuperclass {
    public static void main(String[] args) {
        /**
         * --------------------------基本数据类型(没有父类，父类为null)---------------------
         */
        System.out.println(byte.class.getSuperclass());//1
        System.out.println(short.class.getSuperclass());//2
        System.out.println(int.class.getSuperclass());//4
        System.out.println(long.class.getSuperclass());//8
        System.out.println(float.class.getSuperclass());//4
        System.out.println(double.class.getSuperclass());//8
        System.out.println(boolean.class.getSuperclass());//1
        System.out.println(char.class.getSuperclass());//2

        /**
         * 方法：Arrays.asList( Object[ ]  obj) ;
         * 这个方法，是将数据转换成为List。如果我们传的参数是基本数据类型的数组，那么Arrays会调用 asList(T ... a) 这个方法执行
         * 也就是说，将这个数组本身当作一个参数传入。那么这个方法得到的结果就是这个数组作为转换的集合中的元素了。
         */

        /**
         * -------------------------------引用数据类型------------------------------
         */
        System.out.println(String.class.getSuperclass().getName());
        System.out.println((new int[2]).getClass().getSuperclass().getName());
        /**
         * --------------------------------基本数据类型的包装类-------------------
         */
        System.out.println(Integer.class.getSuperclass().getName());
        //基本数据类型的包装类的父类是 java.lang.Number

        System.out.println(Integer.class.getSuperclass().getSuperclass().getName());
        //Number 的父类是Object,那么我们也可以说，Object 也是基本数据类型的包装类的父类 。
    }
}
