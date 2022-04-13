package JavaBasicKnowledge.CollectionMapBase.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * java.util.Map接口中常用的方法：
 *      1.Map和Collection没有继承关系
 *      2.Map集合以key和value的方式储存数据：键值对
 *              key和value都是引用数据类型
 *              key和value都是存储对象的内存地址
 *              key起到主导地位，value是key的一个附属
 *              =================================
 *            ||key是一个set集合，无法直接转成List集合||
 *             ===================================
 *      3.Map接口中常用方法：
 *              V put(K key, V value)               向Map集合中添加键值对
 *
 *              V get(Object key)                   通过key获取value
 *
 *              void clear()                        清空Map集合
 *
 *              boolean containsKey(Object key)     判断Map集合中是否包含某个key
 *
 *              boolean containsValue(Object value) 判断Map集合中是否包含某个value
 *
 *              boolean isEmpty()                   判断Map集合中元素个数是否为0
 *
 *              Set<K> keySet()                     获取Map集合中所有的key（所有的键是一个Set集合）
 *
 *              V remove(Object key)                通过key删除键值对
 *
 *              int size()                          获取Map集合中键值对的个数
 *
 *              Collection<V> values()              获取Map集合中所有的value，返回一个Collection
 *
 *              Set<Map.Entry<K,V>> entrySet()       将Map集合转换成Set集合，尖括号里面Map.Entry<K,V>是泛型
 *              举例：
 *                      map1
 *                      Key                 value
 *                      -----------------------
 *                      1                   张三
 *                      2                   王五
 *                      3                   李四
 *                      4                   赵六
 *                      -------------------------
 *
 *                      调用entrySet()方法将Map集合转换成Set集合
 *                      Set set  =  map1.entrySet();
 *
 *                      set集合【注意：Map集合通过entrySet()方法转换成的这个set集合，set集合中的元素类型是Map.Entry<K,V>】
 *                              【Map.Entry和String一样，都是一种类型的名字，只不过Map.Entry是静态内部类，是Map下的静态内部类】
 *                      -------
 *                      1=张三
 *                      2=王五
 *                      3=李四
 *                      4=赵六
 *                      ------
 *
 *
 */
public class MapBase {
    public static void main(String[] args) {
        //创建Map集合对象
        Map<Integer,String> map = new HashMap<>();
        //向Map集合对象中添加键值对
        map.put(1,"张三");//这里1自动装箱了
        map.put(2,"李四");
        map.put(3,"王五");
        map.put(4,"赵六");
        //通过key获取value
        String value = map.get(2);
        System.out.println(value);

        //获取键值对的数量
        System.out.println("键值对的数量"+map.size());

        //获取所有value
        Collection<String> collection = map.values();
        //增强for循环
        for (String s:collection){
            System.out.println(s);
        }

        //获取所有的key
        Collection<Integer> collection1 = map.keySet();
        //增强for循环
        for (Integer i:collection1){
            System.out.println(i);
        }


        //通过key删除value
        map.remove(2);
        System.out.println("键值对的数量"+map.size());
        //判断是否包含某个key
        //contains方法底层调用的都是equals进行比对的，所以自定义类型需要重写equals方法
        System.out.println(map.containsKey(2));//false
                                               //false的原因：虽然key看起来像Map集合的下标，
                                              // 但key却不是下标，Map集合更像是两个数组并列，然后左右数组一一对应联系，
                                               //其中一个数组叫做key，另一个叫做value，每一个key对应着它的值value
                                               //key集合用作下标，而value集合就是key集合对应的值
                                               //所以删除了一个key却不是删除了下标，而是删除了key集合中的一个元素

        //判断是否包含某个value
        System.out.println(map.containsValue("赵六"));//true
        //清空Map集合
        map.clear();
        System.out.println("键值对的数量"+map.size());
        //判断集合是否为空
        System.out.println(map.isEmpty());


    }
}
