package JavaBasicKnowledge.CollectionMapBase.Collection.CollectionBaseKnowledge.ContainsMethod;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 深入Collection集合的contains方法
 *      boolean contains(Object o);
 *      判断集合中是否包含某个对象o
 *      如果包含返回true
 *      如果不包含返回false
 *
 * contains方法是用来判断集合中是否包含某个元素的方法
 * 那么它在底层是怎么判断集合中是否包含某个元素的呢？
 *          调用了equals方法进行比对
 *          equals返回true，就表示包含这个元素
 */
public class Contains {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();
        //添加元素
        /**
         * 字符串在加载的时候会随着加载存在一个常量池里面，
         * new出来的堆内存（new String("abc")）存储的是字符串在常量池中的地址
         * 而堆内存自己的地址被赋值给了栈内存s1
         */
        String s1 = new String("abc");
        c.add(s1);

        String s2 = new String("def");
        c.add(s2);

        //查看集合中元素的个数
        System.out.println(c.size());

        //新建的对象
        String x = new String("abc");
        //判断c集合是否包含x？结果猜测一下
        //查看底层代码发现，用equals方法比较内容，
        /**
         * 字符串在加载的时候会随着加载存在一个常量池里面，而new出来的堆内存存储的是一个内存引用地址指向常量池的字符串
         */
        System.out.println(c.contains(x));//false

    }
}
