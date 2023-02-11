package jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 */
public class it_13_机器人的运动范围 {
    public static void main(String[] args) {
        int m=2,n=3,k=1;
        System.out.println(new it_13_机器人的运动范围().movingCount(m,n,k));
    }
    //BFS
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{0,0,0,0});
        int res=0;//统计个数
        while (queue.size()>0){
            //弹出
            int[] x=queue.poll();
            int i=x[0],j=x[1],si=x[2],sj=x[3];
            if (i>=m||j>=n||k<si+sj||visited[i][j])continue;
            visited[i][j]=true;
            res++;
            queue.add(new int[]{i+1,j,(i+1)%10!=0?si+1:si-8,sj});
            queue.add(new int[]{i,j+1,si,(j+1)%10!=0?sj+1:sj-8});
        }
        return res;
    }


    //DFS
    int m,n,k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m=m;this.n=n;this.k=k;
        visited= new boolean[m][n];
        //根据可达性分析，从0，0位置开始是最大的
        int res=dfs(0,0,0,0);
        return res;
    }

    private int dfs(int i, int j, int si, int sj) {
        //跳出递归
        if (i>=m||j>=n||k<i%10+i/10+j%10+j/10||visited[i][j])return 0;
        //标记
        visited[i][j]=true;
        //递归返回
        return 1+dfs(i+1,j,(i+1)%10!=0?si+1:si-8,sj)+dfs(i,j+1,si,(j+1)%10!=0?sj+1:sj-8);
    }
}
