package JavaBasicKnowledge.CollectionMapBase.Collection.CollectionBaseKnowledge.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 重点：当集合的结构（内部数据被增删改之后）发生了改变时，迭代器必须重新获取，如果还是用以前老的迭代器，
 *      会出现异常：java.util.ConcurrentModificationException
 */
public class IteratorBase01 {
    public static void main(String[] args) {
        //创建集合
        Collection c01 = new ArrayList();
        //获取迭代器
        /**
         * 注意：此时获取的迭代器，指向的是此时集合状态下的迭代器（即集合中没有元素的迭代器）
         *      一定要注意，集合结构发生改变，迭代器必须重新获取
         *      当集合结构发生了改变，迭代器没有重新获取，调用next()方法时：java.util.ConcurrentModificationException
         */
        Iterator it = c01.iterator();
        //添加元素
        c01.add(1);
        c01.add(2);
        c01.add(3);
        c01.add(4);

        while (it.hasNext()){
            //编写代码时next()方法返回值类型必须是Object
            //Integer i = c.next();该行代码报错

            Object o = it.next();
            System.out.println(0);
        }
    }
}
