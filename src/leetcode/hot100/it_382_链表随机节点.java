package leetcode.hot100;

import it_Base.IListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution(ListNode head) 使用整数数组初始化对象。
 * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 * <p>
 * 每次只保留一个数，当遇到第 i 个数时，以 1/i的概率保留它，(i-1)/i的概率保留原来的数。
 * <p>
 * <p>
 * 思路，蓄水池取样法
 * 举例说明： 1 - 10
 * <p>
 * 遇到1，概率为1，保留第一个数。
 * 遇到2，概率为1/2，这个时候，1和2各1/2的概率被保留
 * 遇到3，3被保留的概率为1/3，(之前剩下的数假设1被保留)，2/3的概率 1 被保留，(此时1被保留的总概率为 2/3 * 1/2 = 1/3)
 * 遇到4，4被保留的概率为1/4，(之前剩下的数假设1被保留)，3/4的概率 1 被保留，(此时1被保留的总概率为 3/4 * 2/3 * 1/2 = 1/4)
 * 以此类推，每个数被保留的概率都是1/N。
 */
public class it_382_链表随机节点 {

    class Solution2{
        Random random=new Random();
        IListNode head;
        public Solution2(IListNode head){
            this.head=head;
        }

        public int getRandom(){
            int ans=0,idx=1;
            IListNode t=head;
            while (t!=null){
                idx++;
                if (random.nextInt(idx)==idx){
                    ans=t.val;
                }
                t=t.next;
            }
            return ans;
        }
    }

    class Solution {

        Random random = new Random();
        List<Integer> list = new ArrayList<>();

        public Solution(IListNode head) {
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            int r = random.nextInt(list.size());
            return list.get(r);
        }
    }
}
