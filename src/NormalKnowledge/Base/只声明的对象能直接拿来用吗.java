package NormalKnowledge.Base;

/**
 * 不能使用只声明未创建的对象
 * */
public class 只声明的对象能直接拿来用吗 {
    public static void main(String[] args) {
        cat c = new cat();
        c.eat();
    }
}

class cat{
    public void eat(){
        Bird bird = null;
        bird.name = "麻雀";//java.lang.NullPointerException,因为只声明却未创建实例对象
        System.out.println("猫吃"+bird.name);
    }

}

class Bird{
    String name;
    public void fiy(){
        System.out.println("我在飞");
    }
}