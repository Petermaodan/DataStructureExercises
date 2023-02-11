package leetcode.hot100;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * 将罗马数字转化为整数，核心思想就是比较当前num和之前num的大小，如果后面的比前面的，那么必然是要减去这个num了
 */
public class it_13_罗马数字转整数 {
    public static void main(String[] args) {
        String s="IX";
        int res = new it_13_罗马数字转整数().romanToInt(s);
        System.out.println(res);
    }

    public int romanToInt(String s){

        int len=s.length();
        int preNum=getValue(s.charAt(0));
        int sum=0;
        for (int i = 1; i < len; i++) {
            //与prenum进行比较
            int num=getValue(s.charAt(i));
            if (preNum>=num){
                sum+=preNum;
            }else {
                sum-=preNum;
            }
            //更新preNum
            preNum=num;
        }
        return sum+preNum;
    }

    public int getValue(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;

        }
    }
}
