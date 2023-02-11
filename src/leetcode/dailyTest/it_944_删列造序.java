package leetcode.dailyTest;

/**
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 *
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 *
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序升序排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 *
 * 返回你需要删除的列数。
 **/
public class it_944_删列造序 {
    public static void main(String[] args) {
//        String[] strs = {"zyx","wvu","tsr"};
        String[] strs = {"a","b","c"};
        int res = new it_944_删列造序().minDeletionSize(strs);
        System.out.println(res);
    }
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        if (n==1){
            return 0;
        }
        int res=0;
        for (int i = 0; i < strs[0].length(); i++) {
            int l=0,r=1;
            while (r<n){
                if (strs[l].charAt(i)>strs[r].charAt(i)){
                    res++;
                    break;
                }
                l++;
                r++;
            }
        }
        return res;
    }
}
