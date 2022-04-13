package JavaBasicKnowledge.CollectionMapBase.Collection.List;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试List接口中常用的方法：
 *      1.List集合存储元素的特点：有序可重复
 *              有序：List集合中的元素有下标，从0开始，以1递增
 *              可重复：存储“jack”之后，还可以存储“jack”
 *      2.List既然是Collection接口的子接口，那么肯定List接口有自己独有的方法：
 *          以下只列出其特有方法：
 *                   void add(int index, Object element)
 *
 *                   Object set(int index, Object element)
 *
 *                   Object get(int index)
 *
 *                   int indexOf(Object o)
 *
 *                   int lastIndexOf(Object o)
 *
 *                   Object remove(int index)
 *
 *
 *
 */

public class ListBase {
    public static void main(String[] args) {
        //创建集合对象
        List list = new LinkedList();

        //添加元素,
        // 以下没有index下标的元素，默认向集合末尾添加元素，当插入元素的时候，被插入位置之后没有下标的元素自动向后位移
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("king");
        //从列表的指定位置插入指定元素（第一个参数是下标）
        //这个方式使用不多，因为对于ArrayList集合来说效率比较低，因为涉及元素的后移。
        list.add(1,"king");//插入集合第二个位置
        /**
         * a-------0
         * king----1
         * b-------2
         * c-------3
         * d-------4
         */
        //迭代
        Iterator it = list.iterator();
        while (it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }
        //根据下标获取元素
        Object o =list.get(0);
        System.out.println(o);

        //思考：因为有下标，所以List集合有自己比较特殊的遍历方式
        //通过下标遍历
        for (int i = 0; i<list.size();i++){
            Object k = list.get(i);
            System.out.println(k);
        }

        //获取指定对象第一次出现处的索引
        System.out.println(list.indexOf("king"));//1
        //获取指定对象最后一次出现处的索引
        System.out.println(list.lastIndexOf("king"));

        //删除指定下标的元素
        list.remove(0);
        //删除指定元素
        list.remove("a");

        //修改指定位置元素
        list.set(2,"k");
        for (int i = 0; i<list.size();i++){
            Object k = list.get(i);
            System.out.println(k);
        }


    }
}
