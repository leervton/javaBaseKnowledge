package JavaBasicKnowledge.CollectionMapBase.Collection.Set;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet集合无序不可重复
 */
public class HashSetBase {
    public static void main(String[] args) {
            //演示一下HashSet集合特点
        Set<String> set = new HashSet<>();

        //添加元素
        set.add("hello");
        set.add("hello1");
        set.add("hello2");
        set.add("hello3");
        set.add("hello");

        //增强for遍历集合
        for (String s:set){
            System.out.println(s);
        }
        /*
            hello1
            hello2
            hello
            hello3
            1.存储时的顺序和取出时的顺序不相同
            2.不可重复
            3.放到HashSet集合中的元素其实是放到HashMap集合的key部分了
         */
    }
}
