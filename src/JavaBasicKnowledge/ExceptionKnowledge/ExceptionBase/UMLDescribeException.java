package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

public class UMLDescribeException {
    /**
     * UML的作用是什么？它又是什么？
     * UML是一种统一建模语言，一种图标式语言（画图的），相当于建筑设计图的作用
     * UML不是只有java中使用，只要是面向对象的编程语言，都有UML
     * 一般画UML图的都是软件架构师或者是系统分析师，这些级别的人员使用的
     * 软件设计人员使用UML
     *
     * 在UML图中可以描述类和类之间的关系，程序执行的流程，对象的状态等
     * 盖大楼和软件开发一样，一个道理
     *      盖楼之前，会先由建筑师画图纸，图纸上的一个一个的符号都是标准符号
     *      这个图纸画完，只要是搞建筑的都能看懂，因为这个图纸标注的这些符号
     *      都是一种“标准的语言”
     *
     * 在java软件开发当中，软件分析师和设计师负责设计类，java软件开发人员必须要能看懂
     * ---------------------编译异常和运行异常-----------------------
     *
     * 编译时异常和运行时异常，都是发生在运行阶段。编译阶段异常是不会发生的
     * 编译时异常因为什么而得名
     *      因为编译时异常必须在编译（编写）阶段预先处理，如果不处理编译器报错，因此得名
     *      所有异常都是在运行阶段发生的，因为只有程序运行阶段才可以new对象
     *      因为异常的发生就是new异常对象
     *  ----------------------------区别-------------------
     *  编译时异常一般发生的概率比较高
     *      即手动编写代码时，出现红线，需要try catch或者throws时出现的异常，如果不处理，编译无法通过，编译器报错。
     *      编译时异常：被叫做受检异常或者是受控异常，编译时被检测的异常，譬如语法错误
     *          举个例子：
     *              你看到外面下雨了，倾盆大雨。
     *              你出门之前会预料到：如果不打伞，我可能会生病（生病是一种异常）
     *              而且这个异常发生的概率很高，所以我们出门之前要拿一把伞
     *              “拿一把伞”就是对“生病异常”发生之前的一种处理方式
     *
     *              对于一些发生概率较高的异常，需要在运行之前对其进行预处理
     *
     *  运行时异常一般发生的概率比较低
     *      运行时异常：未受检异常，编译时不被检测的异常，譬如程序内部错误或者逻辑错误
     */
}