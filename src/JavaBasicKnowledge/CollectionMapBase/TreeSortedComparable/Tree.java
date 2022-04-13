package JavaBasicKnowledge.CollectionMapBase.TreeSortedComparable;

import java.util.TreeSet;

/**
 * 1.TreeSet集合底层实际上是一个TreeMap
 * 2.TreeMap集合底层是一个二叉树
 * 3.放到TreeSet集合中的元素，等同于放到TreeMap集合key部分了
 * 4.TreeSet集合中的元素：无序不可重复，但是可以按照元素的大小顺序自动排序，称之为可排序集合
 */
public class Tree {
    public static void main(String[] args) {
        //创建一个TreeSet集合
        TreeSet<String> t = new TreeSet<>();
        //添加String
        t.add("张三");
        t.add("李四");
        t.add("王五");
        t.add("赵六");
        t.add("刘七");
        t.add("陆八");
        //排序
        for (String s:t){
            System.out.println(s);
        }


    }
}
/**
 * 数据库中有很多数据：
 *      UserID      Name        Birth
 * --------------------------------------------
 *      1           张三          1980-11-11
 *      2           李四          1980-10-11
 *      3           王五          1981-11-11
 *      4           赵六          1979-11-11
 *
 *      编写程序从数据库当中提取数据，在页面展示用户信息的时候按照生日升序或者降序
 *      这个时候可以使用TreeSet集合，因为TreeSet集合放进去，拿出来就是有顺序的
 */
