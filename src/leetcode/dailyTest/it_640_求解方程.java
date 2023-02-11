package leetcode.dailyTest;

/**
 * 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 *
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 *
 */
public class it_640_求解方程 {
    public static void main(String[] args) {
        String equation="2x+3x-6x=x+2";
        String res = new it_640_求解方程().solveEquation(equation);
        System.out.println(res);
    }

    public String solveEquation(String equation) {
        String[] split = equation.split("=");
        String sLeft=split[0].charAt(0)=='-'?split[0]:"+"+split[0];
        String sRight=split[1].charAt(0)=='-'?split[1]:"+"+split[1];
        int[] intLeft = sumXandNum(sLeft);
        int[] intRight=sumXandNum(sRight);
        int leftX=intLeft[0],leftNum=intLeft[1],rightX=intRight[0],rightNum=intRight[1];
        int xSum=leftX-rightX,numSum=rightNum-leftNum;
        if (xSum==0){
            return numSum==0? "Infinite solutions":"No solution";
        }else{
            return "x="+(numSum/xSum);
        }
    }

    public int[] sumXandNum(String s){
        int l=0,r=1;
        int X=0,Num=0;
        while (r<s.length()){
            while (r<s.length()&&s.charAt(r)!='+'&&s.charAt(r)!='-'){
                r++;
            }
            if (s.charAt(r-1)=='x'){
                int temp=l+1==r-1?1:Integer.parseInt(s.substring(l+1,r-1));
                if (s.charAt(l)=='+'){
                    X+=temp;
                }else {
                    X-=temp;
                }
            }else {
                int temp=Integer.parseInt(s.substring(l+1,r));
                if (s.charAt(l)=='+'){
                    Num+=temp;
                }else {
                    Num-=temp;
                }
            }
            l=r;
            r++;
        }
        return new int[]{X,Num};
    }

}
