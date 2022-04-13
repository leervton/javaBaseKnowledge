package JavaBasicKnowledge.CollectionMapBase.Collection.List;

import java.util.*;

/**
 * Vector：
 *          1.底层也是一个数组
 *          2.初始化容量：10
 *          3.如何扩容？
 *              扩容容量是原容量的2倍
 *          4.ArrayList集合扩容特点：
 *              扩容容量是原来的1.5倍
 *          5.Vector中所有方法都是线程同步的，都带有Synchronized关键字
 *            是线程安全的，效率比较低，使用比较少
 *          6.怎么将一个线程不安全的ArrayList集合转换成线程安全的呢？
 *              使用集合工具类：
 *                      java.util.Collections;
 *              注意：
 *                  java.util.Collection;是集合接口
 *                  java.util.Collections;是集合工具类
 *
 *
 *
 *
 *
 */
public class Vector01 {
    public static void main(String[] args) {

        Vector vector = new Vector();
        //默认初始化容量是10
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);
        vector.add(7);
        vector.add(8);
        vector.add(9);
        vector.add(10);

        //满足了之后扩容，扩容容量是原容量的2倍
        vector.add(11);

        //调动迭代器，遍历数据
        Iterator it = vector.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //非安全线程转换成线程安全
        //非安全线程集合
        List list = new ArrayList();

        //调用Collections集合工具类中的synchronizedList()方法，
        // 把集合传进去就变成线程安全的
        Collections.synchronizedList(list);

        list.add("111");
        list.add("sss");
        list.add("dd");
        list.add("ra");
    }
}
