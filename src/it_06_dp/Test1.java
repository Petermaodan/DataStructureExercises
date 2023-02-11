package it_06_dp;

/**
 * 错误答案
 * N=45
 * 实际：1134903170
 * 预期：134903163
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1=new Test1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = test1.fib(n);
        System.out.println(result);
    }

    HashMap<String, Integer> hashMap = new HashMap<>();

    private  int fib(int N) {
        if (N < 1) {
            return 0;
        }
//        Vector<Integer> memo=new Vector<>(N+1,0);
        return helper(N);
    }

    private  int helper(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        String key = String.valueOf(n);
        if (hashMap.containsKey(key)){
            return hashMap.get(key);
        }
//要进行取余操作
        int result=(helper(n-1)+helper(n-2))%1000000007;
        hashMap.put(key,result);
        return result;
    }

}
