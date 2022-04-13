package JavaBasicKnowledge.Foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 集合使用foreach
 */

public class ForEach01 {
    public static void main(String[] args) {
        //创建List集合
        List<String> list = new ArrayList<>();
        //添加元素
        list.add("hello");
        list.add("world");
        list.add("kitty");
        //遍历，使用迭代器方式
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //使用下标的方式（只针对有下标的集合）
        for (int i =0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        //使用foreach即增强for循环
        //因为泛型使用的是String类型，所以这里也只能用String类型
        for (String str:list){
            System.out.println(str);
        }
    }
}
