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
        int[] arr = new int[]{9,2,5,4,7,2, 1, 6};
        int[] sort = sort(arr, 0, arr.length);
        for (int j : sort) {
            System.out.printf("%d ", j);
        }
    }

    public static int[] sort(int[] arr, int ls, int le) {
        // 当开始索引大于结束索引则不会进if，返回arr，递归时只有一个条件不满足则直接返回
        if (ls < le) {
            // 将数组按大小分，此处会排序，获取中间分界索引值,递归是会将partition的值两边推进
            int partition = partition(arr, ls, arr.length);
            // 此时（partition-1）是le,递归后le会往ls推进直到，ls=le，则不再进入if，方法返回
            sort(arr, ls, partition - 1);
            // 此时（partition+1）是ls,递归后ls会往le推进直到，ls=le，则不再进入if，方法返回
            sort(arr, partition + 1, le);
        }
        return arr;
    }

    /**
     * 处理数组arr索引ls到le的中间元素，设arr[ls]为基准值pivot（基准值位置不变），
     * 将小于pivot的元素替换到靠近pivot的数组左边，位置依次++，
     * 将pivot与最后一个小于pivot的数组元素替换位置。最终返回pivot索引
     * 核心逻辑，以索引开始位置的值为标准值，将数组与该值比较，然后将小于他的数往左边替换，直到比他小的元素都替换完则左边的都比他小，最终达到大小分界的目的
     *
     * @param arr 数组
     * @param ls  开始索引
     * @param le  结束索引
     * @return 中间值的索引
     */
    public static int partition(int[] arr, int ls, int le) {
        // 设置基准值
        int pivot = arr[ls];
        int index = ls + 1;
        for (int i = index; i < le; i++) {
            // 从索引1开始，如果比标准值小，则将该值与index的索引上的值替换，每替换一次index+1,即发现有比0号索引位置的数
            if (arr[i] < pivot) {
                swap(arr, i, index);
                index++;
            }
        }
        // 此时有index-1个比标准值小的数，且都已经左移，那么将pivot替换到arr[index-1]则index-1左边的数都比pivot小，
        // 此时返回index-1则是分界索引
        swap(arr, ls, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
