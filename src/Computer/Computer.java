package Computer;

public class Computer {
    //在这里作为实现者的mouse以及其他实现者都被绑定在接口上了
    //类似于向上转型，只不过接口是功能的抽象而不是类的抽象
    Usb s;
    //提供无参构造和有参构造为接口进行初始化赋值
    public Computer(){ }

    public Computer(Usb s) {
        this.s = s;
    }
    public void peiJian(){
        s.Combine();
    }
}
