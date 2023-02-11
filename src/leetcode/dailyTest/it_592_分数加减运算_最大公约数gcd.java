package leetcode.dailyTest;

/**
 * 给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
 *
 * 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为 2/1。

 * 示例 1:
 *
 * 输入: expression = "-1/2+1/2"
 * 输出: "0/1"

 */
public class it_592_分数加减运算_最大公约数gcd {
    public static void main(String[] args) {
        String expression = "-1/2+1/2+1/3";
        String res = new it_592_分数加减运算_最大公约数gcd().fractionAddition(expression);
        System.out.println(res);
    }
    public String fractionAddition(String expression) {
        int n=expression.length();
        char[] chars = expression.toCharArray();
        int i=0;
        String ans="";
        while (i<n){
            int j=i+1;
            while (j<n&&chars[j]!='+'&&chars[j]!='-'){
                j++;
            }
            String num=expression.substring(i,j);
            if (num.charAt(0)!='+'&&num.charAt(0)!='-'){
                num="+"+num;
            }
            if (!ans.equals("")){
                ans=calc(num,ans);
            }else {
                ans=num;
            }
            i=j;
        }
        return ans.charAt(0)=='+'?ans.substring(1):ans;
    }

    private String calc(String a, String b) {
        boolean fa=a.charAt(0)=='+',fb=b.charAt(0)=='+';
        if (!fa&&fb){
            return calc(b,a);
        }
        long[] p=parse(a),q=parse(b);
        long p1=p[0]*q[1],q1=q[0]*p[1];
        if (fa&&fb){
            long r1=p1+q1,r2=p[1]*q[1],c=gcd(r1,r2);
            return "+"+(r1/c)+"/"+(r2/c);
        }else if (!fa&&!fb){
            long r1=p1+q1,r2=p[1]*q[1],c=gcd(r1,r2);
            return "-"+(r1/c)+"/"+(r2/c);
        }else {
            long r1=p1-q1,r2=p[1]*q[1],c=gcd(Math.abs(r1),r2);
            String ans=(r1/c)+"/"+(r2/c);
            if (p1>=q1){
                ans="+"+ans;
            }
            return ans;
        }
    }

    //https://zhuanlan.zhihu.com/p/451041897
    private long gcd(long r1, long r2) {
        return r2==0?r1:gcd(r2,r1%r2);
    }

    private long[] parse(String s) {
        int n=s.length(),idx=1;
        while (idx<n&&s.charAt(idx)!='/'){
            idx++;
        }
        long a=Long.parseLong(s.substring(1,idx)),b=Long.parseLong(s.substring(idx+1));
        return new long[]{a,b};
    }
}
