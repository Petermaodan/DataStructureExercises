package jianzhioffer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * 终止条件： 当 l \geq rl≥r 时，代表子数组长度为 1 ，此时终止划分；
 * 递归划分： 计算数组中点 mm ，递归划分左子数组 merge_sort(l, m) 和右子数组 merge_sort(m + 1, r) ；
 * 合并与逆序对统计：
 * 暂存数组 numsnums 闭区间 [i, r][i,r] 内的元素至辅助数组 tmptmp ；
 * 循环合并： 设置双指针 ii , jj 分别指向左 / 右子数组的首元素；
 * 当 i = m + 1i=m+1 时： 代表左子数组已合并完，因此添加右子数组当前元素 tmp[j]tmp[j] ，并执行 j = j + 1j=j+1 ；
 * 否则，当 j = r + 1j=r+1 时： 代表右子数组已合并完，因此添加左子数组当前元素 tmp[i]tmp[i] ，并执行 i = i + 1i=i+1 ；
 * 否则，当 tmp[i] \leq tmp[j]tmp[i]≤tmp[j] 时： 添加左子数组当前元素 tmp[i]tmp[i] ，并执行 i = i + 1i=i+1；
 * 否则（即 tmp[i] > tmp[j]tmp[i]>tmp[j]）时： 添加右子数组当前元素 tmp[j]tmp[j] ，并执行 j = j + 1j=j+1 ；此时构成 m - i + 1m−i+1 个「逆序对」，统计添加至 resres ；
 * 返回值： 返回直至目前的逆序对总数 resres ；
 *
 */
public class it_51_数组中的逆序对 {
    public static void main(String[] args) {
        int[] nums={7,5,6,4};
        System.out.println(new it_51_数组中的逆序对().reversePairs(nums));
    }

    int[] nums,tmp;

    public int reversePairs(int[] nums) {
        this.nums=nums;
        tmp=new int[nums.length];
        return mergeSort(0,nums.length-1);
    }

    private int mergeSort(int l, int r) {
        //终止条件
        if (l>=r)return 0;
        //递归划分
        int mid=(l+r)/2;
        int res=mergeSort(l,mid)+mergeSort(mid+1,r);
        int i=l,j=mid+1;
        for (int k = l; k <=r ; k++) {
             tmp[k]=nums[k];
        }
        for (int k = l; k <=r ; k++) {
            if (i==mid+1){
                nums[k]=tmp[j++];
            }else if (j==r+1||tmp[i]<=tmp[j]){
                nums[k]=tmp[i++];
            }else {
                nums[k]=tmp[j++];
                res+=mid-i+1;//统计逆序对
            }
        }
        return res;
    }
}
