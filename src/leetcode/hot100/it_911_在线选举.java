package leetcode.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你两个整数数组 persons 和 times 。在选举中，第 i 张票是在时刻为 times[i] 时投给候选人 persons[i] 的。
 *
 * 对于发生在时刻 t 的每个查询，需要找出在 t 时刻在选举中领先的候选人的编号。
 *
 * 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 *
 * 实现 TopVotedCandidate 类：
 *
 * TopVotedCandidate(int[] persons, int[] times) 使用 persons 和 times 数组初始化对象。
 * int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
 *  
 * 示例：
 *
 * 输入：
 * ["TopVotedCandidate", "q", "q", "q", "q", "q", "q"]
 * [[[0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]], [3], [12], [25], [15], [24], [8]]
 * 输出：
 * [null, 0, 1, 1, 0, 0, 1]
 *
 * 解释：
 * TopVotedCandidate topVotedCandidate = new TopVotedCandidate([0, 1, 1, 0, 0, 1, 0], [0, 5, 10, 15, 20, 25, 30]);
 * topVotedCandidate.q(3); // 返回 0 ，在时刻 3 ，票数分布为 [0] ，编号为 0 的候选人领先。
 * topVotedCandidate.q(12); // 返回 1 ，在时刻 12 ，票数分布为 [0,1,1] ，编号为 1 的候选人领先。
 * topVotedCandidate.q(25); // 返回 1 ，在时刻 25 ，票数分布为 [0,1,1,0,0,1] ，编号为 1 的候选人领先。（在平局的情况下，1 是最近获得投票的候选人）。
 * topVotedCandidate.q(15); // 返回 0
 * topVotedCandidate.q(24); // 返回 0
 * topVotedCandidate.q(8); // 返回 1
 *
 * 思路，预处理＋二分求解
 */
public class it_911_在线选举 {
    public static void main(String[] args) {
        int[] persons={0, 1, 1, 0, 0, 1, 0};
        int[] times={0, 5, 10, 15, 20, 25, 30};

        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(persons, times);
        System.out.println(topVotedCandidate.q(3));
        System.out.println(topVotedCandidate.q(12));
        System.out.println(topVotedCandidate.q(25));
        System.out.println(topVotedCandidate.q(15));
        System.out.println(topVotedCandidate.q(24));
        System.out.println(topVotedCandidate.q(8));
    }
    static class TopVotedCandidate {

        List<int[]> list;
        Map<Integer,Integer> map;
        int val=0;
        public TopVotedCandidate(int[] persons, int[] times) {
            //预处理
            list=new ArrayList<>();
            map=new HashMap<>();
            int len=persons.length;
            for (int i = 0; i < len; i++) {
                map.put(persons[i],map.getOrDefault(persons[i],0)+1);
                if (map.get(persons[i])>=val){
                    val=map.get(persons[i]);
                    //在i时刻，persons[i]胜出
                    list.add(new int[]{times[i],persons[i]});
                }
            }
        }

        //二分法求解
        public int q(int t) {
            int l=0,r=list.size()-1;
            while (l<r){
                int mid=(l+r+1)/2;//加1是防止死循环，因为mid不是确定的，而是在范围内
                if (list.get(mid)[0]<=t){
                    l=mid;
                }else {
                    r=mid-1;
                }
            }
            return list.get(r)[0]<=t?list.get(r)[1]:0;
        }
    }
}
