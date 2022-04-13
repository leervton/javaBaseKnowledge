package JavaBasicKnowledge.CollectionMapBase.Collection.CollectionBaseKnowledge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Collection01 {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();
        //添加元素
        c.add("1");
        c.add(2);
        c.add(3);
        c.add(5);
        c.add(6);

        //迭代器集合
        Iterator it = c.iterator();

        while(it.hasNext()){
            //存进去是什么类型，取出来还是什么类型
            Object o = it.next();
            //检测：如果是Integer，输出是Integer
            if (o instanceof Integer){
                System.out.print("Integer类型：");
            }
            //在这里输出的时候转换成字符串，因为这里println会自动调用toString()方法
            System.out.println(o);
        }
        //HashSet集合：无序不可重复
        Collection c01 = new HashSet();
        //无序：是指存进去的数据和取出来的数据，在顺序上不同，完全被打乱了
        c01.add(10);
        c01.add(50);
        c01.add(10);
        c01.add(200);
        c01.add(300);
        //调用iterator方法return一个iterator对象
        Iterator it2 = c01.iterator();
        while (it2.hasNext()){
            Object o = it2.next();
            System.out.println(o);
            //优化代码：System.out.println(it2.next());
        }

    }
}
