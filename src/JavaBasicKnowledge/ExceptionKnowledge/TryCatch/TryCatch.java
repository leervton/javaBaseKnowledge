package JavaBasicKnowledge.ExceptionKnowledge.TryCatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * try......catch深入
 *      1.catch后面的小括号中的类型可以是具体的异常类型，也可以是该异常类型的父类型
 *      2.catch可以写多个，建议catch的时候，精确的一个一个处理，即精确的控制，这样有利于程序的调试
 *      3.catch语句块写多个的话，必须从上到下，从小到大
 */

public class TryCatch {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");
        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        }
        System.out.println("Hello world");
        //--------------------------------------------------------------------------------------------
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");
        } catch (IOException e) {//多态:IOException e = new FileInputStream; IOException is the father of FileInputStream
            System.out.println("文件不存在");
        }
        //---------------------------------------------------------------------------------------------
        try {
            //创建输入流
            FileInputStream fis = new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");
            //读文件
            fis.read();
        } catch (FileNotFoundException e) {//多态:IOException e = new FileInputStream; IOException is the father of FileInputStream
            System.out.println("文件不存在");
        }catch (IOException e){
            System.out.println("读文件报错了");
        }
        //-----------------------------------------------------------------------------------------------------
        /**
         * catch (FileNotFoundException e) 中FileNotFoundException e报错的原因是因为尝试运行程序后出现异常，程序自上而下依次运行
         * catch语句块时，第一个catch的形参IOException e作为父类包括了FileNotFoundException e，所以即使发生FileNotFoundException异常
         *也是走第一个catch语句块，导致第二个catch语句块没有任何作用，永远捕捉不到
         *
        try {
            //创建输入流
            FileInputStream fis = new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");
            //读文件
            fis.read();
        } catch (IOException e){
            System.out.println("读文件报错了");
        }catch (FileNotFoundException e) {//多态:IOException e = new FileInputStream; IOException is the father of FileInputStream
            System.out.println("文件不存在");
        }
         */
        //-----------------------------------------------try...catch------新特性-----------------------------
        try{
            //创建输入流
            FileInputStream fis = new FileInputStream("C:\\Users\\李玉堂\\Desktop\\java");
            //进行数学运算
            System.out.println(100/0);//这个是运行时异常，编写程序时可以处理，也可以不处理
        }catch (FileNotFoundException|ArithmeticException|NullPointerException e){
            System.out.println("文件不存在?数学异常?空指针异常?都有可能!");
        }
    }
}
