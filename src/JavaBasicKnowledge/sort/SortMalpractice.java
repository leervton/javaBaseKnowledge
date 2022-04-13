package JavaBasicKnowledge.sort;

import java.util.Arrays;
//查找二分法弊端
public class SortMalpractice {
    public static void main(String[] args) {
        int[] arr = {0,2,2,6,9,10};
        //用二分法对含有相同元素的数组查重，结果显示明显不准确
        int k = SortMalpractice.search(arr,2);
        System.out.println(k);
        /**
         * arr数组：
         * 0，0，0，0，0
         * 对应下标：
         * 【0】【1】【2】【3】【4】
         * 所以第一个被查找的数组是arr[(low+high)/2]
         * 即arr[2]，因为他的值是0，所以只能输出中间位置的0的下标
         * 即2，其他的便查不到了，而且靠近最左边的相同元素是永远查不到的
         * 譬如：【0】，0，1，2，3，5
         * 这里的两个0，左边的0是查不到的
         *        0，1，【2】，2，5，6，7
         * 这里的两个2，左边的一个2是永远查不到的
         *
         */
    }
    //查重方法
    public static int search(int[] arr,int i){
        //先对数组进行排序
        Arrays.sort(arr);

        //用二分法查找是否有该元素
        return Arrays.binarySearch(arr,i);
    }
}
