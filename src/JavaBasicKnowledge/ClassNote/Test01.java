package JavaBasicKnowledge.ClassNote;
//多态测试，形参为父类，实参为子类
/**
    ctrl+p查看参数
 */
public class Test01 {
    public static void main(String[] args) {
        bike b1 = new bike();
        person p1 = new person();

       /*
        调用方式错误
        System.out.println(p1.Go(v1));
        */

       /**
        第一种调用方式：
        形参是父类,实参是父类；
        先把子类向上转型，把子类转成父类实参调用
        */
        vehicle v1 = new bike();
        p1.Go(v1);
        vehicle v2 = new car();
        p1.Go(v2);

        /**
        第二种调用方式：
         （自动类型转换或者是向上转型）
        形参是父类，实参是子类
        需要注意的是此处为何形参和实参没有一一对应是因为其有继承关系
         即使形参为父类，实参为子类，但是执行过程中也会把子类实参向上转换为父类实参
         这种向上转型是一种自动转换
         --------------------------------------
         vehicle v = new bike();
         p1.Go(v);
        -----------------------------------------
         */
        p1.Go(new bike());
        p1.Go(new car());
    }
}
class person{
    public void Go(vehicle v){
        v.run();
    }

}
class vehicle{
    public void run(){

    }
}
class bike extends vehicle{
    public void run(){
        System.out.println("要啥自行车?");
    }
}
class car extends vehicle{
    public void run(){
        System.out.println("要啥小轿车？");
    }
}