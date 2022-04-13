package JavaBasicKnowledge.CollectionMapBase.Collection.List.LinkedList;

import java.util.LinkedList;

/**
 * 双向链表结构：
 *      双向链表结构和单向链表结构的基本单元还是节点
 *
 *      void linkLast(E e) {
 *         final Node<E> l = last;
 *         final Node<E> newNode = new Node<>(l, e, null);
 *         last = newNode;
 *         if (l == null)
 *             first = newNode;
 *         else
 *             l.next = newNode;
 *         size++;
 *         modCount++;
 *     }
 */
public class LinkedListBase1 {
    public static void main(String[] args) {
        new LinkedList();
    }
}
//链表集合

/**
 * 基本思路为：在链表集合中创建一个头节点（永远位于集合的第一个节点）和一个尾节点（永远位于集合的最后一个节点），
 *          （因为新储存的数据按照存储顺序只能向末尾添加，这时候末尾节点存储的数据便不是最后一个的了）
 *          当向末尾储存数据时候，把末尾节点的数据拿出来，储存的临时容器k内，再创建一个新的容器装新数据，然后把新数据对象挂在存储上一个
 *          尾节点的临时容器之后即可
 *
 */
class LinkList{
    //集合的头节点
    Node01 first;
    //集合的尾节点
    Node01 last;
    //添加数据，并把节点挂载到上一个节点方法
    void linkLast(Object e) {
        //创建临时容器l，盛装尾节点数据，这时候尾节点空出来了
        Node01 l = last;
        //创建新的节点对象放置要存储的数据，然后把这个新的节点挂在上一个尾节点后面
        // 因为按顺序新的节点都在最末尾，所以新的节点应该挂载在上一个末尾节点last后面
        //但是这时候上一个末尾节点last的内容已经储存在临时节点容器l里面了，所以挂在l后面即可
        Node01 newNode = new Node01(l, e, null);
        //这时候新的末尾节点就是新创建的存储数据的节点newNode
        last = newNode;
        //如果尾节点是null，那新数据无法挂载上面，所以首节点必然是新创建的节点
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
    }
}
class Node01{
    Node01 pre;
    Object data;
    Node01 next;
    public Node01(Object i,Object o,Object k) {
        pre = (Node01) i;
        data = o;
        next = (Node01) k;
    }
}