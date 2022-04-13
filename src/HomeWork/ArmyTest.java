package HomeWork;

/**
 * 写一个类Army，代表一支军队，这个类有一个属性Weapon数组w（用来储存该军队所拥有的所有武器）
 * 该类还提供了一个构造方法，在构造方法里通过传一个int类型的参数来限定该类所能拥有的最大武器数量
 * 并用这一大小来初始化数组w
 *
 * 该类还提供了一个方法addWeapon（Weapon wa），表示把参数wa所代表的武器加入到数组w中
 * 在这个类中还定义两个方法attackAll()让w数组中的所有武器攻击
 * 以及moveAll()让w数组中的所有可移动武器移动
 *
 * 写一个主程序去测试以上程序
 *
 *      提示：
 *          Weapon是一个父类，应该有很多子武器
 *          这些子武器应该有一些可移动的，有一些是可攻击的
 */
public class ArmyTest {
    public static void main(String[] args) {
        Army a = new Army(2);
        try {
            a.addWeapon(new gun());
        } catch (WeaponException e) {
            System.out.println(e.getMessage());
        }
        a.moveAll();

    }
}
class Army{
    WeaPon01 [] w;
    //构造方法
    public Army() {}

    public Army(int a) {
        w = new WeaPon01[a];
    }
    //武器添加方法
    public void addWeapon(WeaPon01 wa) throws WeaponException {
        for(int i = 0;i<w.length;i++){
            if(w[i]==null){
                w[i]=wa;
                return;
            }
            throw new WeaponException("武器库已满，请扩容");
        }
    }
    //所有武器移动
    public void moveAll(){
        for (int i = 0;i< w.length;i++){
           if (w[i]==null){
               continue;
           }else{
               try {
                   gun g = (gun) w[i];
                   g.move();
               } catch (WeaponException e) {
                   System.out.println(w[i]+":"+e.getMessage());
               }
           }
        }

    }
    //所有武器攻击
    public void attackAll(){
        for(int i = 0;i< w.length;i++){
            if (w[i]==null){
                continue;
            }else{
                try {
                   gun g = (gun) w[i];
                   g.attack();
                } catch (WeaponException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
//武器类
class WeaPon01{
    public static void attack () throws WeaponException {
        System.out.println("父类武器射击");
    }

    public static void move() throws WeaponException {
        System.out.println("父类武器移动");
    }
}


class gun extends WeaPon01{
    public static void attack()throws WeaponException{
        System.out.println("子类武器功击");
    }

    public static void move() throws WeaponException {
        throw new WeaponException("子类武器没有移动功能");
    }
}
//自定义一个异常类
class WeaponException extends Exception{
    public WeaponException() {
    }

    public WeaponException(String message) {
        super(message);
    }
}