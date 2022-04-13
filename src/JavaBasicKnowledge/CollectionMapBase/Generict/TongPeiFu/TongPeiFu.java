package JavaBasicKnowledge.CollectionMapBase.Generict.TongPeiFu;

/**
 *通配符：？
 */
public class TongPeiFu {
    //当两个不同类使用同一种方法，怎么把这个方法提取出来呢？
    //使用泛型形式参数
    public static void eatFruit(GenericHolder<Fruit> fruitHolder){
        System.out.println("我正在吃"+fruitHolder.getObj().getName());
    }
    //也可以使用多态
    public static void buy(Fruit fruit) {
        System.out.println("我正在买"+fruit.getName());
    }

    /**eatFruit改进版
     * 通配符?使得一个方法适用于其他类
     * @param fruitHolder
     */
    public static void eatFruit01(GenericHolder<? extends Fruit> fruitHolder){
        System.out.println("我正在吃"+fruitHolder.getObj().getName());
    }

    public static void main(String[] args) {
        //这是一个水果袋子，可以装水果以及水果子类的袋子
        GenericHolder<Fruit> fruitHold = new GenericHolder<>();
        //苹果袋子，也只能装它和它的子类
        GenericHolder<Apple> appleHold = new GenericHolder<>();
        //创建一个水果对象
        Fruit fruit = new Fruit("水果");
        //创建一个苹果对象
        Apple apple = new Apple("苹果");

        //--------------------------------------------------------------
        //把水果放进水果袋子里面
        fruitHold.setObj(fruit);
        //调用吃水果的方法
        eatFruit(fruitHold);
        //调用买水果的方法
        buy(fruit);
        /**
         *贴了水果的袋子放水果当然是没有问题
         * 现在我们把水果的子类-苹果放到这个袋子里试试看
         */
        System.out.println("=================================");
        fruitHold.setObj(apple);
        //Apple apple1 = fruitHold.getObj();报错，因为返回的是Fruit类型
        eatFruit(fruitHold);
        System.out.println("=================================");
        /*
        同样也是可以的，其实这时候发生了自动向上转型，apple会自动转型成fruit
        但是从苹果袋子里返回的时候，我们可以从以下代码发现：
        public T getObj() {
             return obj;
        }
        它只能返回fruit类型，所以水果袋子里取出来的子类全是父类类型
         */
        appleHold.setObj(apple);
        /**
         * apple类型的袋子只能放apple，放不了fruit，这样就导致了eatFruit的复用率很差
         * 那有没有一种方法使得袋子里既能放苹果，又能放水果呢？
         *
         * 那就是通配符？
         */
        //==============================================================
        System.out.println("=================================");
        //把水果放进水果袋子里面
        fruitHold.setObj(fruit);
        //调用吃水果的方法
        eatFruit01(fruitHold);

        //把水果放进水果袋子里面
        fruitHold.setObj(apple);
        //调用吃水果的方法
        eatFruit01(fruitHold);
        System.out.println("=================================");
    }
}

//定义一个水果类
class Fruit{
    private String name;

    public Fruit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//定义一个水果类
class Apple extends Fruit{
    public Apple(String name) {
        super(name);
    }
}

//定义一个食物
class Food{
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//这是一个袋子，什么都能装，还能把袋子里的对象取出来，为什么会去创建这个袋子呢？
//因为当两个不同类使用同一种方法，如果想把这个方法单独提取出来使用，就必须使用泛型形式参数，而
//泛型只能跟在类名后，无法跟在方法名后，所以如果想在方法中使用泛型，必须定义一个泛型容器，然后把泛型类当作形参传入
//那为什么不使用多态，如果存储的是没有继承关系却拥有相同方法的类型。那该方法就报废了
class GenericHolder<T> {

    private T obj;

    public GenericHolder(T obj) {
        this.obj = obj;
    }

    public GenericHolder() {

    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}