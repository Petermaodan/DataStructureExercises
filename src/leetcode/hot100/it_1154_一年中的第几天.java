package leetcode.hot100;

/**
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 *
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * 示例 1：
 *
 * 输入：date = "2019-01-09"
 * 输出：9
 */
public class it_1154_一年中的第几天 {
    public static void main(String[] args) {
        String date="2019-01-09";
        int res = new it_1154_一年中的第几天().dayOfYear(date);
        System.out.println(res);
    }
    static int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    static int[] f=new int[12];
    static {
        for (int i = 1; i <=11 ; i++) {
            f[i]=f[i-1]+nums[i-1];
        }
    }

    public int dayOfYear(String date) {
        int ans=0;
        String[] split = date.split("-");
        Integer y=Integer.valueOf(split[0]),m=Integer.valueOf(split[1]),d=Integer.valueOf(split[2]);
        boolean isRun=(y%4==0&&y%100!=0)||y%400==0?true:false;
        int month=m>2&&isRun?f[m-1]+1:f[m-1];
        ans=month+d;
        return ans;
    }
}
