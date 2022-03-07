package com.liang.sort;

/**
 * <p>
 * 递归
 * 1、找出最小重复单元
 * </p>
 *
 * @author wenliang <15918428115@163.com>
 * @date 2022-03-07 11:26
 * @since 1.0.0
 */
public class Recursion {

    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 3, 4};
//        int[] reverse = reverse(arr, 0, arr.length - 1);
//        for (int i : reverse) {
//            System.out.printf("%d ", i);
//        }
//        int i = new Recursion().stairCount(60);
//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
//        ListNode listNode1 = reverseList(listNode);
//        System.out.println(listNode1);
        new Recursion().recursion(0, 10);
    }


    /**
     * 数组翻转
     *
     * @param arr   数组
     * @param start 开始索引
     * @param end   结束索引
     * @return 翻转后的数组
     */
    public static int[] reverse(int[] arr, int start, int end) {
        if (start > end) {  return arr;}
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        return reverse(arr, start + 1, end - 1);
    }

    /**
     * 递归打印
     * 递归理解：
     * 1、设置跳出条件
     * 2、递进去之前的操作
     * 3、传递操作（本质上啥也没做）
     * 4、归回来之后的操作
     *
     * @param start 起始值
     * @param end   终点值
     */
    public void recursion(int start, int end) {
        if (start < end) {
            System.out.print(start + " ");
            recursion(++start, end);
            System.out.print(start - 1 + " ");
        } else {
            System.out.println();
            System.out.println("reverse");
        }
    }


    /**
     * 链表翻转
     *
     * @param head ListNode
     * @return ListNode
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 首先进入的是第一个节点，第一次返回的是末尾的节点，此时head.next == null，
        // 最终返回的本质上是最后一个节点，每此返回都会上一级方法接收到。并且此时会将head修改，head只是某一个节点
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     *
     * @param n 楼层
     * @return 总数
     */
    public int stairCount(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
