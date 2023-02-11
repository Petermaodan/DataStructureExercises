package DailyTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 上面的例子 123+912123+912，我们把它表示成 [1,2,3+912][1,2,3+912]。
 * 然后，我们计算 3+912=9153+912=915。55 留在当前这一位，将 910/10=91910/10=91 以进位的形式加入下一位。
 *
 * 然后，我们再重复这个过程，计算 [1,2+91,5][1,2+91,5]。
 * 我们得到 9393，33 留在当前位，将 90/10=990/10=9 以进位的形式加入下一位。
 * 继而又得到 [1+9,3,5][1+9,3,5]，重复这个过程之后，最终得到结果 [1,0,3,5][1,0,3,5]
 *
 */
public class Test1_数组形式的整数加法 {
    public static void main(String[] args) {
        int[] nums={9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
        int k=1;
        List<Integer> list=new Test1_数组形式的整数加法().addToArrayForm(nums,k);
        for (Integer i : list) {
            System.out.print(i);
        }

    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res=new ArrayList<>();
        int n=A.length;
        for (int i=n-1;i>=0||K>0;i--,K/=10){
            if (i>=0){
                K+=A[i];
            }
            res.add(K%10);
        }
        //由于是位数小的先添加入列表，所以最终要对列表进行反转
        Collections.reverse(res);
        return res;
    }
}
