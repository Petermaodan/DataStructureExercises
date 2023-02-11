package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.*;

/**
 * 在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 *
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 *
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 *
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。
 * 图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 *
 * 输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * 输出：[2,4,5,6]
 *
 * 我们可以将所有边进行反向，这时候「入度」和「出度」翻转了。
 *
 * 对于那些反向图中「入度」为  的点集 ，其实就是原图中「出度」为  的节点，它们「出度」为 ，根本没指向任何节点，必然无法进入环，是安全的；同时由它们在反向图中指向的节点（在原图中「只指向」它们的节点），必然也是无法进入环的，对应到反向图中，就是那些减去  对应的入度之后，入度为  的节点。
 */
public class it_802_找到最终的安全状态_拓扑排序_链式存图 {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> list = new it_802_找到最终的安全状态_拓扑排序_链式存图().eventualSafeNodes(graph);
        ListUtil.arrayOne(list);
    }


    //idx 是用来对边进行编号的，然后对存图用到的几个数组作简单解释：
    //head 数组：存储是某个节点所对应的边的集合（链表）的头结点；
    //e  数组：由于访问某一条边指向的节点；
    //next 数组：由于是以链表的形式进行存边，该数组就是用于找到下一条边；
    //w  数组：用于记录某条边的权重为多少
    int N=(int)1e4+10,M=4*N;
    int idx;
    int[] head=new int[N],e=new int[M],next=new int[M];
    //统计入度
    int[] cnts=new int[N];

    public void add(int a,int b){
        e[idx]=b;
        next[idx]=head[a];
        head[a]=idx;
        idx++;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        //存反向图，并统计入度
        Arrays.fill(head,-1);
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                //反向存图
                add(j,i);
                cnts[i]++;
            }
        }
        //BFS
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //入度为0的加入队列
            if (cnts[i]==0)queue.add(i);
        }
        while (!queue.isEmpty()){
            int poll=queue.poll();
            for (int i = head[poll]; i !=-1 ; i=next[i]) {
                int j=e[i];
                if (--cnts[j]==0)queue.add(j);
            }
        }
        // 遍历答案：如果某个节点出现在拓扑序列，说明其进入过队列，说明其入度为 0
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnts[i]==0)ans.add(i);
        }
        return ans;
    }
}
