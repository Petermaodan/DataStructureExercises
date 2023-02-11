package leetcode.hot100;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class it_647_回文子串 {
    public static void main(String[] args) {
        String s="aaa";
        int res=new it_647_回文子串().countSubstrings(s);
        System.out.println(res);

    }

    //中心扩散法
    //关键点，中心不能只有单个字符构成，还要包括两个字符，所以一共有2*len-1个中心点
    public int countSubstrings(String s){
        int ans=0;
        int n=s.length();
        for (int center = 0; center < 2*n-1; center++) {
            //关键左右指针指的位置
            //right和left相同（偶数）或right=left+1（奇数）
            int left=center/2;
            int right=left+center%2;
            while (left>=0&&right<n&&s.charAt(left)==s.charAt(right)){
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }

    public int countSubstrings2(String s) {
        int n=s.length();
        boolean[][] dp= new boolean[n][n];
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][i]=true;
        }
        int count=n;
        for (int i = n-1; i >=0; i--) {
            for (int j = i+1; j < n; j++) {
                if (s.charAt(i)==s.charAt(j)&&(j-i<2||dp[i+1][j-1])){
                    dp[i][j]=true;
                    count++;
                }
            }
        }
        return count;
    }
}
