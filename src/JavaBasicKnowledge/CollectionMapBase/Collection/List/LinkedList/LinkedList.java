package JavaBasicKnowledge.CollectionMapBase.Collection.List.LinkedList;

/**
 * 链表的优点：
 *      由于链表上的元素在空间存储上内存地址不连续
 *      所以随即增删元素的时候不会有大量元素位移，因此随机增删效率比较高
 *      在以后的开发中，如果遇见随即增删集合中元素的业务比较多的时候，建议使用
 *      LinkedList
 *链表的缺点：
 *      由于内存空间不连续，不能通过数学表达式计算被查找元素的内存地址，每一次查找都是从头结点
 *      开始遍历，直到找到为止，所以LinkedList集合检索/查找效率比较低
 *
 *注意：由于我们添加元素，大部分的时候都是按先后顺序添加，即实现效果为往集合末尾添加元素，所以使用ArrayList集合较多
 *      末尾添加元素效率很高，因为不涉及元素的位移
 *
 */
public class LinkedList {
    public static void main(String[] args) {
        //LinkedList集合底层也有下标
        //注意：ArrayList之所以检索效率比较高，不是单纯因为下标的原因，是因为底层数组发挥的作用
        //LinkedList集合照样有下标，但是检索效率比较低，因为每一个节点都不连续，所以只能从头节点一个一个开始遍历
    }
}
