package leetcode.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * 示例 1：
 * 输入：s = "owoztneoer"
 * 输出："012"
 *
 * 思路：
 * 我们可以先对 s 进行词频统计，然后根据「英文单词中的字符唯一性」确定构建的顺序，最后再对答案进行排序即可。
 *
 * 具体的，zero 中的 z 在其余所有单词中都没出现过，我们可以先统计 zero 的出现次数，并构建 00；然后观察剩余数字，其中 eight 中的 g 具有唯一性，构建 88；再发现 six 中的 x 具有唯一性，构建 66；发现 three 中的 h 具有唯一性（利用在此之前 eight 已经被删除干净，词频中仅存在 three 对应的 h)，构建 33 ...
 *
 * 最终可以确定一个可行的构建序列为 0, 8, 6, 3, 2, 7, 5, 9, 4, 1。
 *

 */
public class it_423_从英文中重建数字 {
    public static void main(String[] args) {
        String s="owoztneoer";
        String res = new it_423_从英文中重建数字().originalDigits(s);
        System.out.println(res);
    }

    static String[] number={"zero","one","two","three","four","five","six","seven","eight","nine"};
    static int[] num={0,8,6,3,2,7,5,9,4,1};
    public String originalDigits(String s) {
        //先统计词频

        List<Integer> res=new ArrayList<>();

        char[] chars = s.toCharArray();
        int[] countN=new int[26];
        for (char c : chars) {
            countN[c-'a']++;
        }
        //按可行的序列构建出答案
        for (int i : num) {
            //统计组成一个可行数字英文的个数
            int k=Integer.MAX_VALUE;
            char[] chars1 = number[i].toCharArray();
            for (char c : chars1) {
                k=Math.min(k,countN[c-'a']);
            }
            //将能够组成的单词从词频中剔除
            for (char c : chars1) {
                countN[c-'a']-=k;
            }
            //统计k的次数
            while (k>0){
                res.add(i);
                k--;
            }
        }
        Collections.sort(res);
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i <res.size(); i++) {
            builder.append(res.get(i));
        }
        return builder.toString();
    }
}
