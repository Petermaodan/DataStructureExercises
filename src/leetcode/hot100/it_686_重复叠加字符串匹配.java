package leetcode.hot100;

/**
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 * 示例 1：
 *
 * 输入：a = "abcd", b = "cdabcdab"
 * 输出：3
 * 解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
 *
 * 对于「下界」的分析是容易的：至少将 a 复制长度大于等于 b 的长度，才有可能匹配。
 *
 * 在明确了「下界」后，再分析再经过多少次复制，能够明确得到答案，能够得到明确答案的最小复制次数即是上界。
 *
 * 由于主串是由 a 复制多次而来，并且是从主串中找到子串 b，因此可以明确子串的起始位置，不会超过 a 的长度。
 *
 */
public class it_686_重复叠加字符串匹配 {
    public static void main(String[] args) {
        String a="abcd";
        String b="cdabcdabcdab";
        int res = new it_686_重复叠加字符串匹配().repeatedStringMatch(a, b);
        System.out.println(res);
    }

    //KMP算法，实际上就是字符串字串匹配的问题
    private int repeatedStringMatch(String a, String b) {
        return 0;
    }


    public int repeatedStringMatch2(String a, String b) {
        StringBuilder builder=new StringBuilder();
        int ans=0;
        while (builder.length()<b.length()&&++ans>0)builder.append(a);
        //a需要多复制一次，这样才能确保b一定是子集
        builder.append(a);
        int idx=builder.indexOf(b);
        if (idx==-1)return -1;
        //这里需要判断是否超过下届
        return idx+b.length()>a.length()*ans?ans+1:ans;

    }
}
