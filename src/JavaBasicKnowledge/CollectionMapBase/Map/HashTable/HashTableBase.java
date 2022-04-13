package JavaBasicKnowledge.CollectionMapBase.Map.HashTable;

import java.util.Hashtable;
import java.util.Map;

/**
 * HashTable的key或者value能为null吗？
 *      HashTable都不能为null
 *      HashMap可以
 *
 * HashTable方法都带有synchronized：线程安全的
 * 线程安全有其他方案，这个HashTable对现程的处理导致效率较低
 * 使用较少了
 *
 * HashTable和HashMap一样，底层都是哈希表数据结构
 * HashTable的初始化容量是11，默认加载因子是0.75
 * HashTable扩容是：原容量*2+1
 */
public class HashTableBase {
    public static void main(String[] args) {
        Map map = new Hashtable();
        map.put(null,100);
        //NullPointerException
        System.out.println(map.size());

        //NullPointerException
        map.put(100,null);
        System.out.println(map.size());
    }
}
