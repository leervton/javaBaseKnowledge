package JavaBasicKnowledge.CollectionMapBase.Collection.CollectionBaseKnowledge.ContainsMethod;

import java.util.ArrayList;
import java.util.Collection;

public class Contains01 {
    public static void main(String[] args) {
        //创建集合对象
        Collection c = new ArrayList();

        //创建用户对象
        User u1 = new User("Jack");
        User u2 = new User("Jack");
        String str = new String("jack");

        //将u1加入集合中
        c.add(u1);
        c.add(str);

        //判断集合是否包含u2？
        System.out.println(c.contains(str));//true
        System.out.println(c.contains(u2));//true
        System.out.println(c.contains("jack"));//str
    }
}
//该类没有重写equals方法时，输出false；重写之后，输出true
class User{
    private String name;

    public User() {
    }
    public User(String name) {
        this.name = name;
    }
    //有意思的重写方法，因为已被重写的equals方法只有String和八种基本数据类型的包装类，
    // 其他引用数据类型都没有被重写，所以只能通过代码转到已被重写的几个类
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //不是User类返回false
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return user.name.equals(this.name);
    }
}
