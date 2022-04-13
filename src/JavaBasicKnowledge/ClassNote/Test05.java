package JavaBasicKnowledge.ClassNote;

/**
 * 编写程序，使用一维数组，模拟栈数据结构
 * 要求：1.这个栈可以存储java中的任何引用类型的数据
 *      2.在栈中提供push方法模拟压栈（栈满了，要有提示信息）
 *      3.在栈中提供pop方法模拟弹栈（栈空了，要有提示信息）
 *      4.编写测试程序，new栈对象，调用push，pop方法来模拟压栈弹栈的动作
 */
public class Test05{
    public static void main(String[] args) {
        DataConstruction d = new DataConstruction();
        d.push(5);
        d.push(4);
        d.push(3);
        d.push(2);
        d.push(1);
        d.push(0);
        d.push(6);

    for(int i =0;true;i++){
        System.out.println(d.o[i]);
    }

    }

}
class DataConstruction{
    int k =5;
    Object[] o = new Object[k];

    public void push(Object o) {

        //从右往左遍历数组的每一个元素
        for (int i =this.o.length-1;i+1>0;i--){
            if(k<=0){
                System.out.println("内存已满，请勿继续存储");
                return;
            }else{

            //元素为空，对这个数组元素赋值
                if (this.o[i] == null) {
                this.o[i] = o;
                k--;
                break;
                } else if (this.o[i] != null) {
                //如果这一项不是空，则跳过本次循环往下一项查找
                continue;
                }
            }

        }
        /*if(k==0){
            System.out.println("内存空间已满");
        }*/

    }
    public void pop(){
        for(int i =0;i<this.o.length;i++){
            if(k>=5){
                System.out.println("内存空间没有数据");
                return;
            }else {
                if (i != this.o.length - 1) {
                    if (o[i] != null) {
                        o[i] = null;
                        k++;
                        break;
                    }
                }
            }
        }
    }
}