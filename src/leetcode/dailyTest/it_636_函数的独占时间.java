package leetcode.dailyTest;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class it_636_函数的独占时间 {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans=new int[n];
        Deque<Integer> deque=new ArrayDeque<>();
        int cur=0;
        for (String log : logs) {
            String[] split = log.split(":");
            int idx=Integer.parseInt(split[0]),ts= Integer.parseInt(split[2]);
            if (split[1].equals("start")){
                if (!deque.isEmpty()){
                    ans[deque.peekLast()]+=ts-cur;
                }
                deque.addLast(idx);
                cur=ts;
            }else {
                ans[deque.pollLast()]+=ts-cur+1;
                cur=ts+1;
            }
        }
        return ans;

    }
}
