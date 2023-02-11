package leetcode.hot100;

/**
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * 示例 1：
 * 输入：nums = [1,2,3,3]
 * 输出：3

 */
public class it_961_在长度2N的数组中找出重复N次的元素 {
    public int repeatedNTimes(int[] nums) {
        int[] count=new int[10010];
        for (int num : nums) {
            if (++count[num]>1){
                return num;
            }
        }
        return -1;

    }
}
