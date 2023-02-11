package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 *
 * 使用回溯的方法求解
 */
public class it_93_复原IP地址 {
    public static void main(String[] args) {
       String s = "25525511135";
        List<String> list = new it_93_复原IP地址().restoreIpAddresses(s);
        ListUtil.arrayOneString(list);
    }


    static final int SEG_COUNT=4;
    List<String> res=new ArrayList<>();
    //直接用segments[]的数组来表示track
    int[] segments=new int[SEG_COUNT];
    public List<String> restoreIpAddresses(String s) {
        backtrack(s,0,0);
        return res;
    }

    private void backtrack(String s, int segId, int segStart) {
        //满足条件，则添加到集合中
        if (segId==SEG_COUNT&&segStart==s.length()){
            StringBuilder builder=new StringBuilder();
            for (int i = 0; i < SEG_COUNT; i++) {
                builder.append(segments[i]);
                if (i!=SEG_COUNT-1){
                    builder.append('.');
                }
            }
            res.add(builder.toString());
            //跳出递归
            return;
        }


        //若segStart满了，但是segId不达标，直接返回,或者segId满了，但是segStart还没到最后
        if (segStart==s.length()||segId==SEG_COUNT){
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart)=='0'){
            segments[segId]=0;
            backtrack(s,segId+1,segStart+1);
        }
        //通常情况
        int temp=0;
        for (int i = segStart; i <s.length(); i++) {
            temp=temp*10+(s.charAt(i)-'0');
            //满足条件就进入下一个递归
            if (temp>0&&temp<=255){
                segments[segId]=temp;
                backtrack(s,segId+1,i+1);
            }else {
                break;
            }
        }
    }
}
