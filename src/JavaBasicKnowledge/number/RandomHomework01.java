package JavaBasicKnowledge.number;

import java.util.Random;

public class RandomHomework01 {
    public static void main(String[] args) {
        //创建Random对象
        Random r = new Random();
        //创建一个长度为5的数组
        int[] arr = new int[5];
        for(int i = 0;i<arr.length;i++){
            arr[i]= -1;
        }
        //循环，生成随机数
        int index = 0;
        while (index<arr.length){
            int num = r.nextInt(10);
            //判断这个数组有没有这个num
            if(!contains(arr,num)){
                arr[index] = num;
                index++;
                /**
                 * arr[index++]=num;
                 */
            }
        }
        for(int i = 0; i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * 判断数组包含该元素的方法
     * @param arr
     * @param key
     * @return true表示包含，false表示不包含
     */
    public static boolean contains(int[] arr,int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return true;
            }
        }
        return false;

    }
}
