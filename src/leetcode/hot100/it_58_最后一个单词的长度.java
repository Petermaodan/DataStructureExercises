package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

public class it_58_最后一个单词的长度 {
    public static void main(String[] args) {
        String s="   fly me   to   the moon  ";
        int res = new it_58_最后一个单词的长度().lengthOfLastWord(s);
        System.out.println(res);
    }


    //反向遍历
    public int lengthOfLastWord(String s){
        int end=s.length()-1;
        while (end>=0&&s.charAt(end)==' ')end--;
        int start=end;
        while (start>=0&&s.charAt(start)!=' ')start--;
        return end-start;
    }

//    public int lengthOfLastWord(String s) {
//        List<String> list=new ArrayList<>();
//        int i=0,j=0;
//        int len=s.length();
//        while (j<len){
//            while (j<len&&s.charAt(j)!=' '){
//                j++;
//            }
//            if (i!=j){
//                list.add(s.substring(i,j));
//            }
//
//            j++;
//            i=j;
//        }
//        return list.get(list.size()-1).length();
//    }
}
