package leetcode.dailyTest;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * 示例 1:
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True

 */
public class it_01_05_一次编辑_双指针 {
    public static void main(String[] args) {
        String first = "pales";
        String second = "pale";
        boolean res = new it_01_05_一次编辑_双指针().oneEditAway(first, second);
        System.out.println(res);
    }
    public boolean oneEditAway(String first, String second) {
        int n=first.length(),m=second.length();
        if (Math.abs(n-m)>1)return false;
        if (n>m){
            return oneEditAway(second,first);
        }
        int i=0,j=0,crt=0;
        while (i<n&&j<m&&crt<=1){
            char c=first.charAt(i),d=second.charAt(j);
            if (c==d){
                i++;
                j++;
            }else {
                if (n==m){
                    i++;
                    j++;
                    crt++;
                }else {
                    j++;
                    crt++;
                }
            }
        }
        return crt<=1;
    }
}
