package JavaBasicKnowledge.CollectionMapBase.Map.HashTable;

import java.util.Properties;

/**
 * 目前只需要掌握Properties属性类对象的相关方法即可
 * Properties是一个Map集合，继承HashTable，Properties的key和value都是String类型
 * Properties被称之为属性类对象
 * Properties是线程安全的
 */
public class ProPerTies {
    public static void main(String[] args) {
        //创建一个属性类对象
        Properties p = new Properties();
        //需要掌握Properties的两个方法
        p.setProperty("UserName","root");
        p.setProperty("PassWord","123");

        //通过key获取value（Alt编辑多行）
       String s = p.getProperty("UserName");
       String s1 = p.getProperty("PassWord");


        System.out.println(s);
        System.out.println(s1);



    }
}
