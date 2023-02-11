package jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 */
public class it_56_2_数组中数字出现的次数2 {
    public static void main(String[] args) {
        int[] nums={9,1,7,9,7,9,7};
        int res = new it_56_2_数组中数字出现的次数2().singleNumber(nums);
        System.out.println(res);
    }
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for (Integer getKey : map.keySet()) {
            if (map.get(getKey)==1){
                return getKey;
            }
        }
        return -1;
    }
}
