package leetcode.hot100;

import BaseUtil.ListUtil;
/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 遍历整个数组，如果栈不空，且当前数字大于栈顶元素，那么如果直接入栈的话就不是 递减栈 ，所以需要取出栈顶元素，由于当前数字大于栈顶元素的数字，而且一定是第一个大于栈顶元素的数，直接求出下标差就是二者的距离。

 继续看新的栈顶元素，直到当前数字小于等于栈顶元素停止，然后将数字入栈，这样就可以一直保持递减栈，且每个数字和第一个大于它的数的距离也可以算出来。


 */
import java.util.Stack;

public class it_739_每日温度 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res=new it_739_每日温度().dailyTemperatures(temperatures);
        ListUtil.arrayOneNums(res);
    }

    //动态规划
    /**
     * 根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
     * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
     * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
     * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
     * - 若T[i] < T[i+1]，那么res[i]=1；
     * - 若T[i] > T[i+1]
     *   - res[i+1]=0，那么res[i]=0;
     *   - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
     */
    public int[] dailyTemperatures(int[] temperatures){
        int n=temperatures.length;
        int[] res=new int[n];
        //base case:
        res[n-1]=0;
        for (int i = n-2; i >=0; i--) {
            for (int j = i+1; j <n ; j+=res[j]) {
                if (temperatures[i]<temperatures[j]){
                    res[i]=j-i;
                    break;
                    //res[i+1]=0，那么res[i]=0;
                }else if (res[j]==0){
                    res[i]=0;
                    break;
                }
            }
        }
        return res;

    }


    public int[] dailyTemperatures2(int[] temperatures){
        int n=temperatures.length;
        int[] res=new int[n];
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                int j=stack.pop();
                res[j]=i-j;
            }
            stack.push(i);
        }
        return res;
    }

}
