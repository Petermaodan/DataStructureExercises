package niuke;

import BaseUtil.ListUtil;

import java.util.Arrays;

public class moni3_牛牛魔法师 {

    public static void main(String[] args) {
        int[] h={3,1,4,5,3,5,9,45,68};
        int[] res=new moni3_牛牛魔法师().Magical_NN(h);
        ListUtil.arrayOneNums(res);
    }

    public int[] Magical_NN (int[] h) {
        // write code here
        int[] tmp=new int[h.length];
//        int[] tmp= Arrays.copyOf(h,h.length);
        for (int i = 0; i < h.length; i++) {
            int res=0;
            for (int j = 0; j < h.length; j++) {
                res+=Math.abs(h[i]-h[j]);
            }
            tmp[i]=res;
        }
        return tmp;
    }
}
