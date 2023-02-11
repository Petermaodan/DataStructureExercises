package leetcode.hot100;

/**
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 *
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 *
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *      注意，两个额外的破折号需要删掉。
 *
 */
public class it_482_密钥格式化 {
    public static void main(String[] args) {
        String s="---";
        int k=3;
        String res = new it_482_密钥格式化().licenseKeyFormatting(s, k);
        System.out.println(res);
    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder builder=new StringBuilder();
        int len=s.length();
        int sum=0;
        int i=len-1;
        while (i>=0){
            char c = s.charAt(i);
            if (sum==k){
                builder.append('-');
                sum=0;
                continue;
            }
            if (c!='-'){
                if (c<='z'&&c>='a'){
                    c=Character.toUpperCase(c);
                }
                builder.append(c);
                sum++;
                i--;
            }else {
                i--;
            }
        }
        if (builder.length()!=0&&builder.charAt(builder.length()-1)=='-'){
            builder.deleteCharAt(builder.length()-1);
        }
        return builder.reverse().toString();
    }
}
