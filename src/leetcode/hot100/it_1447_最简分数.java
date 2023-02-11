package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于  n 的 最简 分数 。分数可以以 任意 顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：["1/2"]
 * 解释："1/2" 是唯一一个分母小于等于 2 的最简分数。
 *
 * 如何快速判断两个数组成的分数是否为最简（即判断两个数的最大公约数是否为 1
 *
 * 快速求得 a 和 b 的最大公约数的主要方式有两种 :「更相减损法」和「欧几里得算法」，
 * 其中「欧几里得算法」的递归实现最为好写，复杂度为
 * O(log(a+b))，在绝大多数的情况下适用，只有在需要实现高精度时，才会考虑使用「更相减损法」。
 *
 * 证明方法
 * a可以表示成a = kb + r（a，b，k，r皆为正整数，且r
 * 假设d是a,b的一个公约数，记作d|a,d|b，即a和b都可以被d整除。
 * 而r = a - kb，两边同时除以d，r/d=a/d-kb/d，由等式右边可知m=r/d为整数，因此d|r
 * 因此d也是b,a mod b的公约数。
 * 因(a,b)和(b,a mod b)的公约数相等，则其最大公约数也相等，得证
 *
 *
 */
public class it_1447_最简分数 {
    public static void main(String[] args) {
        int n=4;
        List<String> list = new it_1447_最简分数().simplifiedFractions(n);
        ListUtil.arrayOneString(list);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> res=new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <i ; j++) {
                if (gcd(i,j)==1){
                    res.add(j+"/"+i);
                }
            }
        }
        return res;
    }

    private int gcd(int i, int j) {
        return j==0?i:gcd(j,i%j);
    }
}
