package leetcode.hot100;

/**
 * 累加数 是一个字符串，组成它的数字可以形成累加序列。
 *
 * 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。
 *
 * 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
 *
 * 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
 * 示例 1：
 *
 * 输入："112358"
 * 输出：true
 * 解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * 思路：
 * 我们每次取一小段，把它转换成一个数，如果前面已经有两个数了，我们比较它与前两数之和的结果，如果前面没有两个数或者比较结果相等，我们继续向下一层探索。
 *
 * 另外，提示中约定了 1 <= num.length <= 35，所以，我们可以使用 long 类型来存储每个数。
 *
 */
public class it_306_累加数 {
    public static void main(String[] args) {
        String num="199100199";
        boolean additiveNumber = new it_306_累加数().isAdditiveNumber(num);
        System.out.println(additiveNumber);
    }
    public boolean isAdditiveNumber(String num) {
        return dfs(num,0,0,0,0);
    }

    private boolean dfs(String num, int idx, int count, long prev, long prePrev) {
        int n=num.length();
        //跳出循环
        if (idx>=n){
            return count>2;
        }
        long curSum=0;
        for (int i = idx; i < n; i++) {
            char c = num.charAt(i);
            //判断是否为前导零
            if (num.charAt(idx)=='0'&&i>idx){
                return false;
            }
            curSum=curSum*10+c-'0';
            //超过两个数才进入这一层
            if (count>=2){

                //如果太大，就直接排除
                long tempSum=prev+prePrev;
                if (curSum>tempSum){
                    return false;
                }
                //如果太小就加入新的字符
                if (curSum<tempSum){
                    continue;
                }

            }
            if (dfs(num,i+1,count+1,curSum,prev)){
                return true;
            }
        }
        return false;
    }
}
