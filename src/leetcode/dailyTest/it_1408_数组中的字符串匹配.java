package leetcode.dailyTest;

import java.util.ArrayList;
import java.util.List;

public class it_1408_数组中的字符串匹配 {
    public List<String> stringMatching(String[] words) {
        int len=words.length;
        List<String> res=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i==j){
                    continue;
                }
                if (words[j].indexOf(words[i])>=0){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }


}
