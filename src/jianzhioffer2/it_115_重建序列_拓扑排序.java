package jianzhioffer2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 输入：nums = [1,2,3], sequences = [[1,2],[1,3]]
 * 输出：false
 * 解释：有两种可能的超序列：[1,2,3]和[1,3,2]。
 * 序列 [1,2] 是[1,2,3]和[1,3,2]的子序列。
 * 序列 [1,3] 是[1,2,3]和[1,3,2]的子序列。
 * 因为 nums 不是唯一最短的超序列，所以返回false。
 *
 */
public class it_115_重建序列_拓扑排序 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[][] sequences = {{1,2},{1,3},{2,3}};
        boolean res = new it_115_重建序列_拓扑排序().sequenceReconstruction(nums, sequences);
        System.out.println(res);
    }

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int size=nums.length;
        Set<Integer>[] graph=new Set[size+1];
        int[] inDegree=new int[size+1];

        //转化为有向图
        for (int i = 1; i <=size ; i++) {
            graph[i]=new HashSet<>();
        }
        for (int[] sequence : sequences) {
            int length=sequence.length;
            for (int i = 1; i < length; i++) {
                int from=sequence[i-1],to=sequence[i];
                //判断是否存在有向图
                if (graph[from].add(to)){
                    //若不存在，则入度增加1
                    inDegree[to]++;
                }
            }
        }
        Queue<Integer> queue=new ArrayDeque<>();
        for (int i = 1; i <=size; i++) {
            if (inDegree[i]==0){
                queue.add(i);
            }
        }
        //拓扑排序
        while (!queue.isEmpty()){
            //存在多个入度为0的点 会有多个超序列 直接返回false
            if (queue.size()>1){
                return false;
            }
            int poll = queue.poll();
            Set<Integer> sets=graph[poll];
            for (Integer set : sets) {
                inDegree[set]--;
                if (inDegree[set]==0){
                    queue.add(set);
                }
            }
        }
        return true;
    }
}
