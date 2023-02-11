package it_16_编辑距离;

import java.util.HashMap;
import java.util.Map;

public class Test1_递归 {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        int result=new Test1_递归().minDistance(word1,word2);
        System.out.println(result);
    }

    Map<String, Integer> memo = new HashMap<>();

    public int minDistance(String word1, String word2) {

        int i = word1.length();
        int j = word2.length();

        return dp(word1, word2, i-1, j-1);
    }
    private int dp(String word1, String word2, int i, int j) {
        String s = i + "+" + j;

        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        //base case:
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;

        if (word1.charAt(i) == word2.charAt(j)) {
            memo.put(s, dp(word1, word2, i - 1, j - 1));
        } else {
            memo.put(s, Math.min(Math.min(dp(word1, word2, i, j - 1) + 1
                    , dp(word1, word2, i - 1, j) + 1)
                    , dp(word1, word2, i - 1, j - 1) + 1));
        }
        return memo.get(s);
    }
}
