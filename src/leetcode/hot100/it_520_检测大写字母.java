package leetcode.hot100;

/**
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 *
 */
public class it_520_检测大写字母 {
    public static void main(String[] args) {
        String word="QmO";
        boolean res = new it_520_检测大写字母().detectCapitalUse(word);
        System.out.println(res);
    }

    private boolean detectCapitalUse(String word) {
        if (word.toUpperCase().equals(word))return true;
        if (word.toLowerCase().equals(word))return true;
        int len=word.length(),idx=0;
        if (idx<len&&Character.isUpperCase(word.charAt(idx))){
            idx++;
            while (idx<len&&Character.isLowerCase(word.charAt(idx))){
                idx++;
            }
        }
        return idx==len;
    }


    //只能通过539 / 550的数据
    public boolean detectCapitalUse2(String word) {
        int len=word.length();
        int i=0;
        boolean flag=Character.isLowerCase(word.charAt(i))?true:false;
        if (flag){
            while (i<len){
                if (Character.isLowerCase(word.charAt(i))){
                    i++;
                }else {
                    return false;
                }
            }
        }else {
            if (i+1<len&&Character.isUpperCase(word.charAt(i+1))){
                while (i<len){
                    if (Character.isUpperCase(word.charAt(i))){
                        i++;
                    }else {
                        return false;
                    }
                }
            }else if (i+1<len&&Character.isLowerCase(word.charAt(i+1))){
                while (i<len){
                    if (Character.isLowerCase(word.charAt(i))){
                        i++;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
