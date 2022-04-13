package JavaBasicKnowledge.CollectionMapBase.Map.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * HashMap集合：
 *          1.HashMap集合底层是哈希表/散列表的数据结构
 *          2.哈希表是一个怎样的数据结构呢？
 *                  哈希表是一个数组和单向链表的结合体
 *                  数组：在查询方面效率很高，随机增删方面效率很低
 *                  单向链表：在随机增删方面效率较高，在查询方面效率很低
 *                  哈希表将以上的两种数据结构融合在一起，充分发挥它们各自的优点
 *          3.串珠门帘：数组当作门帘的上沿，单向链表挂在数组下面
 *              public class HashMap{
 *
 *                  //HashMap底层实际上就是一个一维数组
 *                  Node<K,V>[] table;
 *
 *                  //静态的内部类HashMap.Node
 *                  static class Node<K,V> implements Map.Entry<K,V>{
 *                         final int hash;//哈希值（哈希值是key的hashCode()方法的执行结果，哈希值通过哈希函数/算法，可以转换存储成数组的下标）
                 *         final K key;//存储到Map集合中的那个key
                 *         V value;//存储到Map集合中的value
                 *         Node<K,V> next;//指向下一个单向链表节点的内存地址
 *                  }
 *              }
 *              哈希表/散列表：一维数组，这个数组中的每一个元素都是一个单向链表（数组和链表的结合体）
 *          4.最主要掌握的是：
 *                  map.put(k,v);
 *                      其实现原理：
 *                              第一步：先将k，v封装到Node对象当中
 *                              第二部：底层会调用key的hashCode()方法得出的hash值
 *                                    然后通过哈希算法/哈希函数，将hash值转换成数组的下标
 *                                    下标位置上如果没有任何元素，就把Node添加到这个位置上
 *                                    如果说下标对应的位置上有链表，此时会拿着k和链表上的每一个节点中的k
 *                                    进行equals，如果所有的equals方法返回的都是false，那么这个新节点
 *                                    将会被添加到链表的末尾，如果其中有一个equals返回了true，那么这个节点的
 *                                    value将会被覆盖
 *                  v = map.get(k);
 *                        其实现原理：
 *                                  第一步：先调用k的hashCode()方法得出哈希值，通过哈希算法转换成数组下标，
 *                                          通过数组下标快速定位到这个位置，如果该位置上什么也没有，返回null
 *                                          如果这个位置上有单向链表，那么会拿着参数k和单向链表上的每个节点中的k进行equals
 *                                          如果所有的equals方法返回false，那么get方法返回null，
 *                                          只要其中有一个节点的k和参数k equals的时候返回true，
 *                                          那么此时这个节点的value就是我们要找的value，get方法最终返回这个要找的value
 *            以上这两个方法的实现原理
 *          5.为什么哈希表的随机增删，以及查询效率都很高？
 *                  增删是在链表上完成
 *                  查询也不需要都扫描，只需要扫描其中一个，部分扫描
 *            重点：通过讲解可以得出HashMap集合的key，会先后调用两个方法，一个是hashCode()，一个是equals()
 *                 那么这两个方法都需要重写
 *          6.为什么放在HashMap集合key部分的元素需要重写equals方法呢？
 *              因为equals默认比较的是两个对象的内存地址，我们应该比较内容
 *          7.HashMap集合的key部分特点：
 *              无序，不可重复
 *              为什么无序？
 *                  因为不一定挂到哪一个单向链表上，这个位置跟调用k的hashCode()方法得出的哈希值有关
 *              不可重复是怎么保证的？
 *                  equals方法来保证HashMap集合的key不可重复，如果key重复了，value会覆盖，导致不会存在同一个key的节点node
 *          8.放在HashMap集合key部分的元素其实就是放到HashSet集合中了
 *            所以HashSet集合中的元素也需要重写hashCode()和equals方法
 *
 *          9.注意：同一个单向链表上所有节点的hash值相同，因为他们的数组下标是一样的，
 *                  虽然这里的哈希值是由k调用hashCode()算出来的，即使hash值一样，但是他们的k值都不一样
 *
 *          10.哈希表HashMap使用不当的时候无法发挥性能
 *              假设将所有的hashCode()方法返回值固定为某个值，那么会导致底层哈希表变成了纯单向链表
 *              这种情况我们称之为散列分布不均匀
 *              什么是散列分布均匀？
 *                  假设有100个元素，10个单向链表，那么每个单向链表有10个节点，这是最好的，是散列分布均匀的
 *                  假设将所有的hashCode()方法的返回值都设定为不一样的值，可以吗？有什么问题？
 *                      不行，这样的话导致了底层哈希表就成为了一维数组，没有链表的概念，也是散列分布不均匀
 *              散列分布均匀需要你重写hashCode()方法时，有一定的技巧
 *          11.重点：放在HashMap集合中key部分的元素，以及放在HashSet集合中的元素，需要同时重写hashCode()和equals()方法
 *          12.HashMap集合的默认初始化容量是16，默认加载因子是0.75
 *                  这个默认加载因子是当HashMap集合底层数组的容量达到了75%的时候，数组开始扩容
 *                  HashMap集合初始化容量必须是2的倍数，这也是官方推荐的，这是因为达到散列均匀，为了提高
 *                  HashMap集合存储效率，所必需的
 */
public class HashMapBase {
    public static void main(String[] args) {
        //测试HashMap集合key部分元素的特点
        //Integer是key，它的hashCode和equals方法都重写了
        Map<Integer,String> map = new HashMap<>();
        map.put(1111,"张三");
        map.put(6666,"李四");
        map.put(7777,"王五");
        map.put(2222,"赵六");
        map.put(2222,"King");//key重复，value会自动覆盖了

        System.out.println(map.size());//4
        //遍历map
       Set<Map.Entry<Integer,String>> set = map.entrySet();
       //循环
        for (Map.Entry<Integer,String> m: set){
            //HashMap集合key部分无序不可重复
            System.out.println(m.getKey()+"="+m.getValue());
        }
    }
}
