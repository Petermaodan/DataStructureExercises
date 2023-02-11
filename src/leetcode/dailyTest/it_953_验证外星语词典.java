package leetcode.dailyTest;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 *
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * 示例 1：
 *
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 *
 * 只需要比较相邻两个单词是否满足要求即可
 */
public class it_953_验证外星语词典 {
    public static void main(String[] args) {
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean res = new it_953_验证外星语词典().isAlienSorted(words, order);
        System.out.println(res);
    }

    int[] ord;
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length==1){
            return true;
        }
        ord=new int[26];
        for (int i = 0; i < order.length(); i++) {
            ord[order.charAt(i)-'a']=i;
        }
        for (int i = 0; i < words.length-1; i++) {
            if (!check(words[i],words[i+1])){
                return false;
            }
        }
        return true;
    }

    private boolean check(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        int i=0,j=0;
        while (i<n&&j<m){
            if (ord[word1.charAt(i)-'a']!=ord[word2.charAt(j)-'a']){
                return ord[word1.charAt(i)-'a']<ord[word2.charAt(j)-'a'];
            }
            i++;
            j++;
        }
        if (i<n){
            return false;
        }
        return true;
    }
}
