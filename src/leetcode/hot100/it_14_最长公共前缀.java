package leetcode.hot100;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 */
public class it_14_最长公共前缀 {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        String res = new it_14_最长公共前缀().longestCommonPrefix(strs);
        System.out.println(res);
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder builder=new StringBuilder();
        int len=strs[0].length();
        for (int i = 0; i < len; i++) {
            char temp=strs[0].charAt(i);
            boolean flag=false;
            for (String str : strs) {
                if (i<str.length()&&str.charAt(i)==temp){
                    continue;
                }else {
                    flag=true;
                    break;
                }
            }
            if (!flag){
                builder.append(temp);
            }else {
                break;
            }
        }
        return builder.toString();
    }
}
