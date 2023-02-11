package niuke;

public class NC_1_大数加法 {
    public static void main(String[] args) {
        String s1="1";
        String s2="99";
        String res = new NC_1_大数加法().solve(s1, s2);
        System.out.println(res);

    }

    public String solve (String s, String t) {
        // write code here
        StringBuilder builder=new StringBuilder();
        int i=s.length()-1,j=t.length()-1;
        int carry=0,sum=0;
        while(i>=0||j>=0){
            int temp1=i>=0?s.charAt(i--)-'0':0;
            int temp2=j>=0?t.charAt(j--)-'0':0;
            sum=temp1+temp2+carry;
            builder.append(sum%10);
            carry=sum/10;
        }
        if(carry!=0)builder.append(carry);
        return builder.reverse().toString();
    }
}
