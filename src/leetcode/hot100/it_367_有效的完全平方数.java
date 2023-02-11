package leetcode.hot100;

public class it_367_有效的完全平方数 {
    public static void main(String[] args) {
        int num=16;
        boolean perfectSquare = new it_367_有效的完全平方数().isPerfectSquare(num);
        System.out.println(perfectSquare);
    }
    //方法二，等差奇数的和为有效的完全平方数1+3=4，1+3+5=9，1+3+5+7=16，进阶方法
    private boolean isPerfectSquare(int num) {
        int temp=1;
        while (num>=0){
            if (num==0)return true;
            num-=temp;
            temp+=2;
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        int temp= (int) Math.sqrt(num);
        return Math.pow(temp,2)==num?true:false;
    }
}
