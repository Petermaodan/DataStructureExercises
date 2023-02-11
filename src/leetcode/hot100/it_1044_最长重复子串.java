package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
 *
 * 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
 *
 * 思路，和重复的DNA解法类似，使用字符串哈希解决
 *     //字符串哈希+前缀和
 *     //通过int hash = h[j] - h[i - 1] * p[j - i + 1];构建出哈希值
 *     //假设你要将字符串 abcd hash化成十进制的数，则 a = 1,ab = 12,abc=123,abcd = 1234现在要求
 *     // bcd 即abcd[1,3]的哈希值,是不是1234-1000（等价于 1234-1*10^3)在计算的过程中我们会另外开一个
 *     // 乘方数组记录某一个位置的位数即p数组,上述情况p[0]=1,p[1]=10,p[2]=100,p[3]=1000即
 *     // hash(bcd)=hash(abcd)-hash(a)*p[3-1+1]
 */
public class it_1044_最长重复子串 {
    public static void main(String[] args) {
        String s = "banana";
        String res = new it_1044_最长重复子串().longestDupSubstring(s);
        System.out.println(res);
    }

    long[] sum,p;
    public String longestDupSubstring(String s) {
        int n= s.length(),P=1313131;
        sum= new long[n + 10];
        p= new long[n + 10];
        //创建字符串哈希and前缀和
        p[0]=1;
        for (int i = 0; i < n; i++) {
            sum[i+1]=sum[i]*P+s.charAt(i);
            p[i+1]=p[i]*P;
        }
        String ans="";
        //二分法查找
        int l=0,r=n;
        while (l<r){
            //防止进入死循环，l=1，r=2，可能永远跳不出
            int mid=l+r>>1;
            //判断是否存在重复子串
            String t=check(s,mid);
            if (t.length()==0){
                r=mid;
            }else {
                l=mid+1;
            }
            ans=t.length()>ans.length()?t:ans;
        }
        return ans;
    }

    //字符串哈希核心代码
    private String check(String s, int len) {
        int n=s.length();
        Set<Long> set=new HashSet<>();
        for (int i = 1; i+len-1 <=n ; i++) {
            int j=i+len-1;
            long hash=sum[j]-sum[i-1]*p[j-i+1];
            if (set.contains(hash))return s.substring(i-1,j);
            set.add(hash);
        }
        return "";
    }
}
