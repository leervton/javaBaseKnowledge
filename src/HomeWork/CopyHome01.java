package HomeWork;

import java.io.*;

/**
 * 拷贝目录
 *
 */
public class CopyHome01 {
    public static void main(String[] args) {
        //拷贝源
        File getFile = new File("C:\\Users\\Administrator\\");
        //拷贝目标
        File toFile = new File("D:\\");
        //调用拷贝方法
        copyDir(getFile,toFile);
    }

    /**
     * 拷贝目录方法
     * @param getFile 拷贝源
     * @param toFile  拷贝目录
     */
    private static void copyDir(File getFile, File toFile) {
        if (getFile.isFile()){
            //getFile如果是一个文件的话，递归结束
            //是文件的时候需要拷贝
            //。。。一边读一边写
            FileInputStream fis =null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(getFile);
                fos = new FileOutputStream((toFile.getAbsolutePath().endsWith("\\")?toFile.getAbsolutePath():toFile.getAbsolutePath()+"\\")+getFile.getAbsolutePath().substring(3));
                //一边读一边写
                byte[] bytes = new byte[1024*1024];//一次读1M
                int readCount = 0;
                while((readCount=fis.read(bytes))!=-1){
                    fos.write(bytes,0,readCount);
                }
                fos.flush();
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
                if (fos!=null){
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return;
        }
        //先获取源下面的子目录
        File[] files = getFile.listFiles();
        //代码不要一直写，一边写一边测试
        System.out.println(files.length);
        //继续写，循环取出子文件
        for (File file:files){
            //获取所有的文件（包括目录和文件）绝对路径
            //System.out.println(file.getAbsolutePath());
            //这个file有可能是文件，也有可能是目录
            if (file.isDirectory()){
                //新建对应的目录
                //System.out.println(file.getAbsolutePath());
                //C:\Users\Administrator\       源目录
                //D:\Users\Administrator\       目标目录
                String startDir =file.getAbsolutePath();
                //字符串拼接，使用三目运算符
                String endDir =(toFile.getAbsolutePath().endsWith("\\")?toFile.getAbsolutePath():toFile.getAbsolutePath()+"\\")+startDir.substring(3);
                File file1 = new File(endDir);
                //如果目录不存在，新建目录
                if (!(file1.exists())){
                    file1.mkdirs();
                }
            }
            copyDir(file,toFile);
        }
    }
}
