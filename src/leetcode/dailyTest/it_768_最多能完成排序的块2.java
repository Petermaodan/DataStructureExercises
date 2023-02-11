package leetcode.dailyTest;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
 *
 * arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 *
 * 我们最多能将数组分成多少块？
 *
 *输入: arr = [2,1,3,4,4]
 * 输出: 4
 * 解释:
 * 我们可以把它分成两块，例如 [2, 1], [3, 4, 4]。
 * 然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。
 *
 * 类似单调栈？？？
 */
public class it_768_最多能完成排序的块2 {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,4};
        int res = new it_768_最多能完成排序的块2().maxChunksToSorted(arr);
        System.out.println(res);
    }
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> deque=new ArrayDeque<>();
        for (int num : arr) {
            if (!deque.isEmpty()&&num<deque.peekLast()){
                int head=deque.pollLast();
                while (!deque.isEmpty()&&deque.peekLast()>num){
                    deque.pollLast();
                }
                deque.addLast(head);
            }else {
                deque.addLast(num);
            }
        }
        return deque.size();
    }
}
