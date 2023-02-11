package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
 *
 * 一次煎饼翻转的执行过程如下：
 *
 * 选择一个整数 k ，1 <= k <= arr.length
 * 反转子数组 arr[0...k-1]（下标从 0 开始）
 * 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
 *
 * 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。任何将数组排序且翻转次数在 10 * arr.length 范围内的有效答案都将被判断为正确。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,4,1]
 * 输出：[4,2,4,3]
 * 解释：
 * 我们执行 4 次煎饼翻转，k 值分别为 4，2，4，和 3。
 * 初始状态 arr = [3, 2, 4, 1]
 * 第一次翻转后（k = 4）：arr = [1, 4, 2, 3]
 * 第二次翻转后（k = 2）：arr = [4, 1, 2, 3]
 * 第三次翻转后（k = 4）：arr = [3, 2, 1, 4]
 * 第四次翻转后（k = 3）：arr = [1, 2, 3, 4]，此时已完成排序。
 *
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= arr.length
 * arr 中的所有整数互不相同（即，arr 是从 1 到 arr.length 整数的一个排列）
 *
 * 由于每次我们都对「某段前缀」进行整体翻转，并且规定了翻转次数在一定范围内的方案均为合法翻转方案，同时 arr 又是 1 到 n 的排列。
 *
 * 我们可以很自然想到「冒泡排序」：每次确定未排序部分最右端的元素（最大值）。
 *
 * 具体的，假设下标 [k+1,n−1] 部分已有序，如果我们希望当前值 t 出现在某个位置 k 上，可以进行的操作为：
 *
 * 如果当前值 t 已在 k 上，无须进行操作；
 * 如果当前值不在 k 上，根据当前值是否在数组头部（下标为 0）进行分情况讨论：
 * 当前值在数组头部（下标为 0），直接将[0,k] 部分进行翻转（将k+1 加入答案中），即可将当前值 t 放到位置 k 上；
 * 当前值不在数组头部（下标为 0），而是在 idx 位置上，需要先将 [0,idx] 部分进行翻转（将 idx+1 加入答案中），
 * 这样使得当前值 t 出现数组头部（下标为 0），然后再将 [0,k] 部分进行翻转（将 k+1 加入答案中），即可将当前值 t 放到位置 k 上。
 *
 *而翻转某个前缀的操作可使用「双指针」实现，复杂度为O(n)
 */
public class it_969_煎饼排序 {
    public static void main(String[] args) {
        int[] arr={3, 2, 4, 1};
        List<Integer> list = new it_969_煎饼排序().pancakeSort(arr);
        ListUtil.arrayOne(list);
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res=new ArrayList<>();
        int n=arr.length;
        //记录下标,翻转的时候需要用到
        int[] idxs=new int[n+1];
        //初始化idxs
        for (int i = 0; i < n; i++) {
            idxs[arr[i]]=i;
        }

        //开始冒泡排序，先排后面的
        for (int i = n; i >=1 ; i--) {
            int idx=idxs[i];
            //若在正确位置，则不需要翻转
            if (idx==i-1){
                continue;
            }
            //若不在正确位置，则需要判断是否在下标为0的位置
            //若不在0的位置则先翻转到0
            if (idx!=0){
                res.add(idx+1);
                reverse(arr,0,idx,idxs);
            }
            //再翻转到正确的位置
            reverse(arr,0,i-1,idxs);
            res.add(i);
        }
        return res;
    }

    private void reverse(int[] arr, int i, int j, int[] idxs) {
        //双指针交换数组
        while (i<j){
            //下标交换
            idxs[arr[i]]=j;
            idxs[arr[j]]=i;
            //内容交换
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}
