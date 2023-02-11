package jianzhioffer;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * 输入： [10,2]
 * 输出: "102"
 */
public class it_45_把数组排成最小的数 {

    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(new it_45_把数组排成最小的数().minNumber(nums));
    }

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    private void quickSort(String[] strs, int left, int right) {
        int l=left,r=right;
        if (l>=r)return;
        String temp=strs[l];
        while (l<r){
            while ((l<r)&&(temp+strs[r]).compareTo((strs[r]+temp))<=0){
                r--;
            }
            strs[l]=strs[r];
            while ((l<r)&&(strs[l]+temp).compareTo((temp+strs[l]))<=0){
                l++;
            }
            strs[r]=strs[l];
        }
        strs[l]=temp;
        quickSort(strs,left,l-1);
        quickSort(strs,l+1,right);
    }

//    public void quickSort(String[] strs, int low, int high) {
//        if (low < high) {
//            int middle = getMiddle(strs, low, high);
//            quickSort(strs, low, middle - 1);
//            quickSort(strs, middle + 1, high);
//        }
//    }
//
//    public int getMiddle(String[] strs, int l, int r) {
//        int i=l,j=r;
//        String temp=strs[i];
//        while (i<j){
//            while ((strs[j]+temp).compareTo(temp+strs[j])>=0&&i<j){
//                j--;
//            }
//            strs[i]=strs[j];
//            while ((strs[i]+temp).compareTo(temp+strs[i])<=0&&i<j){
//                i++;
//            }
//            strs[j]=strs[i];
//
//        }
//        strs[i]=temp;
//        return i;
//    }
}
