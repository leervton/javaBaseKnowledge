package JavaBasicKnowledge.IO.IOBase;

/**
 * 1.什么是IO
 *      I：input
 *      O：output
 *      通过IO完成对文件的读和写
 * 2.IO流的分类
 *      有多种分类方式：
 *          一种方式是按照流的方向进行分类
 *              以内存作为参照物，往内存中去，叫做输入(input)，或者叫做读(read)
 *                              从内存中出来，叫做输出(output)，或者叫做写(write)
 *          另一种方式是按照读取数据的方式不同进行分类：
 *              有的流是按照字节的方式读取数据，一次读取1个字节(byte)，等同于一次读取8个二进制位
 *              这种流是万能的，什么类型的文件都能读取，包括文本文件，图片，声音文件，视频文件。。。。。都可以读取
 *              这种流叫做字节流
 *                       假设文件file.txt，采用字节流的话是这样读的：
 *  *                          a中国bc张三fe
 *  *                          第一次读：一个字节，正好读完'a'字符('a'字符在windows系统中占用一个字节)
 *  *                          第二次读：一个字节，正好读到'中'字符的一半('中'字符在windows系统中占用两个字节)
 *                             第三次读：一个字节，正好读完'中'字符的另一半
 *
 *              有的流是按照字符的方式读取数据的，一次读取一个字符，这种流是为了方便读取普通文本文件而存在的，这种流不能
 *              读取图片，声音，视频等文件，只能读取纯文本文件，连word文件都无法读取，word有许多格式，已经不是普通文本了
 *                      假设文件file.txt，采用字符流的话是这样读的：
 *                          a中国bc张三fe
 *                          第一次读：'a'字符('a'字符在windows系统中占用一个字节)
 *                          第二次读：'中'字符('中'字符在windows系统中占用两个字节)
 *
 *
 *              综上所述：流的分类：输入流，输出流，字节流，字符流
 *
 * 3.java中的IO流已经写好了，我们程序员并不需要关心，我们主要还是掌握，在Java中已经提供好了哪些流
 *   每个流的特点是什么？每个流对象上的常用方法有哪些？
 *          java中所有的流都是在java.io下
 *
 *          java中主要还是研究：
 *          怎么new流对象
 *          调用流对象的哪个方法是读，哪个方法是写？
 *
 *
 * 4.java IO流这块有四大家族：
 *              四大家族的首领
 *              java.io.inputStream     字节输入流
 *              java.io.outputStream    字节输出流
 *
 *              java.io.Reader          字符输入流
 *              java.io.Writer          字符输出流
 *
 *              四大家族的首领都是抽象类(abstract class)
 *
 *              所有的流都实现了：java.io.closeable接口，都是可关闭的，都有close()方法
 *              流毕竟是一个管道，是内存和硬盘之间的通道，用完之后一定要关闭
 *              不然会耗费/占用很多资源，养成好习惯，用完流一定要关闭
 *
 *              所有的输出流都实现了：
 *                  java.io.Flushable接口，都是可刷新的，都有flush()
 *               养成一个好习惯，输出流在最终输出之后，一定要记得flush()
 *               刷新一下，这个刷新表示将通道/管道当中剩余未输出的数据
 *               强行输出完（清空管道），刷新的作用就是清空管道
 *               注意：如果没有flush()可能会导致丢失数据
 *
 *       注意：在java中只要‘类名’以Stream结尾的都是字节流，以Reader/Writer结尾的都是字符流
 *
 * 5.java.io包下需要掌握的流有16个：
 *              //文件专属
 *              java.io.FileInputStream
 *              java.io.FileOutputStream
 *              java.io.FileReader
 *              java.io.FileWriter
 *
 *              //转换流（将字节流转换为字符流）
 *              Java.io.InputStreamReader
 *              Java.io.OutputStreamWriter
 *
 *              //缓冲流专属
 *              java.io.BufferedInputStream
 *              java.io.BufferedOutputStream
 *              java.io.BufferedReader
 *              java.io.BufferedWriter
 *
 *              //对象专属流
 *              Java.io.ObjectInputStream
 *              Java.io.ObjectOutputStream
 *
 *              //数据流专属
 *              Java.io.DataInputStream
 *              Java.io.DataOutputStream
 *
 *              //标准输出流
 *              Java.io.PrintReader
 *              Java.io.PrintWriter
 */
public class IOBase {
}
