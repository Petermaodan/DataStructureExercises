package it_19_正则表达;

import java.util.HashMap;

public class Test1_带备忘录的递归解法 {
    public static void main(String[] args) {
        String text="aa";
        String pattern="a*";
        boolean result=new Test1_带备忘录的递归解法().isMatch(text,pattern);
        System.out.println(result);
    }
    HashMap<String,Boolean> memo=new HashMap<>();
    private boolean isMatch(String text, String pattern) {
//        HashMap<String,Boolean> memo=new HashMap<>();
        int i=0;
        int j=0;
        return dp(i,j,text,pattern);
    }

    private boolean dp(int i, int j,String text,String pattern) {
        String key=i+"-"+j;
        boolean ans=false;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if (j==pattern.length()){
            return i==text.length();
        }
        boolean first_match=i<text.length()&&(pattern.charAt(j)==text.charAt(i)||pattern.charAt(j)=='.');
        if (j<=pattern.length()-2&&pattern.charAt(j+1)=='*'){
            ans= dp(i,j+2,text,pattern)||(first_match&&dp(i+1,j,text,pattern));
        }else {
            //同时跳过一个
            ans=first_match&&dp(i+1,j+1,text,pattern);
        }
        memo.put(key,ans);
        return ans;
    }
}
