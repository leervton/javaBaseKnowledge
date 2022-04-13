package JavaBasicKnowledge.CollectionMapBase.Collection.Set;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet集合存储元素的特点：
 *      1.无序不可重复(这里的无序是指存进去的顺序和拿出来的顺序不一样，其是因为没有下标，无法绑定死顺序)
 *      2.存储的元素可以自动按照大小顺序排序，称之为可排序集合
 *
 */
public class TreeSetBase {
    public static void main(String[] args) {
        //创建集合对象
        Set<String> s = new TreeSet<>();
        //添加元素
        s.add("abc");
        s.add("abv");
        s.add("niHao");
        s.add("k");
        //foreach遍历
        for (String s1:s){
            System.out.println(s1);
        }
        /*
            abc
            abv
            k
            niHao
        从小到大的顺序排序
         */
    }
}
