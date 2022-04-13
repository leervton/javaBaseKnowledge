package JavaBasicKnowledge.IO.File.FileIO.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FileInputStream类的其他常用方法
 *      int available()     :返回流当中剩余的没有读到的字节数量
 *      long skip(long n)   :跳过几个字节不读
 */
public class FileInputStreamOther {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\java\\temp");
            System.out.println("总字节数量:"+fis.available());
            //读一个字节
            int readByte = fis.read();
            //还剩可以读的字节数量：
            System.out.println("剩下未读字节的数量："+fis.available());
            //该代码有什么用处呢？
            //可以使用在数组读取字节中
            byte[] bytes = new byte[fis.available()];
            //此代码直接new出文件类字节数量的数组，从而导致不需要循环，直接一次性读完，
            // 但是缺点是不适合大型文件阅读，因为数组本身也是连续的，而且也找不到一块连续的很大的内存空间，导致数组也不能太大
            int readCount = fis.read(bytes);
            //此代码的作用就是将文本字节从硬盘读入内存数组中
            System.out.println(new String(bytes));
            /**
             * =====================================================
             */
            //skip跳过几个字节不读取，这个方法以后可能也会用
            fis.skip(2);
            System.out.println(fis.read());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
