package leetcode.dailyTest;

import BaseUtil.ListUtil;

/**
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 *
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 */
public class it_942_增减字符串匹配 {
    public static void main(String[] args) {
        String s = "IDID";
        int[] ints = new it_942_增减字符串匹配().diStringMatch(s);
        ListUtil.arrayOneNums(ints);
    }
    public int[] diStringMatch(String s) {
        int l=0,r=s.length(),index=0;
        int[] res=new int[r+1];
        for (int i = 0; i < s.length(); i++) {
            res[index++]=s.charAt(i)=='I'?l++:r--;
        }
        res[index]=l;
        return res;
    }
}
