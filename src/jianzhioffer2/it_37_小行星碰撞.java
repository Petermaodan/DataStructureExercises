package jianzhioffer2;

import BaseUtil.ListUtil;

import java.util.Stack;

/**
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 * 示例 1：
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 首先，循环每一个元素时，在什么情况下无脑入栈呢？
 *
 * 栈为空
 * 栈顶元素为负数(下一个为负数则一起向左，下一个为正数则分向两边)
 * 当前元素为正数（栈顶为正一起向右，栈顶为负分向两边）
 * 下来，我们需要看碰撞的场景又细分为什么情况：
 *
 * 栈顶元素大于abs(当前元素)，当前元素被撞毁
 * 栈顶元素等于abs(当前元素)，栈顶弹出和当前元素抵消
 * 栈顶元素小于abs(当前元素)，栈顶弹出，并与新栈顶完成上述判断

 */
public class it_37_小行星碰撞 {
    public static void main(String[] args) {
        int[] asteroids = {10,2,-5};
        int[] res = new it_37_小行星碰撞().asteroidCollision(asteroids);
        ListUtil.arrayOneNums(res);
    }
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        int len=asteroids.length;
        int idx=0;
        while (idx<len){

            if (stack.isEmpty()||stack.peek()<0||asteroids[idx]>0){
                stack.add(asteroids[idx]);
            }else if (Math.abs(stack.peek())==Math.abs(asteroids[idx])){
                stack.pop();
            }else if (Math.abs(stack.peek())<Math.abs(asteroids[idx])){
                stack.pop();
                continue;
            }
            idx++;
        }
        int n=stack.size();
        int[] res=new int[n];
        for (int i = n-1; i >= 0; i--) {
            res[i]=stack.pop();
        }
        return res;
    }
}
