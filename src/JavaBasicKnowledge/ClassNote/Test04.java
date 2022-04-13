package JavaBasicKnowledge.ClassNote;

/**
 * 测试同类中能否调用实例方法或实例变量
 */

public class Test04 {
    int lea = 5;
    public void key(){
        System.out.println("我是实例对象");
    }
    public static void main(String[] args) {
        //Test04.key();
        //报错：Non-static method 'key()' cannot be referenced from a static context
        //即实例方法不可访问，在内存上只读不写


        //System.out.println(lea);
        //Non-static field 'lea' cannot be referenced from a static context
        //Error:(16, 28) java: 无法从静态上下文中引用非静态 变量 lea
        //即实例变量不可访问
    }
}
