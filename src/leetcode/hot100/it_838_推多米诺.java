package leetcode.hot100;

/**
 *
 * 两个相邻的被推倒的牌互不影响。
 * 一张站立的牌（"."）的最终状态与离其两侧最近的 "L" 或 "R" 有关。
 双指针
 可以使用「双指针」的方式寻找 "."左右两边距离最近的被推倒的牌，形成"X....Y"型的区间。

 在这两个被推倒了牌形成的区间里，根据左右两端的牌不同，有四种可能性：


 'R......R' => 'RRRRRRRR'
 'R......L' => 'RRRRLLLL' or 'RRRR.LLLL'
 'L......R' => 'L......R'
 'L......L' => 'LLLLLLLL'

 *思路，双指针求解
 * 在每个 for 循环中，向 res 添加结果只添加区间的 [l, r) 部分，
 * 即左闭右开。而且注意当 l = 0 的位置，是我们虚拟的牌，不要向 res 中添加。
 *
 *
 */
public class it_838_推多米诺 {
    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        String res = new it_838_推多米诺().pushDominoes(dominoes);
        System.out.println(res);
    }

    public String pushDominoes(String dominoes){
        //左右添加虚指针，方便统计
        dominoes="L"+dominoes+"R";
        StringBuilder res=new StringBuilder();
        int l=0;
        for (int r = 1; r < dominoes.length(); r++) {
            //若遍历到竖着的，则直接跳过
            if (dominoes.charAt(r)=='.'){
                continue;
            }
            //将头部先添加进来，虚拟头部除外
            if (l!=0){
                res.append(dominoes.charAt(l));
            }
            //计算两指针中间竖着的个数
            int mid=r-l-1;
            //判断四种情况
            // 在每个 for 循环中，向 res 添加结果只添加区间的 [l, r) 部分，
            // 即左闭右开。而且注意当 l = 0 的位置，是我们虚拟的牌，不要向 res 中添加。
            if (dominoes.charAt(l)==dominoes.charAt(r)){
                for (int i = 0; i < mid; i++) {
                    res.append(dominoes.charAt(l));
                }
            }else if (dominoes.charAt(l)=='L'||dominoes.charAt(r)=='R'){
                for (int i = 0; i < mid; i++) {
                    res.append('.');
                }
            }else {
                for (int i = 0; i < mid / 2; i++) {
                    res.append('R');
                }
                if (mid%2==1){
                    res.append('.');
                }
                for (int i = 0; i < mid / 2; i++) {
                    res.append('L');
                }
            }
            //更新左指针
            l=r;
        }
        return res.toString();
    }
}
