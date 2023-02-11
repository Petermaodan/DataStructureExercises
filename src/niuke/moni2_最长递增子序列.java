package niuke;

/**
 * 抽象的递增子序列，不能用传统的动态规划解决
 */
public class moni2_最长递增子序列 {

    public static void main(String[] args) {
//        String n="110328324";
        String n="5";
        int res=new moni2_最长递增子序列().NS_LIS(n);
        System.out.println(res);
    }

    public int NS_LIS (String n) {
        // write code here

        int len=n.length();
        int res1=(len-1)*9+Integer.valueOf(n.charAt(0))-49;


        int res2=0;
        for (int i = 0; i < len; i++) {
            int tmp=Integer.valueOf(n.charAt(i))-48;
            res2+=tmp;
        }
        return Math.max(res1,res2);
    }
}
