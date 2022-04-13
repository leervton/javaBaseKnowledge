package JavaBasicKnowledge.IO.File.file类;

import java.io.File;

/**
 * File
 *      1.File类和四大家族没有关系，所以File类不能完成文件的读和写
 *      2.File对象代表了什么？
 *              文件和目录路径名的抽象表示形式
 *              譬如：用文件夹，文本文件，游戏文件，各种图标文件。。。。来表示资源的路径名
 *              C:\DrvPath 文件夹目录是一个file
 *              C:\DrvPath\Sound.Realtek.New\20180619\AcpiServiceVnA64.dll 文本文件也是一个file
 *              一个file对象有可能对应的是目录，也可能是文件
 *              =============================================
 *              file只是一个路径名的抽象表示形式，不能通过它进行文件的读和写
 *      3.需要掌握的File类的常用方法
 *
 *
 */
public class FileBase {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Administrator\\Desktop\\java\\001");

        //判断文件是否存在！
        System.out.println(file.exists());

        //如果C:\Users\Administrator\Desktop\java\001不存在，则以文件的形式创建出来
       /*if (!file.exists()){
            //以文件的形式新建
            file.createNewFile();
            //
        }*/

        //如果C:\Users\Administrator\Desktop\java\001不存在，则以目录（文件夹的形式创建出来）
        /*if (!file.exists()){
            //以目录的形式新建
            file.mkdir();
        }*/

        //可以创建多重目录吗？
        /*File file1 = new File("D:\\a\\b\\c\\d");
        if (file1.exists()){
            //以多重目录的形式创建
            file1.mkdirs();
        }*/

        File file1 = new File("C:\\Users\\Administrator\\Desktop\\java\\001");
        //获取当前文件的父路径
        String parentPath = file1.getParent();
        System.out.println(parentPath);//C:\Users\Administrator\Desktop\java
        //或者获取当前文件的上层文件
        File parentFile = file1.getParentFile();
        System.out.println("获取绝对路径"+parentFile.getAbsolutePath());
        //获取文件名
        System.out.println("文件名"+file1.getName());
    }
}
