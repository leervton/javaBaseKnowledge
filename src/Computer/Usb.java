package Computer;
public interface Usb {
    //接口没有构造器，因为其没有变量只有常量，构造器是用来初始化变量的，所以构造器没有用处
    //类也可以实现多个接口，如果接口有自己的构造器，不好决定构造器链的调用次序
    public void Combine();
}
