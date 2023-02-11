package leetcode.hot100;

/**
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 *
 * 当 s 与 goal 长度 或 词频不同，必然不为亲密字符；
 * 当「s 与 goal 不同的字符数量为 2（能够相互交换）」或「s 与 goal 不同的字符数量为 0，但同时 s 中有出现数量超过 2 的字符（能够相互交换）」时，两者必然为亲密字符。
 *
 */
public class it_859_亲密字符串 {
    public static void main(String[] args) {
        String s="ba";
        String goal="ba";
        boolean res = new it_859_亲密字符串().buddyStrings(s, goal);
        System.out.println(res);
    }

    private boolean buddyStrings(String s, String goal) {
        int m=s.length(),n=goal.length();
        if (m!=n)return false;
        int[] aCount=new int[26],bCount=new int[26];
        int sum=0;
        for (int i = 0; i < m; i++) {
            int tempA=s.charAt(i)-'a',tempB=goal.charAt(i)-'a';
            aCount[tempA]++;
            bCount[tempB]++;
            if (tempA!=tempB)sum++;
        }
        boolean flag=false;
        for (int i = 0; i < 26; i++) {
            if (aCount[i]!=bCount[i])return false;
            if (aCount[i]>1)flag=true;
        }
        return sum==2||(sum==0&&flag);
    }

    //通过测试用例：27 / 34 没有考虑到第二种情况，s与goal不同的字符数量为零，同时存在数量超过2的字符
    public boolean buddyStrings2(String s, String goal) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int i = 0, j = 0;

        while (i < len && chars[i] == goal.charAt(i)) {
            i++;
        }
        j = i+1;
        while (j < len &&chars[j]==goal.charAt(j)){
            j++;
        }
        if (i!=j&&i<len&&j<len){
            swap(chars,i,j);
            System.out.println(String.valueOf(chars));
            return String.valueOf(chars).equals(goal);

        }
        return false;

    }

    private void swap(char[] chars, int i, int j) {
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
}
