package JavaBasicKnowledge.IO.PrintIO;

import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * java.io.PrintStream:标准的字节输出流,默认输出到控制台
 */
public class PrintStreamBase {
    public static void main(String[] args) throws Exception {
        //联合起来写
        System.out.println("hello world");

        //分开写
        PrintStream ps = System.out;
        ps.println("zhang san");
        ps.println("lisi");
        ps.println("wangwu");

        //标准输出流不需要手动close()关闭
        //可以改变标准输出流的输出方向吗？可以的
        /*
        System.gc();
        System.currentTimeMillis();
        PrintStream ps1 = System.out;
        System.exit(0);
        System.arraycopy();*/

        //标准输出流不再指向控制台，而是指向“log”文件
        PrintStream ps01 = new PrintStream(new FileOutputStream("log"));
        //修改输出方向，将输出方向修改到"log"文件
        System.setOut(ps01);

        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
    }
}
