package JavaBasicKnowledge.ClassNote;
//自动纠错：alt + Enter

/**
 * 接口
 */
public class Test03 {
    public static void main(String[] args) {
        Math m = new Math();
        m.intSum(new Computer(),100,50);
        //-------------------匿名内部类---------------
        m.intSum(new Sum() {
            public int intSum(int x, int y) {
                return 0;
            }
        },100,50);
    }
}

/**
 * 接口类实际上是一个功能的抽象类：例如自行车是车，车又可以作为购物商品，购物商品这个抽象类可以作为接口
 * 供购买者者调用，接口的使用减少了购买者和商品对象的耦合性，增加了对象的拓展功能
 * 再比如：西餐厨师和中餐厨师都可以实现菜单上的菜品，所以我们把菜单类当作接口，顾客直接调用菜单类，实现顾客和厨师的对接联系
 * 但不管再怎么样解释，在功能层面上来说，接口的实现类都是接口的子类，接口是其实现类的父类，即中西餐厨师是子类，其父类为菜单
 *
 * 总结：子类实现接口，调用者直接调用接口
 *      一对多可以区分，谁该实现功能接口
 *      譬如说电脑接口只有一个，但是可以插入多条数据线，所以数据线应该实现接口
 *      电脑直接调用接口功能
 */

//接口【一种特殊的抽象类，也可以认作父类】
interface Sum{
    int intSum(int x, int y);
}
//子类实现接口【实现实际上是一种特殊的继承，也可以看作子类继承接口】
class Computer implements Sum{
    public int intSum(int x,int y){
        return x+y;
    }
}
//调用者直接调用接口即可，或者可以认为调用者调用了该功能
class Math{


    public void intSum(Sum s, int x, int y){
        int value = s.intSum(x,y);
        System.out.println(value);
    }
}