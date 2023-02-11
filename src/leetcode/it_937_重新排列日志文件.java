package leetcode;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 *
 * 有两种不同类型的日志：
 *
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 * 示例 1：
 *
 * 输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 解释：
 * 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
 * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
 *
 * 变种的排序
 */
public class it_937_重新排列日志文件 {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] strings = new it_937_重新排列日志文件().reorderLogFiles(logs);
        ListUtil.arrayStringStr(strings);
    }
    public String[] reorderLogFiles(String[] logs) {
        String[] res=new String[logs.length];
        List<Log> list=new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            list.add(new Log(logs[i],i));
        }
        Collections.sort(list,(o1, o2) -> {
            if (o1.type!=o2.type){
                return o1.type-o2.type;
            }
            if (o1.type==1){
                return o1.idx-o2.idx;
            }
            return !o1.content.equals(o2.content)?o1.content.compareTo(o2.content):o1.sign.compareTo(o2.sign);
        });
        for (int i = 0; i < logs.length; i++) {
            res[i]=list.get(i).ori;
        }
        return res;
    }
    class Log{
        int idx;
        int type;
        String ori,sign,content;
        Log(String s,int idx){
            this.idx=idx;
            int n=s.length(),i=0;
            while (i<n&&s.charAt(i)!=' '){
                i++;
            }
            sign=s.substring(0,i);
            content=s.substring(i+1);
            type=Character.isDigit(content.charAt(0))?1:0;
            ori=s;
        }
    }
}
