package JavaBasicKnowledge.Extends;


/**
 * 首先我们应该明确一点：接口是对功能的抽象，例如电脑，手机，电视机可以抽象为购物车物品，他们都拥有相同的接口，购买方法
 *                   所以我们抽象一个付款功能接口，让电脑，手机，电视机都去实现它
 *
 * 普通对象使用继承关系是可以利用多态来增加代码的复用率，但是接口也是可以继承的
 * 接口的继承是可以增强，接口的功能性，拓展接口的功能，举个例子：
 *              爬行动物都可以呼吸和运动，所以我们使用接口A来抽象"呼吸();"和"运动();"这一个功能方便使用
 *              但是由于业务拓展，涉及到了水生动物，此时再写一个"呼吸();"和"运动();"的方法便不合适了
 *              我们复用接口A，利用继承的特性，让接口B去继承接口A，并且在接口B中添加一个接口B特有的
 *              方法"游泳();"
 *
 *  总结：接口的继承实质上就是对父类接口功能的拓展
 */
public class Extends {
}

class cat implements Live{
    @Override
    public void breath() {
        System.out.println("猫在呼吸");
    }

    @Override
    public void sport() {
        System.out.println("猫在跑");
    }
}

class fish implements WaterLive{
    @Override
    public void breath() {
        System.out.println("🐟在吐泡泡");
    }

    @Override
    public void sport() {
        System.out.println("🐟在活动");
    }

    @Override
    public void swim() {
        System.out.println("🐟在游泳");
    }
}

interface Live{
    void breath();

    void sport();
}

interface WaterLive extends Live{
    void swim();
}