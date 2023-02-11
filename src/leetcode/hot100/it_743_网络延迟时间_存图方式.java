package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.Arrays;

/**有 n 个网络节点，标记为 1 到 n。

 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。

 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1

 二维矩阵来进行存图的方式。

 适用于边数较多的「稠密图」使用，当边数量接近点的数量的平方，即  时，可定义为「稠密图」。

 邻接表
 这也是一种在图论中十分常见的存图方式，与数组存储单链表的实现一致（头插法）。

 这种存图方式又叫「链式前向星存图」。

 适用于边数较少的「稀疏图」使用，当边数量接近点的数量，即  时，可定义为「稀疏图」。
**/
public class it_743_网络延迟时间_存图方式 {
    public static void main(String[] args) {
        int[][] times={{2,1,1},{2,3,1},{3,4,1}};
        int res = new it_743_网络延迟时间_存图方式().networkDelayTime(times, 4, 2);
        System.out.println(res);
    }

    //朴素Dijkstra（邻接矩阵 ）
    int INF=0x3f3f3f3f;
    public int networkDelayTime(int[][] times, int n, int k) {
        int N=110;
        int[][] w=new int[N][N];

        // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
        int[] dist=new int[N];
        //记录哪些点已经被更新过
        boolean[] vis=new boolean[N];

        //如果u,v之间没有边，那么w[u][v]=INF，如果我们的INF取0x7fffffff，那么d[u]+w[u][v]会溢出而变成负数，我们的松弛操作便出错了！
        //所以这里要用0x3f3f3f3f
        //0x3f3f3f3f的十进制是1061109567，是10^9级别的（和0x7fffffff一个数量级），而一般场合下的数据都是小于10^9的，所以它可以作为无穷大使用而不致出现数据大于无穷大的情形。
        //另一方面，由于一般的数据都不会大于10^9，所以当我们把无穷大加上一个数据时，它并不会溢出（这就满足了“无穷大加一个有穷的数依然是无穷大”），事实上0x3f3f3f3f+0x3f3f3f3f=2122219134，这非常大但却没有超过32-bit int的表示范围，所以0x3f3f3f3f还满足了我们“无穷大加无穷大还是无穷大”的需求。

        //初始化接邻矩阵
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                w[i][j]=w[j][i]=i==j?0:INF;
            }
        }
        //存图
        for (int[] time : times) {
            int u=time[0],v=time[1],c=time[2];
            w[u][v]=c;
        }

        //dijkstra算法找最短路径
        dijkstra(vis,dist,w,n,k);
        int ans=0;
        for (int i = 1; i <=n ; i++) {
            ans=Math.max(ans,dist[i]);
        }
        return ans>INF/2?-1:ans;


    }

    private void dijkstra(boolean[] vis, int[] dist, int[][] w, int n, int k) {
        //起始先将所有的点标记为未更新
        Arrays.fill(vis,false);
        Arrays.fill(dist,INF);

        // 只有起点最短距离为 0
        dist[k]=0;
        //迭代n次
        for (int p = 1; p <=n ; p++) {
            //每次找到最短距离且未被更新的点t
            int t=-1;
            for (int i = 1; i <=n ; i++) {
                if (!vis[i]&&(t==-1||dist[i]<dist[t]))t=i;
            }
            //标记点t为已更新
            vis[t]=true;

            // 用点 t 的「最小距离」更新其他点
            for (int i = 1; i <=n ; i++) {
                dist[i]=Math.min(dist[i],dist[t]+w[t][i]);
            }
        }
    }


    //三层循环，暴露求解
    // 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作

    public int networkDelayTime2(int[][] times, int n, int k) {
        int N=110;
        int[][] w=new int[N][N];
        //如果u,v之间没有边，那么w[u][v]=INF，如果我们的INF取0x7fffffff，那么d[u]+w[u][v]会溢出而变成负数，我们的松弛操作便出错了！
        //所以这里要用0x3f3f3f3f
        //0x3f3f3f3f的十进制是1061109567，是10^9级别的（和0x7fffffff一个数量级），而一般场合下的数据都是小于10^9的，所以它可以作为无穷大使用而不致出现数据大于无穷大的情形。
        //另一方面，由于一般的数据都不会大于10^9，所以当我们把无穷大加上一个数据时，它并不会溢出（这就满足了“无穷大加一个有穷的数依然是无穷大”），事实上0x3f3f3f3f+0x3f3f3f3f=2122219134，这非常大但却没有超过32-bit int的表示范围，所以0x3f3f3f3f还满足了我们“无穷大加无穷大还是无穷大”的需求。
        int INF=0x3f3f3f3f;
        //初始化接邻矩阵
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                w[i][j]=w[j][i]=i==j?0:INF;
            }
        }
        //存图
//        ListUtil.arrayTowNums(times);
        for (int[] time : times) {
            int u=time[0],v=time[1],c=time[2];
            w[u][v]=c;
        }
//        ListUtil.arrayTowNums(w);
        //最短路径
        floyd(w,n);
//        ListUtil.arrayTowNums(w);
        int ans=0;
        //遍历答案
        for (int i = 1; i <=n ; i++) {
            ans=Math.max(ans,w[k][i]);
        }
        return ans>=INF/2?-1:ans;

    }

    private void floyd(int[][] w, int n) {
        // floyd 基本流程为三层循环：
        // 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作
        for (int k = 1; k <=n; k++) {
            for (int i = 1; i <=n; i++) {
                for (int j =1; j <=n ; j++) {
                    w[i][j]=Math.min(w[i][j],w[i][k]+w[k][j]);
                }
            }
        }
    }
}
