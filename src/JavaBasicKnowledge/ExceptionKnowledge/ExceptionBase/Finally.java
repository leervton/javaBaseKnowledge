package JavaBasicKnowledge.ExceptionKnowledge.ExceptionBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 关于try...catch中的finally子句：
 *      1.在finally子句中的代码是最后执行的，并且是一定会执行的，即使try语句块中的代码出现了异常
 *              finally子句必须和try一起出现，不能单独编写
 *      2.finally语句通常使用在哪些情况下呢？
 *          通常在finally语句块中完成资源的释放/关闭
 *          因为finally中的代码比较有保障性
 *          即使try语句块中的代码出现了异常，finally中的代码也会正常执行
 *
 */
public class Finally {
    public static void main(String[] args) {
        FileInputStream fis = null;//声明位置放到try外面，这样finally中的局部变量fis才能用
        try {
            //创建输入流对象
            //FileInputStream fis = new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");
            fis = new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");
            //开始读文件

            String str = null;
            //这里一定会出现空指针
            str.toString();

            //流使用完需要关闭，因为流是占用资源的
            //即使以上程序出现异常，流也必须关闭
            //但是放在这里可能流关不了
            //fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //流的关闭放在这里比较保险
            //finally中的代码一定会执行
            //即使try中出现了异常
            //try语句块 FileInputStream fis = new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");会导致fis.close();中fis报红
            //所以应该把 FileInputStream fis = new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");拆分成
            /*
                 FileInputStream fis = null;放在try...catch语句块外边
                 fis = new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");
             */
            if(fis != null) {//避免try语句块对象没有new成功，导致空指针异常
                try {
                    //close方法有异常，捕捉一下
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
