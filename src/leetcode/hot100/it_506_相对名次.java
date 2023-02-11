package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.*;

/**
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 *
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 */
public class it_506_相对名次 {
    public static void main(String[] args) {
        int[] score={5,1,3,2,4};
        String[] relativeRanks = new it_506_相对名次().findRelativeRanks(score);
        ListUtil.arrayStringStr(relativeRanks);
    }
    public String[] findRelativeRanks(int[] score) {
        int len=score.length;
        Map<Integer,Integer> map=new HashMap<>();
        int[] temp=score.clone();
        Arrays.sort(temp);

        for (int i = len-1; i >=0; i--) {
            int j=len-i;
            map.put(temp[i],j);
        }
        String[] res=new String[len];
        for (int i = 0; i < len; i++) {
            Integer integer = map.get(score[i]);
            if (integer==1){
                res[i]="Gold Medal";
            } else if (integer==2) {
                res[i]="Silver Medal";
            }else if (integer==3){
                res[i]="Bronze Medal";
            }else {
                res[i]=integer+"";
            }
        }
        return res;
    }
}
