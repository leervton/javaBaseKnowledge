package JavaBasicKnowledge.ClassNote;
/**
 * 编写程序，使用一维数组，模拟栈数据结构
 * 要求：1.这个栈可以存储java中的任何引用类型的数据
 *      2.在栈中提供push方法模拟压栈（栈满了，要有提示信息）
 *      3.在栈中提供pop方法模拟弹栈（栈空了，要有提示信息）
 *      4.编写测试程序，new栈对象，调用push，pop方法来模拟压栈弹栈的动作
 *      5.假设栈的默认初始化容量是10.（请注意无参构造方法的编写方式）
 */
public class Test051 {

}

class stack{
    //向栈中存入元素，我们使用一维数组进行模拟，存到栈中，就表示存到数组中
    //因为数组是我们学习Java的第一个容器
    //为什么选择object类型数组？因为这个栈可以存储java中的任何引用数据类型,object是任何类的超级父类
    private Object[] elements;

    /**
     * 提供一个栈帧永远指向栈顶部元素
     * 那这个默认初始值应该是多少。注意：最初的栈是空的，一个元素都没有
     */
    //private int index = 0; index采用0时，表示栈帧指向了元素顶部的上方
    private int index = -1;//index采用-1时，表示栈帧指向了元素的顶部

    public stack() {
        this.elements = new Object[10];
    }

    //set和get方法虽然可能用不上，但是习惯上要写
    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    /**
     * 压栈方法push
     */
     public void push(Object o){
         if(index >= this.elements.length-1){
             System.out.println("内存已满");
             return;
         }
         //程序能走到这说明栈没满
         this.index++;
         elements[index]=o;
         System.out.println("push stack"+ o + "success" +"and the index point to" + index);
     }

    /**
     * 弹栈就是往数组里往外取元素，每取出一个元素，栈帧向下移动一位
     * 值得注意的是，这里并没有把数组内的元素清空，数组内的元素还在，只不过功能实现了
     * @return
     */
     public void pop(){
         if (index < 0){
             System.out.println("弹栈失败，栈已空");
             return;
         }
         System.out.println(elements[index]+"弹栈成功");
         index--;
         System.out.println("栈帧指向"+ index);
     }
}
