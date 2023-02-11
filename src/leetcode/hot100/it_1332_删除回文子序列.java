package leetcode.hot100;

/**
 * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
 *
 * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
 *
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
 *
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 *
 * 因为本身就是由a，b两个字母组成，所以最大的操作次数必然不超过两次
 */
public class it_1332_删除回文子序列 {
    public static void main(String[] args) {
        String s="ababa";
        int res = new it_1332_删除回文子序列().removePalindromeSub(s);
        System.out.println(res);
    }

    public int removePalindromeSub(String s) {
        if (s.equals("")){
            return 0;
        }
        int n=s.length();
        int idx=n/2;
        if ((n%2==0&&checkS(s,idx-1,idx)||(n%2==1&&checkS(s,idx,idx)))){
            return 1;
        }
        return 2;

    }

    public boolean checkS(String s,int i,int j){
        int n=s.length();
        while (i>=0&&j<n){
            if (s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }else {
                return false;
            }
        }
        return true;
    }
}
