package leetcode.hot100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 * 思路，并查集，核心内容就是创建一个深度为2的树并不断更新维护

 */

public class it_399_除法求值 {



    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int equationsSize=equations.size();

        //创建并查集的树
        UnionFind unionFind=new UnionFind(2*equationsSize);
        //预处理，将变量的值与id进行映射，使得并查集的底层使用数组实现
        Map<String,Integer> hashMap=new HashMap<>(2*equationsSize);

        int id=0;
        for (int i = 0; i < equationsSize; i++) {
            List<String> equation=equations.get(i);
            String var1=equation.get(0);
            String var2=equation.get(1);
            if (!hashMap.containsKey(var1)){
                hashMap.put(var1,id);
                id++;
            }
            if (!hashMap.containsKey(var2)){
                hashMap.put(var2,id);
                id++;
            }
            unionFind.union(hashMap.get(var1),hashMap.get(var2),values[i]);
        }
        //做查询
        int queriesSize=queries.size();
        double[] res=new double[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            String var1=queries.get(i).get(0);
            String var2=queries.get(i).get(1);

            Integer id1=hashMap.get(var1);
            Integer id2=hashMap.get(var2);

            if (id1==null||id2==null){
                res[i]=-1.0d;
            }else {
                //调用了find()方法，会进行路径压缩
                res[i]=unionFind.isConnected(id1,id2);
            }
        }
        return res;
    }

    private class UnionFind {
        private int[] parent;
        //指向父节点的权值
        private double[] weight;

        public UnionFind(int n){
            this.parent=new int[n];
            this.weight=new double[n];
            for (int i = 0; i < n; i++) {
                parent[i]=i;
                weight[i]=1.0d;
            }
        }

        //将x和y的值用又向图来表示
        public void union(int x,int y,double value){
            int rootX=find(x);
            int rootY=find(y);
            if (rootX==rootY){
                return;
            }
            //rootX指向rootY
            parent[rootX]=rootY;
            //更新rootX的权值，根据之前四边形推导
            weight[rootX]=weight[y]*value/weight[x];
        }
        //路径压缩
        public int find(int x){
            if (x!=parent[x]){
                int origin=parent[x];
                //递归寻找根节点
                parent[x]=find(parent[x]);
                weight[x]*=weight[origin];
            }
            return parent[x];
        }

        //将x和y用新的有向图表示
        public double isConnected(int x,int y){
            int rootX=find(x);
            int rootY=find(y);
            //若同根
            if (rootX==rootY){
                return weight[x]/weight[y];
            }else {
                return -1;
            }
        }
    }
}
