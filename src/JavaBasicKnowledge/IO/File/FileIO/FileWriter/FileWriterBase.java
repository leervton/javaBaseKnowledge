package JavaBasicKnowledge.IO.File.FileIO.FileWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * FileWriter
 *      文件字符输出流，写
 *      只能输出普通文本
 */
public class FileWriterBase {
    public static void main(String[] args) {
        FileWriter fiw=null;
        try {
            //创建文件字符输出流对象
            fiw = new FileWriter("C:\\Users\\Administrator\\Desktop\\java\\新建文件02");
            //开始写
            char[] chars = {'我','是','中','国','人'};
            fiw.write(chars);
            fiw.write(chars,2,3);
            fiw.write("我是一名软件工程师");
            //写出一个换行符
            fiw.write("/n");
            fiw.write("hello world");
            fiw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fiw!=null){
                try {
                    fiw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
