package leetcode.dailyTest;

/**
 * 把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
 *
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." . 
 * 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。 

 * 示例 1:
 *
 * 输入: p = "a"
 * 输出: 1
 * 解释: 字符串 s 中只有一个"a"子字符。
 * 示例 2:
 *
 * 输入: p = "cac"
 * 输出: 2
 * 解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.

 */
public class it_467_环绕字符串中唯一的子字符串 {
    public static void main(String[] args) {
        String p = "zab";
        int res = new it_467_环绕字符串中唯一的子字符串().findSubstringInWraproundString(p);
        System.out.println(res);
    }

    public int findSubstringInWraproundString(String p) {
        /**
         统计以每个字符作为结尾的最长连续序列(可以覆盖掉重复的短序列的情况), 他们的和即为所求
         例如:abcdbcd, 对于以d结尾的有abcd, bcd, cd和d, 而bcd产生的序列都会被abcd所覆盖
         总和即以a、b、c和d结尾的所有连续最长序列1 + 2 + 3 + 4 = 10
         **/
        int n=p.length();
        char[] chars = p.toCharArray();
        int maxLen=1;
        //用于统计不同单词结尾所对应的子字符串数量
        //对于以d结尾的有abcd,以d结尾有4种情况
        int[] count=new int[26];
        for (int i = 0; i <n; i++) {
            if (i>0&&(chars[i]-chars[i-1]==1||chars[i]-chars[i-1]==-25)){
                maxLen++;
            }else {
                maxLen=1;
            }
            count[chars[i]-'a']=Math.max(maxLen,count[chars[i]-'a']);
        }
        int res=0;
        for (int temp : count) {
            res+=temp;
        }
        return res;
    }
}
