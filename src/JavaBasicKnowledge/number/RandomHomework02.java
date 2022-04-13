package JavaBasicKnowledge.number;

import java.util.Arrays;
import java.util.Random;

public class RandomHomework02 {
    public static void main(String[] args) {
        //创建Random对象
        Random r = new Random();
        //创建一个长度为5的数组
        int[] arr = new int[5];
        for(int i = 0;i<arr.length;i++){
            arr[i]= -1;
        }
        //循环，生成随机数
        /**该循环因为和排序同向导致部分元素无法改变，所以建议循环对向，即你减我增的形式
         * int index = 0;
            while (index<arr.length){
            int num = r.nextInt(10);
                //判断这个数组有没有这个num
                if(search(arr,num)<0){
                    arr[index] = num;
                    index++;
                }
            }
            for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
            }
         */
        int index =arr.length-1;
        while (index>=0){
            int num = r.nextInt(10);
            //判断这个数组有没有这个num
            if(search(arr,num)<0){
                arr[index] = num;
                index--;
                /**
                 * arr[index++]=num;
                 */
            }
        }
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static int search(int[] arr,int i){
        //先对数组进行排序
        Arrays.sort(arr);
        /**原始数组：-1，-1，-1，-1，-1
         * 和循环同向排序导致部分重复元素找到后，无法被改变，建议循环和排序相向运行，即排序升序，那循环应该从高往低替换
         * -------------------------------------------------------
         * 第一次随机数生成：28
         * 此时数组下标为1
         * 【28】，-1，-1，-1，-1
         * -------------------------------------------------------
         * 第二次随机数生成：36
         * 但是此时调用search方法，先排序后查找
         * -1，【-1】，-1，-1，28
         * 此时下标为2
         * -1，【36】，-1，-1，28
         * ---------------------------------------------------------
         * 第三次随机数生成：7
         * 先排序后查找
         * -1，-1，【-1】，28，36
         * 此时循环到数组下标为3
         * -1，-1，【7】，28，36
         * ----------------------------------------------------------
         * 第四次随机数查找
         *
         * 我们发现越到后面被替换的数字越靠后，反而前面的数字没法改变
         * 所以建议使用降序，或者替换的数字应该使用i--
         *
         *
         *
         */

        //用二分法查找是否有该元素
        return Arrays.binarySearch(arr,i);
    }
}
