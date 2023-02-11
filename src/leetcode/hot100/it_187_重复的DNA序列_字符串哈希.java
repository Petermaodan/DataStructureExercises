package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.*;

/**
 * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。
 * 在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
 *
 */
public class it_187_重复的DNA序列_字符串哈希 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> list = new it_187_重复的DNA序列_字符串哈希().findRepeatedDnaSequences(s);
        ListUtil.arrayOneString(list);
    }

    //字符串哈希+前缀和
    //通过int hash = h[j] - h[i - 1] * p[j - i + 1];构建出哈希值
    //假设你要将字符串 abcd hash化成十进制的数，则 a = 1,ab = 12,abc=123,abcd = 1234现在要求
    // bcd 即abcd[1,3]的哈希值,是不是1234-1000（等价于 1234-1*10^3)在计算的过程中我们会另外开一个
    // 乘方数组记录某一个位置的位数即p数组,上述情况p[0]=1,p[1]=10,p[2]=100,p[3]=1000即
    // hash(bcd)=hash(abcd)-hash(a)*p[3-1+1]
    int N=(int)1e5+10,P=131313;
    int[] sum=new int[N],p=new int[N];
    public List<String> findRepeatedDnaSequences(String s) {
        int n=s.length();
        List<String> ans=new ArrayList<>();
        p[0]=1;
        //创建前缀和数组
        for (int i = 1; i <=n ; i++) {
            sum[i]=sum[i-1]*P+s.charAt(i-1);
            p[i]=p[i-1]*P;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 1; i+10-1 <=n ; i++) {
            int j=i+10-1;
            //关键步骤
            int hash=sum[j]-sum[i-1]*p[j-i+1];
            int count=map.getOrDefault(hash,0);
            if (count==1)ans.add(s.substring(i-1,j));
            map.put(hash,count+1);
        }
        return ans;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        Set<String> set=new HashSet<>();
        Set<String> tempSet=new HashSet<>();
        List<String> res=new ArrayList<>();
        int left=0,right=10;
        int len=s.length();
        while (right<=len){
            String temp=s.substring(left,right);
            if (set.contains(temp)){
                tempSet.add(temp);
            }else {
                set.add(temp);
            }
            left++;
            right++;
        }
        for (String s1 : tempSet) {
            res.add(s1);
        }
        return res;

    }
}
