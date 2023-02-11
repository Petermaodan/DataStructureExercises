package jianzhioffer;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
 * 可以看成任意数字。A 不能视为 14。
 *
 */
public class it_61_扑克牌中的顺子 {
    public static void main(String[] args) {
//        int[] nums={1,2,3,4,5};
        int[] nums={0,0,1,2,6};
        boolean res=new it_61_扑克牌中的顺子().isStraight(nums);
        System.out.println(res);
    }
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker=0;
        for (int i = 0; i < 4; i++) {
            if (nums[i]==0){
                //大小王直接跳过
                joker++;
                continue;
            }else if (nums[i]==nums[i+1]){
                //存在重复
                return false;
            }
        }
        return nums[4]-nums[joker]<5;
    }
}
