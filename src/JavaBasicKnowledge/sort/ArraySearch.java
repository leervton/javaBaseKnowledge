package JavaBasicKnowledge.sort;

/**
 * 数组元素查找
 *      数组元素查找的两种方式：
 *          第一种方式：一个一个挨着找，直到找到为止
 *          第二种方式：二分法查找（算法），这个效率较高
 */
public class ArraySearch {

    public static void main(String[] args) {
        int[] arr = new int[5];
        int index = ArraySearch(arr,87);
        /**
         * 三目运算符
         */
        System.out.println(index == -1?"该元素不存在":"该元素下标是："+ index);

    }

    /**
     * ------------------------------------
     * 需求：找出87的下标，如果没有，返回-1
     * 一个一个挨着找。
     */
    public static void arraySearch(int[] arr,int ele){
        for(int i = 0; i<arr.length;i++){
            if(arr[i] == 87){
                System.out.println("第"+i+"个数是87");
                return;
            }
        }
        System.out.println("没有这个数");
    }


    /**
     * 从某个数组检索某个元素的下表(有两个相同元素的话，只能返回第一个)
     * @param arr 输入数组
     * @param ele 被检索的元素
     * @return 大于等于0，输出下表；-1表示该元素不存在
     */
    public static int ArraySearch(int[] arr,int ele){
        for(int i = 0; i<arr.length;i++){
            if(arr[i] == ele){
                return i;
            }
        }
        return -1;
    }
}
