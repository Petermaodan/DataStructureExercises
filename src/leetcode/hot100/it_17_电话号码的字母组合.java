package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母处。
 */
public class it_17_电话号码的字母组合 {

    public static void main(String[] args) {

        List<String> res=new it_17_电话号码的字母组合().letterCombinations("45");
        for (String re : res) {
            System.out.print(re+"--");
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations=new ArrayList<>();
        if (digits.length()==0){
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        backtrack(combinations,phoneMap,digits,0,new StringBuilder());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder combination) {
        if (index==digits.length()){
            combinations.add(combination.toString());
        }else {
            //得到第index对应的字符
            char digit=digits.charAt(index);
            //得到第index对应的字符在键盘上对应的value
            String letters=phoneMap.get(digit);
            int lettersCount=letters.length();
            for (int i = 0; i < lettersCount; i++) {
                //选择
                combination.append(letters.charAt(i));
                //回溯
                backtrack(combinations,phoneMap,digits,index+1,combination);
                //撤销选择
                combination.deleteCharAt(index);
            }
        }

    }
}
