package leetcode.hot100;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 */
public class it_9_回文数 {
    public static void main(String[] args) {
        int x=-121;
        boolean palindrome = new it_9_回文数().isPalindrome(x);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(int x) {
        int tempX=x;
        int res=0;
        while (tempX>0){
            res=res*10+tempX%10;
            tempX/=10;
        }
        System.out.println(res);
        return res==x;
    }
}
