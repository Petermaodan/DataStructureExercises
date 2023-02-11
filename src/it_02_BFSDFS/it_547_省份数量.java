package it_02_BFSDFS;

/**
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 * 计算省份总数，等价于计算图中的连通分量数，可以通过深度优先搜索或广度优先搜索实现，也可以通过并查集实现。
 */
public class it_547_省份数量 {

    public static void main(String[] args) {
        int[][] isConnected={{1,0,0,1},{0,1,1,0},{0,1,1,0},{1,0,1,1}};
        int res=new it_547_省份数量().findCircleNum(isConnected);
        System.out.println(res);
    }

    int res=0;
    public int findCircleNum(int[][] isConnected) {

//provinces为最多可能存在的省会数量
       int provinces=isConnected.length;


// 定义 cnt 来累计遍历过的连通域的数量
       boolean[] visited=new boolean[provinces];
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]){
                dfs(isConnected,visited,provinces,i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected,boolean[] visited,int provinces, int i) {
        for (int j = 0; j <provinces ; j++) {
            if (isConnected[i][j]==1&&!visited[j]){
                visited[j]=true;
                dfs(isConnected,visited,provinces,j);
            }
        }
    }

    private boolean isArea(int[][] isConnected, int i, int j) {
        return i>=0&&i<isConnected.length&&j>=0&&j<isConnected[0].length;
    }


}
