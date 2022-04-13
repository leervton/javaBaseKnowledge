package JavaBasicKnowledge.Extends;
//数据的数据转型都用向下转型
public class Instanceof01 {
    public static void main(String[] args) {
        //new父类数组
        Person[] per = new Person[1];
        //将子类对象放在父类数组中
        Man01 m = new Man01();
        //以下代码注销后仍然有效
        per[0] = m;
        //测试下标为0的父类数组元素是否是接口Buy类型的实例
        System.out.println(per[0] instanceof Buy);//true

        //Buy a= per[0];//编译报错

        //虽然per[0]是接口Buy类的实例，但向上转型依然失败，只能强转
        Buy c= (Buy) per[0];

        //这里m就是数组第一个元素per[0]，逻辑上上下两个代码执行逻辑都一样，但是一个能直接转，另一个不能直接转
        Buy d = m;
    }
}
//接口
interface Buy{
    void buyThings();
}

//父类
class Person{

}
//子类
class Man01 extends Person implements Buy{
    @Override
    public void buyThings() {
        System.out.println("");
    }
}