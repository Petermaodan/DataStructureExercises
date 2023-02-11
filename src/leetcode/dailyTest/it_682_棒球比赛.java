package leetcode.dailyTest;

import java.util.Stack;

/**
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 *
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 *
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：ops = ["5","2","C","D","+"]
 * 输出：30
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 */
public class it_682_棒球比赛 {
    public static void main(String[] args) {
        String[] ops = {"5","2","C","D","+"};
        int res = new it_682_棒球比赛().calPoints(ops);
        System.out.println(res);
    }
    public int calPoints(String[] ops) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        for (String op : ops) {
            if (op.equals("C")){
                stack.pop();
            }else if (op.equals("D")){
                stack.add(stack.peek()*2);
            }else if (op.equals("+")){
                int temp=stack.pop();
                int sum=temp+stack.peek();
                stack.add(temp);
                stack.add(sum);
            }else {
                stack.add(Integer.valueOf(op));
            }
        }
        for (Integer integer : stack) {
            res+=integer;
        }
        return res;
    }
}
