package niuke;

import java.util.Random;

public class it_11_寻找第K大 {
    public static void main(String[] args) {
        int[] nums={1,3,5,2,2};
        int k = 3;
        int n=5;
        int res=new it_11_寻找第K大().findKth(nums,n,k);
        System.out.println(res);
    }

    //使用该方法更好理解
    public int findKth(int[] a, int n, int K) {
        // write code here
        int res=quickSelect(a,0,n-1,K);
        return res;
    }
    public int quickSelect(int[] a,int l,int r,int index){
        int q=quickSort(a,l,r);
        if(q==index-1){
            return a[q];
        }else{
            return q<index&&q>=0?quickSelect(a,q+1,r,index):quickSelect(a,l,q-1,index);
        }
    }

    public int quickSort(int[] nums ,int l,int r){
        if(l>r)return -1;
        int i=l,j=r;
        int temp=nums[l];
        while(i<j){
            while(i<j&&nums[j]<=temp){
                j--;
            }
            nums[i]=nums[j];
            while(i<j&&nums[i]>=temp){
                i++;
            }
            nums[j]=nums[i];
        }
        nums[i]=temp;
        return i;
    }




//    Random random = new Random();
//
//    public int findKth(int[] nums,int n, int K) {
//        //因为是第几大，并非第几小
//        return quickSelect(nums, 0, n - 1, n - K);
//    }
//
//    public int quickSelect(int[] a, int l, int r, int index) {
//        int q = randomPartition(a, l, r);
//        if (q == index) {
//            return a[q];
//        } else {
//            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
//        }
//    }
//
//    public int randomPartition(int[] a, int l, int r) {
//        //获取随机下标
//        int i = random.nextInt(r - l + 1) + l;
//        swap(a, i, r);
//        return partition(a, l, r);
//    }
//
//    //快速排序核心代码
//    public int partition(int[] a, int l, int r) {
//        //选出来的数储存在x中
//        int x = a[r], i = l - 1;
//        for (int j = l; j < r; ++j) {
//            if (a[j] <= x) {
//                swap(a, ++i, j);
//            }
//        }
//        //将r插入属于他的位置，中轴位置
//        swap(a, i + 1, r);
//        //i+1就是随机选出来的数的下标
//        return i + 1;
//    }
//
//    public void swap(int[] a, int i, int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }
}
