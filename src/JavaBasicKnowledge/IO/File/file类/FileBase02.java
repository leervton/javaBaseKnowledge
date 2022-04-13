package JavaBasicKnowledge.IO.File.file类;

import java.io.File;

/**
 * File中的listFiles方法
 */
public class FileBase02 {
    public static void main(String[] args) {
        //File[] listFiles()
        //获取当前目录下所有的子文件
        File file =new File("D:\\");
        File[] files = file.listFiles();
        //foreach
        for (File f:files){
            //获取子文件的所有绝对路径
            System.out.println(f.getAbsolutePath());
            //获取子文件的文件名
            System.out.println(f.getName());
        }
    }
}
