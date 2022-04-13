package JavaBasicKnowledge.number;
import java.util.Arrays;
import java.util.Random;

/**
 * 编写程序，生成5个不重复的随机数，重复的话重新生成
 * 最终生成的5个随机数放到数组中，要求数组中这5个随机数不重复
 */

public class RandomHomeWork {
    public static void main(String[] args) {
        //准备一个长度为5的一维数组
       int arr[] = new int[5];
        for(int i = 0; i<arr.length;i++){
            arr[i]=-1;
        }
        //循环，生成随机数
        RandomHomeWork rh = new RandomHomeWork();
        rh.packageArrays(arr);
        for(int i = 0; i<arr.length;i++){
            System.out.print(arr[i]);
        }

    }
    //元素载入数组方法
    public void packageArrays(int[] arr) {
        Random r = new Random();
        //从数组第一位开始插入不重复的元素
        for (int i = 0; i < arr.length; i++) {
            //产生随机数
            int k = r.nextInt(10);
            /**---------------------------------------
             * 该方法有bug，结果前两位永远是0
             * 将随机出来元素查重
             * int s = RandomHomeWork.search(arr,k);
             * ---------------------------------------
             */
            if(!RandomHomeWork.find(arr,k)) {
                arr[i] = k;
            }else{
                /**
                 * 此处不建议使用for循环，因为不管if条件成立与否，for循环都跌进入下一次循环
                 * 使用while循环可以设定下一次循环的条件，所以此处使用i--,使次for循环暂停一下，继续循环本次循环
                 */
                i--;
            }
        }

    }
    //查重方法
    public static boolean find(int[] arr,int k){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==k){
                return true;
            }
        }
        return false;
    }

    /**二分法排序导致bug，无法直接输出不重复的五个数字
     *
     * @param arr 输入你要查重的数组
     * @param i    输入随机产生的数
     * @return      如果该数组内已经有随机产生的数，则重复，返回该数的下标。如果没有则返回一个负数。
     */
    public static int search(int[] arr,int i){
        //先对数组进行排序
        Arrays.sort(arr);

        //用二分法查找是否有该元素
        return Arrays.binarySearch(arr,i);
    }
}
