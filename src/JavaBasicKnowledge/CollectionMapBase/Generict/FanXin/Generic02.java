package JavaBasicKnowledge.CollectionMapBase.Generict.FanXin;

/**
 * 自定义泛型可以吗？可以
 *      自定义泛型的时候，<>尖括号中的是一个标识符，随便写，但习惯上一般写E或T
 *      E 是element的首字母
 *      T 是type的首字母
 */
                //Generic02指定的泛型，用哪那里的代码必须和这里保持一致
                //虽然可以随便写，但是一般写E或者T，比较方便
public class Generic02<标识符随便写> {

                    //doSome方法的实参也是指定的泛型
                    // 没有具体到哪个内容，意思就是说：
                // 这里的形参和实参要和Generic02指定的泛型一一对应
    public void doSome(标识符随便写 o){
        System.out.println(o);
    }
//---------------------------------------------------------------------
    public static void main(String[] args){
        //new对象的时候指定了泛型是：String类型
        Generic02<String> gt =new Generic02<>();

        //这里报错原因是类型不匹配，因为Generic02<>类指定了泛型
        //我们在构建类的时候Generic02类指定的泛型和doSome方法的形参是一致的
        // 而doSome方法的实参必须与Generic02的实参保持一致
        //gt.doSome(100);
        gt.doSome("abc");

        //-----------------------------------------------
        /**
         * 在这里为什么new的时候却没有指定泛型new Generic02<>();
         * 而Generic02<Integer>却指定了泛型呢？
         *
         * 因为new Generic02<>();该类中的泛型根本不是一个类而是一个代号，E/T，所以不能指定
         * 但是Generic02<Integer>这里可以把new Generic02<>();指定的泛型具体化某个类型
         */
        Generic02<Integer> gt2 = new Generic02<>();
        //创建的新类gt2指定的泛型类型是Integer，
        // 构建代码的时候我们已经要求doSome方法和 Generic02指定的泛型一致
        //所以这里报错的原因是类型不一致
        //gt2.doSome("abc");

        MyIterator<String> mi = new MyIterator();
        String str = mi.get();

        MyIterator<Animal> mi01 = new MyIterator();
        Animal animal = mi01.get();

        /*
         //在这里我们虽然指定了泛型，但是我们在此基础上依然可以不使用泛型，后果是传的和输出的都是Object类型的任何对象，避免不了向下转型
       Generic02 gen= new Generic02();
       gen.doSome(new Object());
         */


    }

}

//----------------------------------------------------------------------------------
class MyIterator<T>{
    public T get(){
        return null;
    }
}
