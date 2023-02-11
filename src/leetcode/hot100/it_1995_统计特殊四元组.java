package leetcode.hot100;

import java.util.Arrays;

/**
 * 给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 *
 * nums[a] + nums[b] + nums[c] == nums[d] ，且
 * a < b < c < d
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,6]
 * 输出：1
 * 解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
 *
 */
public class it_1995_统计特殊四元组 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,5};
        int res = new it_1995_统计特殊四元组().countQuadruplets(nums);
        System.out.println(res);
    }
    
    //利用等式关系 nums[a] + nums[b] + nums[c] = nums[d]
    //，可以调整枚举 c的顺序为「逆序」，每次 c 往左移动一个单位，d 的可取下标范围增加一个
    // （即 c+1 位置)，使用数组代替哈希表对 nums[d] 的个数进行统计，可使复杂度下降到 O(n^3)。
    private int countQuadruplets(int[] nums) {
        //使用哈希表降低复杂度
        int n=nums.length,ans=0;
        int[] hash=new int[10010];
        for (int c = n-2; c >=2 ; c--) {
            hash[nums[c+1]]++;
            //限制a，b小于c
            for (int a = 0; a < n; a++) {
                for (int b = a+1; b <c ; b++) {
                    ans+=hash[nums[a]+nums[b]+nums[c]];
                }
            }
        }
        return ans;
    }

    
    public int countQuadruplets2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length,ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    for (int l = k+1; l < n; l++) {
                        if (nums[i]+nums[j]+nums[k]==nums[l]){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
