package leetcode.dailyTest;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 *
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 *
 * 然后我们来进行 分治算法三步走：
 * 分治即是递归
 *
 * 分解：按运算符分成左右两部分，分别求解
 * 解决：实现一个递归函数，输入算式，返回算式解
 * 合并：根据运算符合并左右两部分的解，得出最终解
。
 */
public class it_241_为运算表达式设计优先级 {
    public static void main(String[] args) {
        String expression = "2-1-1";
        List<Integer> list = new it_241_为运算表达式设计优先级().diffWaysToCompute(expression);
        ListUtil.arrayOne(list);
    }

    public List<Integer> diffWaysToCompute(String expression) {
        int len=expression.length();
        int idx;
        List<Integer> res=new ArrayList<>();
        for ( idx = 0; idx <len ; idx++) {
            if (Character.isDigit(expression.charAt(idx))){
                continue;
            }else {
                break;
            }

        }
        if (idx==len){
            res.add(Integer.valueOf(expression));
        }
        //分治，拆解
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(expression.charAt(i))){
                continue;
            }
            char op=expression.charAt(i);
            List<Integer> left=diffWaysToCompute(expression.substring(0,i));
            List<Integer> right=diffWaysToCompute(expression.substring(i+1,len));
            for (Integer a : left) {
                for (Integer b : right) {
                    if (op=='+'){
                        res.add(a+b);
                    }else if (op=='-'){
                        res.add(a-b);
                    }else {
                        res.add(a*b);
                    }
                }
            }
        }
        return res;
    }
}
