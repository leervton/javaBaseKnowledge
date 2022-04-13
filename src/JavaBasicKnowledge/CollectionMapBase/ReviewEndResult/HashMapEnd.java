package JavaBasicKnowledge.CollectionMapBase.ReviewEndResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEnd {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(100,"张三");
        map.put(10,"李四");
        map.put(16,"王五");
        map.put(2,"赵六");
        map.put(2,"唐六");//key重复value会覆盖
        //获取元素的个数
        System.out.println(map.size());
        //获取key是2的元素
        System.out.println(map.get(2));
        //遍历Map集合很重要，几种方式都要会
        //第一种，先获取所有的key，遍历key的时候，通过key获取value
        Set<Integer> keys =map.keySet();
        for (Integer key:keys){
            System.out.println(key+"="+map.get(key));
        }

        //第二种方法，是将Map集合转换成Set集合，Set集合中每一个元素是Node
        //这个Node节点中有key和value
        Set<Map.Entry<Integer,String>> nodes = map.entrySet();
        for (Map.Entry<Integer,String> node:nodes){
            System.out.println(node.getKey()+":"+node.getValue());
        }
    }
}
