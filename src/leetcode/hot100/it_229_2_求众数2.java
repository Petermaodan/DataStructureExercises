package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 */
public class it_229_2_求众数2 {
    public static void main(String[] args) {
        int[] nums={2,1,1,3,1,4,5,6};
        List<Integer> list = new it_229_2_求众数2().majorityElement2(nums);
        ListUtil.arrayOne(list);
    }


    //方法二，摩尔投票法优化，这道题是摩尔投票法的升级

    /**
     * 如果至多选一个代表，那他的票数至少要超过一半（⌊ 1/2 ⌋）的票数；
     *
     * 如果至多选两个代表，那他们的票数至少要超过 ⌊ 1/3 ⌋ 的票数；
     *
     * 如果至多选m个代表，那他们的票数至少要超过 ⌊ 1/(m+1) ⌋ 的票数。
     *
     * 所以以后碰到这样的问题，而且要求达到线性的时间复杂度以及常量级的空间复杂度，直接套上摩尔投票法。
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement2(int[] nums){
        List<Integer> res=new ArrayList<>();
        //创建两个候选人以及其对应的票数
        int cond1=nums[0],count1=0;
        int cond2=nums[0],count2=0;

        //开始操作计票
        for (int num : nums) {
            if (cond1==num){
                count1++;
                continue;
            }
            if (cond2==num){
                count2++;
                continue;
            }

            //判断当有一个票数为零是，遇到新的元素需要改变候选人
            if (count1==0){
                cond1=num;
                count1++;
                continue;
            }
            if (count2==0){
                cond2=num;
                count2++;
                continue;
            }
            //若票数均不为零遇到新的候选人,则票数同时减
            count1--;
            count2--;
        }
        //找到两个候选人之后需要再次判断票数是否超过三分之一
        count1=0;
        count2=0;
        for (int num : nums) {
            if (cond1==num){
                count1++;
            }else if (cond2==num){
                count2++;
            }
        }
        if (count1>nums.length/3)res.add(cond1);
        if (count2>nums.length/3)res.add(cond2);

        return res;
    }

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        int count=nums.length/3;
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
            if (!res.contains(num)&&map.get(num)>count){
                res.add(num);
            }
        }
        return res;
    }
}
