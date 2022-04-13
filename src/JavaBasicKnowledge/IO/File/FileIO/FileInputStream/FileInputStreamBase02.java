package JavaBasicKnowledge.IO.File.FileIO.FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * int read(byte[] b)
 *      一次最多读取b.length个字节
 *      减少硬盘和内存的交互，提高程序执行的效率
 *      往byte[]数组当中读取
 *      将字节读入数组中，即将数据存入数组，再通过数组进行操作
 *
 */
public class FileInputStreamBase02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            //相对路径的话呢？相对路径一定是从当前所在的位置作为起点开始寻找
            //IDEA默认的路径在哪呢？
            //工程project的根就是IDEA的默认当前路径
            fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\java\\temp");
            //开始读，采用byte数组，一次读取多个字节，最多读取“数组.length”个字节
            byte[] bytes =new byte[4];//准备一个4个长度的byte数组，一次最多读4个字节
            //这个方法的返回值是：读取到的字节数量（不是字节所对应的asc码）
            int readCount = fis.read(bytes);
            System.out.println(readCount);//第一次读到了4个字节
            //System.out.println(new String(bytes));//将字节数组全部转成字符串abcd
            //不应该是全部都转换成字符串，应该是读取了多少个字节，转换多少个
            System.out.println(new String(bytes,0,readCount));

            readCount = fis.read(bytes);
            System.out.println(readCount);//第二次读到了2个字节
            //System.out.println(new String(bytes));//efcd
            System.out.println(new String(bytes,0,readCount));

            readCount = fis.read(bytes);//一个字节也没读到返回-1
            System.out.println(readCount);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
