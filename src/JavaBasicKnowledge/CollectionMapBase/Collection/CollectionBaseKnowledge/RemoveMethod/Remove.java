package JavaBasicKnowledge.CollectionMapBase.Collection.CollectionBaseKnowledge.RemoveMethod;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 测试remove方法，思考：
 *      如果我们调用remove方法移除掉u1对象或者u2对象，那是否把集合中的jack也移除了呢？
 *      答案：是的，底层调用了u1或u2类的equals方法，判断出了u1和u2实际上是同一个元素，移除u1或u2说白了就是移除jack这个元素
 *           当然移除u1的时候就如同移除了u2
 *
 */
public class Remove {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();

        //创建用户对象
        User01 u1 = new User01("Jack");
        User01 u2 = new User01("Jack");

        //将u1加入集合中
        c.add(u1);

        //判断集合是否包含u2？
        System.out.println(c.contains(u2));
        /**
         * 底层调用了equals方法，判断出了u1和u2实际上是同一个元素，移除u1或u2说白了就是移除jack这个元素
         * 当然移除u1的时候就如同移除了u2
         */
        //移除u1或者u2，查看集合中的元素还有多少个
        c.remove(u1);
        System.out.println(c.size());//0
    }
}

class User01{
    private String name;

    public User01() {
    }
    public User01(String name) {
        this.name = name;
    }
    //有意思的重写方法，因为已被重写的equals方法只有String和八种基本数据类型的包装类，
    // 其他引用数据类型都没有被重写，所以只能通过代码转到已被重写的几个类
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User01)) return false;
        User01 user = (User01) o;
        return user.name.equals(this.name);
    }
}