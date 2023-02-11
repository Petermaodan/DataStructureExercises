package leetcode.dailyTest;

import java.util.Random;

/**
 * 给定圆的半径和圆心的位置，实现函数 randPoint ，在圆中产生均匀随机点。
 *
 * 实现 Solution 类:
 *
 * Solution(double radius, double x_center, double y_center) 用圆的半径 radius 和圆心的位置 (x_center, y_center) 初始化对象
 * randPoint() 返回圆内的一个随机点。圆周上的一点被认为在圆内。答案作为数组返回 [x, y] 。
 *  
 *
 * 示例 1：
 *
 * 输入:
 * ["Solution","randPoint","randPoint","randPoint"]
 * [[1.0, 0.0, 0.0], [], [], []]
 * 输出: [null, [-0.02493, -0.38077], [0.82314, 0.38945], [0.36572, 0.17248]]
 *
 *
 *
 */
public class it_478_在圆内随机生成点 {

    class Solution {

        double r,x,y;
        Random random=new Random();
        public Solution(double radius, double x_center, double y_center) {
            this.r=radius;
            this.x=x_center;
            this.y=y_center;
        }

        public double[] randPoint() {
            //len 不能直接在 [0, r]范围内随机，为了消除这种一维转圆导致的「等概率」失效
            // ，我们可以从 [0, r^2]内随机再开平方，从而确保距离与面积比例一致
            double len = Math.sqrt(random.nextDouble()*(r*r)),ang=random.nextDouble()*(2*Math.PI);
            double newX=x+len*Math.cos(ang);
            double newY=y+len*Math.sin(ang);
            return new double[]{newX,newY};
        }
    }
}
