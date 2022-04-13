package HomeWork;

import java.io.*;

/**
 * 拷贝目录：
 *      将D:\ChromeCore\ChromeCoreLauncher.exe拷贝到c盘根目录下
 *
 *      需要使用到：
 *          FileInputStream
 *          FileOutputStream
 *          File
 */
public class CopyHomework {
    public static void main(String[] args) {
        ReadInOutNote readInOutNote = new ReadInOutNote("D:\\ChromeCore\\ChromeCoreLauncher.exe","C:\\Users\\Administrator\\Desktop\\java\\001");
        readInOutNote.inOut();
    }
}
class ReadInOutNote{
    private String s;
    private String s1;
    public ReadInOutNote() {
    }

    public ReadInOutNote(String s, String s1) {
        this.s = s;
        this.s1 = s1;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getName(){
        File file = new File(s);
        File file01 = new File(s1);
        return file01+"\\"+file.getName();
    }
    public void inOut(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(s);
            fos = new FileOutputStream(getName());
            System.out.println(getName());
            int readCount=0;
            byte[] bytes = new byte[1024*1024];
            while((readCount=fis.read(bytes))!=-1){
                fos.write(bytes,0,readCount);
            }
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
    }

}