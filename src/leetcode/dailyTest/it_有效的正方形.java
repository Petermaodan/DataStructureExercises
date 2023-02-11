package leetcode.dailyTest;

/**
 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
 *
 * 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。
 *
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 *
 * 转化为四个等腰直角三角形求解
 */
public class it_有效的正方形 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return validAngel(p1,p2,p3)&&validAngel(p1,p2,p4)&&validAngel(p2,p3,p4)&&validAngel(p1,p3,p4);
    }

    public boolean validAngel(int[] p1, int[] p2, int[] p3){
        long a=(p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
        long b=(p1[0]-p3[0])*(p1[0]-p3[0])+(p1[1]-p3[1])*(p1[1]-p3[1]);
        long c=(p2[0]-p3[0])*(p2[0]-p3[0])+(p2[1]-p3[1])*(p2[1]-p3[1]);
        boolean ok=((a==b&&a+b==c)||(a==c&&a+c==b)||(b==c&&b+c==a));
        if (a==0||b==0||c==0){
            return false;
        }
        return ok;
    }
}
