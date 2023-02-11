package leetcode.hot100;

/**
 * Hercy 想要为购买第一辆车存钱。他 每天 都往力扣银行里存钱。
 *
 * 最开始，他在周一的时候存入 1 块钱。从周二到周日，他每天都比前一天多存入 1 块钱。在接下来每一个周一，他都会比 前一个周一 多存入 1 块钱。
 *
 * 给你 n ，请你返回在第 n 天结束的时候他在力扣银行总共存了多少块钱。
 */
public class it_1716_计算力扣银行的钱 {
    public static void main(String[] args) {
        int n=20;
        int res = new it_1716_计算力扣银行的钱().totalMoney(n);
        System.out.println(res);
    }
    public int totalMoney(int n) {
        int count=n/7;
        int idx=n%7;
        int res=0;
        if (count>0){
            res+=(28+28+7*(count-1))*count/2;
        }
        for (int i = count+1; i <count+1+idx ; i++) {
            res+=i;
        }
        return res;
    }
}
