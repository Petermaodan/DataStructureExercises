package jianzhioffer2;

import java.util.ArrayDeque;
import java.util.Deque;

public class it_42_最近请求次数 {

    class RecentCounter {

        Deque<Integer> deque;
        public RecentCounter() {
            deque=new ArrayDeque<>();
        }

        public int ping(int t) {
            deque.addLast(t);
            int minValue=t-3000;
            while (!deque.isEmpty()){
                int temp=deque.peekFirst();
                if (temp<minValue){
                    deque.pollFirst();
                }else {
                    break;
                }
            }
            return deque.size();
        }
    }
}
