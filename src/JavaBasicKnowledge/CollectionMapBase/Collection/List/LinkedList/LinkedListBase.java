package JavaBasicKnowledge.CollectionMapBase.Collection.List.LinkedList;

/**
 * 对于链表数据结构来说：基本的单元是节点Node
 *      对于单向链表来说，任何一个Node中都有两个属性：
 *      第一：存储的数据
 *      第二：下一个节点的内存地址
 *
 * 链表：随机增删元素效率较高，（因为链表数据结构本身不连续，所以增删元素不需要后续元素位移）
 *      查询效率较低（因为链表数据结构不连续，所以每次查询元素的时候都需要从头节点开始往下遍历）
 */
 public class LinkedListBase{
    public static void main(String[] args) {
        //创建LinkedListBase01集合
        LinkedListBase01 link = new LinkedListBase01();
        //往集合中添加元素
        link.add(100);
        link.add(100);
        link.add(100);
        link.add(100);
        //获取元素个数
        System.out.println(link.size());
    }
}
 class LinkedListBase01 {
    //头节点
    Node header;

    //

    //链表元素个数
    int size;

    public int size(){
        return size;
    }

    //向链表添加元素的方法
    public void add(Object o){
        //当向节点中添加数据时，节点中存储下一个节点地址的空间必须要由null变成实际地址
        //意思就是说当向节点添加数据时，必须要创建新的节点，然后上一个节点存储的下一个节点的内存地址必须要指向新创建的节点
        //创建一个新的节点
        //让之前单链表的末尾节点next指向新节点
        if (header == null){
            //说明没有节点，创建一个新的节点对象，作为头节点
            //这个时候头节点，也是一个末尾节点
            header = new Node(o,null);
        }else{
            //说明头节点不是null，头节点已经存在
            //找出当前末尾节点，让当前末尾节点的next时一个新节点
            Node currentLastNode = findLast(header);
            currentLastNode.next = new Node(o,null);
        }
        size++;
    }

    /**
     * 专门查找末尾节点的方法，在这里使用了递归算法
     * @return
     * @param node 从头节点开始查找
     */
    private Node findLast(Node node) {
        if (node.next== null){
            //如果一个节点的next是null
            //说明这个节点就是末尾节点
            return node;
        }
        //程序走到这里说明node不是末尾节点
        return findLast(node.next);
    }

    //删除链表某个元素的方法
    public void remove(Object o){}

    //修改链表中某个元素的方法
    public void modify(Object o){}

    //查找链表中某个元素的方法
    public int find(Object o){
        return  1;
    }
}

//节点
class Node{
    //存储的数据
    Object element;

    //下一个节点的地址
    Node next;

    public Node() {
    }

    public Node(Object element, Node next) {
        this.element = element;
        this.next = next;
    }
}
