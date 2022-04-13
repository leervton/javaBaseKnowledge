package JavaBasicKnowledge.sort;

import java.util.Arrays;

/**
 * @ClassName ArraysSort
 * @Description TODO
 * @Author erainm
 * @Date 2020/7/9 10:46
 * @Version 1.0
 **/
public class ArraysSort {
    public static void main(String[] args) {
        int[] arr = {12,34,54,0,23,65,3,76};
        System.out.println("排序前数组：" + Arrays.toString(arr));
        // 冒泡排序
        //BubbleSort(arr);
        // 插入排序
        //insertSort(arr);
        // 归并排序
        //mergeSort(arr,0,arr.length-1);
        // 快速排序
        //quickSort(arr,0,arr.length-1);
        // 选择排序
        selectSort(arr);
        // 希尔排序
        //shellSort(arr);

        System.out.println("排序后数组：" + Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    private static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    arr[j] = arr[j] + arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
        }
        System.out.println("排序后数组：" + Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr
     * @param start
     * @param end
     */
    private static void quickSort(int[] arr,int start,int end){
        if (start<end){
            // 把数组中的第0个索引为的元素作为标准数
            int stard = arr[start];
            // 记录需要排序的下标
            int low = start;
            int high = end;
            // 循环找比标准数大的数和比标准数小的数
            while (low<high){
                // 右边数比标准数大
                while (low<high&&stard<=arr[high]){
                    high--;
                }
                // 使用右边的数替换左边的数
                arr[low] = arr[high];
                // 如果左边的数比标准数小
                while (low<high&&arr[low]<=stard){
                    low++;
                }
                arr[high] = arr[low];
            }
            // 把标准数赋给高或者低的位置的元素（此时高低下标已经重合）
            arr[low] = stard;
            quickSort(arr,start,low);
            quickSort(arr,low+1,end);
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    private static void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 把当前遍历的数和后面所有的数依次进行比较，并记录下最小的数
            for (int j = i+1; j < arr.length; j++) {
                // 如果后面比较的数比记录的最小的数小
                if (arr[minIndex] > arr[j]){
                    // 记录下最下数的那个数的索引
                    minIndex = j;
                }
            }
            // 如果最小的数和当前遍历数的索引不一致,说明索引为minIndex的元素比当前遍历的元素更小
            if (i!=minIndex){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    private static void shellSort(int[] arr){
        // 遍历所有步长
        for (int d = arr.length/2; d >0 ; d/=2) {
            // 遍历所有元素
            for (int i = d; i < arr.length ; i++) {
                // 遍历本组中所有的元素
                for (int j = i-d; j >= 0; j-=d) {
                    if (arr[j] > arr[j+d]){
                        int temp = arr[j];
                        arr[j] = arr[j+d];
                        arr[j+d] = temp;
                    }
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    private static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            // 若果当前索引元素小于前一个索引元素
            if (arr[i]<arr[i-1]){
                int temp = arr[i];
                int j;
                // 遍历当前索引前面所有索引元素
                for (j = i-1; j >= 0 && arr[j] > temp ; j--) {
                    // 把前一个索引的元素赋给后一个索引的元素
                    arr[j+1] = arr[j];
                }
                // 循环结束后需要把临时变量（外层for循环的当前元素）赋给不满足条件的后一个元素
                arr[j+1] = temp;
            }
        }
        System.out.println("排序后数组：" + Arrays.toString(arr));
    }

    /**
     * 归并排序
     * @param arr
     * @param low
     * @param high
     */
    private static void mergeSort(int[] arr, int low, int high) {
        int middle = (low + high) / 2;
        if (low < high) {
            // 处理左边
            mergeSort(arr, low, middle);
            // 处理右边
            mergeSort(arr, middle + 1, high);
            // 归并
            merge(arr, low, middle, high);
        }
    }

    private static void merge(int[] arr, int low, int middle, int high) {
        // 用于存储归并后的数组
        int[] temp = new int[high - low + 1];
        // 用于记录第一个数组中需要遍历的下标
        int i = low;
        // 记录第二个数组中需要遍历的下标
        int j = middle + 1;
        // 用于记录在临时数组中存放下标
        int index = 0;
        // 遍历两个数组，取出小的元素放入临时数组中
        while (i <= middle && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        // 处理剩余的数据
        while (j <= high) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        // 将临时数组中的数据重新放到原数组
        for (int k = 0; k < temp.length; k++) {
            arr[k + low] = temp[k];
        }
    }

}
