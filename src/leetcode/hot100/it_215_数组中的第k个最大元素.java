package leetcode.hot100;

import java.util.Arrays;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class it_215_数组中的第k个最大元素 {
    public static void main(String[] args) {
        int[] nums={1,3,5,2,2};
        int k = 3;
        System.out.println(new it_215_数组中的第k个最大元素().findKthLargest(nums,k));
    }


    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        //因为是第几大，并非第几小
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        //获取随机下标
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    //快速排序核心代码
    public int partition(int[] a, int l, int r) {
        //选出来的数储存在x中
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        //将r插入属于他的位置，中轴位置
        swap(a, i + 1, r);
        //i+1就是随机选出来的数的下标
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
