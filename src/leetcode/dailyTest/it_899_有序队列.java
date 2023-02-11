package leetcode.dailyTest;

import java.util.Arrays;

/**
 * 给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 *
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "cba", k = 1
 * 输出："acb"
 * 解释：
 * 在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
 * 在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
 *
 * k>1时直接排序即可
 * k=1时需要着重考虑

 */
public class it_899_有序队列 {
    public static void main(String[] args) {
        String s="baaca";
        int k=3;
        String res = new it_899_有序队列().orderlyQueue(s, k);
        System.out.println(res);
    }
    public String orderlyQueue(String s, int k) {
        StringBuilder builder=new StringBuilder(s);
        int n=s.length();
        String ans=s;
        if (k==1){
            for (int i = 0; i < n-1; i++) {
                char c = s.charAt(i);
                builder.deleteCharAt(0);
                builder.append(c);
                if (ans.compareTo(builder.toString())>0){
                    ans=builder.toString();
                }
            }
        }else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            ans=String.valueOf(chars);
        }
        return ans;
    }
}
