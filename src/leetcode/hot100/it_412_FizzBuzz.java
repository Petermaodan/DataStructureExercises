package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 *
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i 如果上述条件全不满足。
 *
 */
public class it_412_FizzBuzz {
    public static void main(String[] args) {
        int n=5;
        List<String> list = new it_412_FizzBuzz().fizzBuzz(n);
        ListUtil.arrayOneString(list);
    }

    public List<String> fizzBuzz(int n) {
        List<String> res=new ArrayList<>();
        int i=1;
        while (i<=n){
            if ((i%3==0)&&(i%5==0)){
                res.add("FizzBuzz");
            }else if (i%3==0){
                res.add("Fizz");
            }else if (i%5==0){
                res.add("Buzz");
            }else {
                res.add(i+"");
            }
            i++;
        }
        return res;
    }
}
