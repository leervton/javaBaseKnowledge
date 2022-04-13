package HomeWork;

/**
 * 功能用接口，属性用类
 */
public class ArmyTest01 {
    public static void main(String[] args) {
        Army01 army01 = new Army01(1);
        try {
            army01.addWeapon(new Tank());
        } catch (WeaException e) {
            System.out.println(e.getMessage());
        }

        army01.attackAll();
        army01.moveAll();
    }
}
class Army01{
    private Weapon[] w;
    public Army01(int count) {
        w = new Weapon[count];
    }
    public void addWeapon(Weapon Wa) throws WeaException {
        for (int i =0;i<w.length;i++){
            //if语句和return连用的巧妙方法
            if (null==w[i]){
                w[i]= Wa;
                System.out.println(Wa.toString()+"武器添加成功");
                return;
            }
        }
        //程序执行到此处说明for循环里面，
        // if条件语句里的return（return返回一定的值，结束外层方法）没有执行，这意味着addWeapon方法也没有结束
        //这又意味着，武器没有添加成功
        throw new WeaException("武器数组已达到上限");
    }
    public void attackAll(){
        for (int i = 0;i<w.length;i++){
            if (w[i] instanceof ShootAble){
                //调用子类中特有的方法是向下转型
                /**
                 * 类在强制类型转换过程中，如果是类转换成接口类型
                 *那么类和接口之间不需要存在继承关系，也可以转换
                 *java语法中允许
                 */
                ShootAble shootAble= (ShootAble) w[i];
                shootAble.shoot();
            }
        }
    }
    public void moveAll(){
        for (int i = 0;i<w.length;i++){
            if (w[i] instanceof MoveAble){
                //w[i]是武器实例对象，而MoveAble是其要实现的接口类
                //而instanceof证实了w[i]是MoveAble的子类
                //按照多态的概念，w[i]变成MoveAble是子类转父类，小类型变大类型，能够自动转换，但这里却使用了强转
                /**[这里有一个特殊的知识点]
                 * 从数据里面取出来的数据必须强转的
                 * 内存中，因为向上转型是父类的引用指向为子类的对象，所以，它只是指向了父类应该拥有的属性和方法，
                 * 而子类的独有的方法和属性就不指向了（或者说隐藏了），当再强转到子类时。又重新指向了子类对象，那属于它的东西又恢复了。
                 */
                MoveAble moveAble=(MoveAble)w[i];
                moveAble.move();
            }
        }
    }

}
/**
 * tank是一个武器，既可移动，又可以射击
 */
class Tank extends Weapon implements MoveAble,ShootAble{
    public void shoot() {
        System.out.println("坦克开炮");
    }
    public void move(){
        System.out.println("坦克移动");
    }
}

/**
 * 高射炮只能开炮不能移动
 */
class GaoShePao extends Weapon implements ShootAble{
    public void shoot() {
        System.out.println("高射炮开炮");
    }
}
//武器类
class Weapon{

}
//移动的接口
interface MoveAble{
    void move();
}
//射击的接口
interface ShootAble{
    void shoot();
}

class WeaException extends Exception{
    public WeaException() {
    }

    public WeaException(String message) {
        super(message);
    }
}