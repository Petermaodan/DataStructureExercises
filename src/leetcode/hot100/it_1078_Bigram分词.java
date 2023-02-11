package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 *
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * 示例 1：
 *
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 */
public class it_1078_Bigram分词 {
    public static void main(String[] args) {
        String text = "alice is a good girl she is a good student", first = "a", second = "good";
        String[] ocurrences = new it_1078_Bigram分词().findOcurrences(text, first, second);
        ListUtil.arrayStringStr(ocurrences);

    }
    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        List<String> list=new ArrayList<>();
        int len=s.length;
        for (int i = 0,j=1; i <len-1 ; i++,j++) {
            int k=j+1;
            if (s[i].equals(first)&&s[j].equals(second)&&k<len){
                list.add(s[k]);
            }
        }
        int n=list.size();
        String[] res=new String[n];
        for (int i = 0; i < n; i++) {
            res[i]=list.get(i);
        }
        return res;

    }
}
