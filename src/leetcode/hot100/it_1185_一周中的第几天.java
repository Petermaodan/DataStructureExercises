package leetcode.hot100;

/**
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 */
public class it_1185_一周中的第几天 {
    public static void main(String[] args) {
        int day = 18, month = 7, year = 1999;
        String res = new it_1185_一周中的第几天().dayOfTheWeek(day, month, year);
        System.out.println(res);
    }

    static String[] ss = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    static int[] nums = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        //题目保证日期是在 1971 到 2100 之间，我们可以计算给定日期距离 1970 的最后一天（星期四）间隔了多少天，从而得知给定日期是周几。
        int ans=4;
        //统计天数
        for (int i = 1971; i < year; i++) {
            //区别闰年还是平年
            boolean flag=(i%4==0&&i%100!=0)||i%400==0;
            ans+=flag?366:365;
        }
        //统计月
        for (int i = 1; i < month; i++) {
            ans+=nums[i-1];
            if (i==2&&((year%4==0&&year%100!=0)||year%400==0)){
                ans++;
            }
        }
        //统计day
        ans+=day;
        return ss[ans%7];
    }
}
