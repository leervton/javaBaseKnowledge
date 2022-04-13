package NormalKnowledge.Base;

/**
 * 向上转型：将子类转化为父类。
 *
 * 向下转型：将父类转化为子类。
 *
 * 内存中，因为向上转型是父类的引用指向为子类的对象，所以，它只是指向了父类应该拥有的属性和方法，
 * 而子类的独有的方法和属性就不指向了（或者说隐藏了），当再强转到子类时。又重新指向了子类对象，那属于它的东西又恢复了。
 */
public class ClassChange {
    public static void main(String[] args) {
        // 向上转型：将父类引用指向子类对象
        Father f = new son();
        f.sleep();//输出“爸爸睡觉”
        //如果f.p();编译出错，不可执行。因为p()不是Father的方法。

    }
}

class UpAndDown {
    public static void main(String[] args) {
        // 直接向下转型
        Father f = new Father();
        f.sleep();//输出“爸爸睡觉”
        //((Son)f).P();//报错！！！！！！！！！！
    }
}
/**
 * 父类
 */
class Father {
    String name = "爸爸";

    public void sleep() {//睡觉方法
        System.out.println(name + "睡觉");
    }
}

/**
 * 子类继承父类
 */
class son extends Father {
    String name = "儿子";

    public void p() {//调皮方法
        System.out.println(name + "调皮");
    }
}