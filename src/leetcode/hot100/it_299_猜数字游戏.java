package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 *
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 *
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 *
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 *
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 */
public class it_299_猜数字游戏 {
    public static void main(String[] args) {
        String secret="1122";
        String guess="1222";
        String res = new it_299_猜数字游戏().getHint(secret, guess);
        System.out.println(res);
    }

    //使用数组来储存状态
    private String getHint(String secret, String guess) {
        int A=0,B=0;
        int len=secret.length();
        int[] cA=new int[10],cB=new int[10];
        for (int i = 0; i < len; i++) {
            int c=secret.charAt(i)-'0',d=guess.charAt(i)-'0';
            if (c==d){
                A++;
            }else{
                //关键步骤，统计两个在对应位置上的数量
                cA[c]++;
                cB[d]++;
            }
        }
        for (int i = 0; i < 10; i++) {
            B+=Math.min(cA[i],cB[i]);
        }
        return A+"A"+B+"B";
    }

    public String getHint2(String secret, String guess) {
        Map<Character,Integer> map=new HashMap<>();
        int A=0,B=0;
        int len=secret.length();
        for (int i = 0; i < len; i++) {
            char c=secret.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            System.out.println(c+" "+map.get(c));
        }
        for (int i = 0; i < len; i++) {
            char c=secret.charAt(i),d=guess.charAt(i);
            if (c==d){
                A++;
                map.put(c,map.getOrDefault(c,0)-1);
            }
            System.out.println(d+" "+map.get(d));
        }
        for (int i = 0; i < len; i++) {
            char c=secret.charAt(i),d=guess.charAt(i);
            if (c!=d&&map.containsKey(d)&&map.get(d)>0){
                B++;
                map.put(d,map.getOrDefault(d,0)-1);}
        }
        return A+"A"+B+"B";
    }
}
