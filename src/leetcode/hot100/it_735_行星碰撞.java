package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.Stack;

/**
 *  * 首先，循环每一个元素时，在什么情况下无脑入栈呢？
 *  *
 *  * 栈为空
 *  * 栈顶元素为负数(下一个为负数则一起向左，下一个为正数则分向两边)
 *  * 当前元素为正数（栈顶为正一起向右，栈顶为负分向两边）
 *  * 下来，我们需要看碰撞的场景又细分为什么情况：
 */
public class it_735_行星碰撞 {
    public static void main(String[] args) {
        int[] asteroids={5,10,-5};
        int[] ints = new it_735_行星碰撞().asteroidCollision(asteroids);
        ListUtil.arrayOneNums(ints);
    }

    public int[] asteroidCollision(int[] asteroids) {
        int len=asteroids.length;
        int index=0;
        Stack<Integer> stack=new Stack<>();
        while (index<len){
            //无脑入栈的情况
            if (stack.isEmpty()||stack.peek()<0||asteroids[index]>0){
                stack.add(asteroids[index]);
            }else if (Math.abs(asteroids[index])==Math.abs(stack.peek())){
                stack.pop();
            }else if (Math.abs(asteroids[index])>Math.abs(stack.peek())){
                stack.pop();
                continue;
            }
            index++;
        }
        int[] res=new int[stack.size()];
        for (int i = res.length-1; i >=0 ; i--) {
            res[i]=stack.pop();
        }
        return res;
    }
}
