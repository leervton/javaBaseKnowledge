package JavaBasicKnowledge.Annotation注释.AnnotationStudy;

//@Deprecated表示标注的元素已经过时了
//这个注解主要是向其他程序员传达一个信息：此代码已经过时，有更好的方法
@Deprecated
public class Annotation03 {
    @Deprecated
    public void doSome(){
        System.out.println("do Something");
    }

    @Deprecated
    public void doOther(){
        System.out.println("do Other....");
    }
}

class T{
    public void main(String[] args) {
        Annotation03 an = new Annotation03();
        an.doSome();
        an.doOther();
        System.out.println();
    }
}