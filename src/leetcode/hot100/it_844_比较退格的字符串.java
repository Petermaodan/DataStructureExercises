package leetcode.hot100;

public class it_844_比较退格的字符串 {
    public static void main(String[] args) {
        String s="####ab##";
        String t="###cc##";
        boolean res=backspaceCompare(s,t);
        System.out.println(res);
    }
    public static boolean backspaceCompare(String s, String t) {
       return build(s).equals(build(t));

    }
    public static String build(String s){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)!='#'){
                sb.append(s.charAt(i));
            }else {
                if (sb.length()>0) {
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }
}
