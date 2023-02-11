package jianzhioffer2;

public class it_69_山峰数组的顶部 {
    public static void main(String[] args) {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        int res = new it_69_山峰数组的顶部().peakIndexInMountainArray(arr);
        System.out.println(res);
    }
    public int peakIndexInMountainArray(int[] arr) {
        int l=0,r=arr.length-2;
        while (l<r){
            int mid=(l+r)/2;
            if (arr[mid]>arr[mid+1]){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return l;
    }
}
