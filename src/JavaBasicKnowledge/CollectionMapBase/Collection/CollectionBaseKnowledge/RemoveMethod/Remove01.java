package JavaBasicKnowledge.CollectionMapBase.Collection.CollectionBaseKnowledge.RemoveMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 关于集合的Remove方法
 */
public class Remove01 {
    public static void main(String[] args) {
        //创建集合
        Collection c = new ArrayList();

        //添加元素
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        //获取迭代器
        Iterator it = c.iterator();
        while (it.hasNext()){
            //编写代码时next()方法返回值类型必须是Object
            //Integer i = c.next();该行代码报错

            Object o = it.next();
            System.out.println(0);
        }
    }
}
