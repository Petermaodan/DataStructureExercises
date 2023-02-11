package niuke;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NC_156_数组中只出现一次的数 {
    public static void main(String[] args) {
        int[] arr={5,4,1,1,5,1,5};
        int k=3;
        int res = new NC_156_数组中只出现一次的数().findOnceNumber2(arr, k);
        System.out.println(res);
    }

    //位运算降低复杂度
    // 每个二进制位求和，如果某个二进制位不能被k整除，那么只出现一次的那个数字在这个二进制位上为1
    public int findOnceNumber2(int[] arr,int k){
        int[] bitSum=new int[32];
        int res=0;
        for (int i = 0; i < 32; i++) {
            int sum=0;
            for (int num:arr){
                if ((num>>i&1)!=0){
                    sum++;
                }
            }
            bitSum[i]=sum;
        }
        for (int i = 0; i < 32; i++) {
            if (bitSum[i]%k!=0){
                res+=1<<i;//左移恢复
            }
        }
        return res;

    }


    public int findOnceNumber(int[] arr,int k){
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }
}
