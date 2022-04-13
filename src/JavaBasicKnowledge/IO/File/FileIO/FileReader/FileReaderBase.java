package JavaBasicKnowledge.IO.File.FileIO.FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader
 *      文本字符输入流，只能读取普通文本
 *      读取文本内容的时候，比较方便快捷
 */
public class FileReaderBase {
    public static void main(String[] args) {
        FileReader fir = null;
        try {
            //创建文件字符输入流
            fir = new FileReader("C:\\Users\\Administrator\\Desktop\\java\\temp");
            //开始读,准备一个char数组
            char[] chars = new char[4];//一次读取4个字符
            fir.read(chars);
            for (char c:chars){
                System.out.println(c);
            }
            /*
            int readCount = 0;
            while ((readCount=fir.read(chars))!=-1){
                System.out.println(new String(chars,0,readCount));
            }
             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fir!=null){
                try {
                    fir.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
