package leetcode.moni;

public class moni_5193_删除字符使字符串变好 {
    public static void main(String[] args) {
        String s="aaabaaaa";
        String res = new moni_5193_删除字符使字符串变好().makeFancyString(s);
        System.out.println(res);


    }
    public String makeFancyString(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length();
        int i=0,j=0;
        char temp=' ';
        while (j<n){

            while (j<n&&temp==s.charAt(j)&&j-i>=2){
                j++;
            }
            if (j>=n&&s.charAt(j-1)==s.charAt(j-2)){
                break;
            }else if (j>=n){
                sb.append(s.charAt(j-1));
            }
            if (j-i>=3||s.charAt(i)!=temp){
                i=j;
                sb.append(s.charAt(j));
            }else {
                sb.append(s.charAt(j));
            }
            temp=s.charAt(j);
            j++;

        }
        return sb.toString();
    }
}
