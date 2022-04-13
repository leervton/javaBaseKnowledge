package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

/**
 * 之前讲解过方法覆盖的时候遗留了一个问题：
 *          重写之后的方法不能比重写之前的方法抛出数量更多（更宽泛）的异常，但可以更少
 *          1.数量(相同类，不同实例对象异常算一个，这里说的是不同类)
 *          2.可以抛更小的，即是其子类
 *          3.越写越少，越写越小
 */

public class OverWriteAndException {
}

class Animal{
    public void doSome(){

    }
    public void doOther()throws Exception{

    }
}

class cat extends Animal{
    /**
     *---------------------------------------------
     * public void doSome () throws Exception {
     *         super.doSome();
     *     }
     * 编译异常
     * ----------------------------------------------
     * public void doOther(){
     *         super.doOther();
     *     }
     * 编译正常
     * -----------------------------------------------
     */


}