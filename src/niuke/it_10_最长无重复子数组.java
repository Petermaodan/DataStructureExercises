package niuke;

import java.util.HashMap;
import java.util.Map;

public class it_10_最长无重复子数组 {
    public static void main(String[] args) {
        int[] nums={2,3,2,2};
        int res=new it_10_最长无重复子数组().maxLength(nums);
        System.out.println(res);
    }

    public int maxLength (int[] arr) {
        // write code here
        Map<Integer,Integer> window=new HashMap<>();
        int left=0,right=0;
        int res=0;
        while (right<arr.length){
            int c=arr[right];
            //这里，当right指向0的时候，right已经变成1了
            right++;
            window.put(c,window.getOrDefault(c,0)+1);
            while (window.getOrDefault(c,0)>1){
                int d=arr[left];
                left++;
                //更新window
                window.put(d,window.getOrDefault(d,0)-1);
            }
            //当right指向0的时候，right已经变成1了
            res=Math.max(res,right-left);
        }
        return res;
    }
}
