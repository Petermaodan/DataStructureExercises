package leetcode.dailyTest;

/**
 * 有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 */
public class it_17_11_单词距离 {
    public static void main(String[] args) {
        String[] words={"I","am","a","student","from","a","university","in","a","city"};
        String word1="a",word2="student";
        int res = new it_17_11_单词距离().findClosest(words, word1, word2);
        System.out.println(res);
    }
    public int findClosest(String[] words, String word1, String word2) {
        if ((words[0].equals(word1)&&words[words.length-1].equals(word2))||(words[0].equals(word2)&&words[words.length-1].equals(word1))){
            return 1;
        }
        int i=-1,j=-1;
        int res=words.length;
        for (int k = 0; k < words.length; k++) {
            if (words[k].equals(word1)){
                i=k;
            }
            if (words[k].equals(word2)){
                j=k;
            }
            if (i!=-1&&j!=-1){
                res=Math.min(res,Math.abs(i-j));
            }
        }
        return res;
    }
}
