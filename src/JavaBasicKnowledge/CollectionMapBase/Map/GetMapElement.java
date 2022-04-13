package JavaBasicKnowledge.CollectionMapBase.Map;

import java.util.*;

/**
 * Map集合的遍历
 *          ：
 */

public class GetMapElement {
    public static void main(String[] args) {
        //第一种方式：获取所有的key，通过遍历key，来遍历value
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");
        map.put(4,"赵六");
        //遍历集合
        /**
           其中所有的key所在的集合是一个set类型集合
         */
        Set<Integer> set= map.keySet();
        //foreach
        for (Integer i:set){
            System.out.println(i+","+map.get(i));
        }
        //Iterator
       Iterator it = set.iterator();
        while (it.hasNext()){
           Object m = it.next();
            System.out.println(m+":"+map.get(m));
        }
        //第二种方式：Set<Map.Entry<K,V>> entrySet()
        //以上这个方法是把Map集合全部直接转换成set集合，set集合中元素的类型是什么？
        //是Map.Entry

       Set<Map.Entry<Integer,String>> set1 = map.entrySet();
        //遍历Set集合，每一次取出一个node
        //迭代器Iterator
        /*
        Iterator<Map.Entry<Integer,String>> it1 = set1.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next());
           // ===================================
            Map.Entry<Integer,String> node =it1.next();
            Integer key = node.getKey();
            String value = node.getValue();
            System.out.println(key +"="+value);

        }
        //加强for
        for (Map.Entry<Integer,String> entry: set1){
            System.out.println(entry);
        }
         */
        //这种方式效率比较高，因为获取key和value都是从node对象中获取属性值
        //这种方式比较适合大数据量
        for (Map.Entry<Integer,String> node:set1){
            System.out.println(node.getKey()+"="+node.getValue());
        }
    }
}
