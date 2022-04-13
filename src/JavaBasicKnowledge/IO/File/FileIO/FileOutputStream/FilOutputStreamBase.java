package JavaBasicKnowledge.IO.File.FileIO.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件字节输出流，负责写
 *      从内存到硬盘
 */
public class FilOutputStreamBase {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            //如果文件不存在，会自动新建
            //fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\java\\新建输出流文件");
            //这种方式谨慎使用，这种方式会将原文本内容清空，然后重新写入
            /**
             * 这里的清空有两种解释：
             *
             * 1.第一种解释：
             *          在使用同一个流对象里面追加内容不会覆盖，创建新的流却会，即不同的流之间会覆盖
             *               即：fis.write(abc);
             *                  fis.write(ef);
             *                  这里便会写入abcef
             *              若：
             *                  fis.write(abc);
             *                  fis02.write(ef);
             *                  则fis02会把fis的内容覆盖，只写ef
             * 2.第二种解释：
             *          这里的清空单纯的是清空，即读一次清空一次，若是同一个流对象，就好比使用同一个盒子，再怎么写，也只会使里面装的内容越装越多，即使清空，以前的内容也会被重新写一遍；
             *          若是遇见新的流对象，则只有一个新的容器，之前的流对象的内容被清空，只会写入新的容器内的内容，所以这里的写的内容，是流对象
             *              即：fis.write(abc);
             *                  清空以前的内容，把abc装入流对象盒子，然后把流对象盒子的内容写出
             *                 fis.write(ef);
             *                 此时清空之前的文本内容abc，而流对象盒子除了装abc，还会继续添加ef，即里面装的是abcef，然后把盒子内容写入
             *
             *但是哪种解释对呢？
             *      如果我们使用 fos = new FileOutputStream("",true);该构造器，直接在文本内容后追加的话
             *      多执行几次，我们就会发现，流对象其实就是一个容器，fos.write()其实就是往容器内装内容，而且越装越多，每次执行都会先把原文件清空，然后把容器内的内容
             *      写入文本
             */
            //原文本内容是abc，执行完程序之后却被改成abcd
            //fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\java\\temp");
            //如果不想清空原文本，而是在原文本后追加内容，使用以下构造方法
            fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\java\\temp",true);
            //开始写，这里的数字对应的是阿斯克码
            byte[] bytes = {97,98,99,100};//abcd
            //将byte数组全部写出
            fos.write(bytes);
            //将byte数组的一部分写出，追加写出ab
            fos.write(bytes,0,2);
            //写完之后一定要刷新
            fos.flush();

            /**
             * =========================================
             */
            //如何传入一个字符串？因为这是字节流，只能以字节byte（数字）的方式输入内容，所以无法输入汉字
            String s = "我是一个中国人";
            //将字符串转换成byte数组，注意\n 是换行
            byte[] by = s.getBytes();
            fos.write(by);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
