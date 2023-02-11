package leetcode.dailyTest;

/**
 * 给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。
 * <p>
 * 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
 * <p>
 * 示例：
 * <p>
 * 输入: [1000,100,10,2]
 * 输出: "1000/(100/10/2)"
 * 解释:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * 但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
 * 因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
 */
public class it_553_最优除法 {
    public static void main(String[] args) {
        int[] nums={1000,100,10,2};
        String s = new it_553_最优除法().optimalDivision(nums);
        System.out.println(s);
    }
    public String optimalDivision(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1) {
                builder.append(nums[i]).append('/');
            }else {
                builder.append(nums[i]);
            }

        }
        if (nums.length > 2) {
            builder.insert(builder.indexOf("/") + 1, '(');
            builder.append(')');
        }
        return builder.toString();
    }
}
