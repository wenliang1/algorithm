package com.liang.sort;


/**
 * <p>
 * 快排
 * </p>
 *
 * @author wenliang <15918428115@163.com>
 * @date 2022-03-05 12:47
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {10,5,9,7,2,1,6};
        int[] sort = sort(arr, 0, arr.length);
        for (int i = 0; i < sort.length; i++) {
            System.out.printf("%d ", sort[i]);
        }
    }

    public static int[] sort(int[] arr, int ls, int le){
        if (ls < le){
            int partition = partition(arr, ls, arr.length);
            sort(arr, ls, partition-1);
            sort(arr, partition+1, le);
        }
        return arr;
    }


    public static int partition(int[] arr, int ls, int le){
        // 开始比较的索引
        int index = ls + 1;
        for (int i = index; i < le; i++) {
            if (arr[i] < arr[ls]){
                swap(arr, i, index);
                index ++;
            }
        }
        swap(arr, ls, index-1);
        return index - 1;

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
