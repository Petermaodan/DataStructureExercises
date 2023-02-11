package jianzhioffer;

public class it_67_把字符串转换成整数 {
    public static void main(String[] args) {
        String s="-42";
        int res=strToInt(s);
        System.out.println(res);
    }


    public static int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length==0)return 0;
        int sign=1,res=0;
        int i=1;
        int max=Integer.MAX_VALUE/10;
        if (chars[0]=='-')sign=-1;
        else if (chars[0]!='+')i=0;
        for (int j= i; j < chars.length; j++) {
            char c=chars[j];
            if (c>'9'||c<'0')break;
            if (res>max||res==max&&c>'7')return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            res=res*10+(c-'0');
        }
        return sign*res;
    }
}
