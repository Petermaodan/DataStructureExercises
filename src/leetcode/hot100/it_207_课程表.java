package leetcode.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。

 涉及到图的问题，首先想到的应该是BFS和DFS
 这道题两种方法都可以
 共同点，都需要创建一个接邻表adjacency-》降低时间复杂度
 */
public class it_207_课程表 {
    public static void main(String[] args) {
        int numsCourses=2;
        int[][] prerequisites={{1,0},{0,1}};
        boolean res=new it_207_课程表().canFinish2(numsCourses,prerequisites);
        System.out.println(res);
    }


    //方法一，BFS-》需要借助一个入度表indgrees和栈queue
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees=new int[numCourses];
        //创建队列
        Queue<Integer> queue=new LinkedList<>();
        //创建接邻表
        List<List<Integer>> adjacency=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;//入度自增
            //通过列表实现有向图
            // cp[1]指向cp[0]
            adjacency.get(cp[1]).add(cp[0]);
        }

        //入度为0的加入队列
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i]==0){
                queue.add(i);
            }
        }

        //BFS
        while (!queue.isEmpty()){
            int pre=queue.poll();
            numCourses--;
            //将pre指向外面的边都进行删除,遍历pre指向的对象
            for (int cur : adjacency.get(pre)) {
                //先自减再判断
                if (--indegrees[cur]==0)queue.add(cur);
            }
        }
        return numCourses==0;
    }


    //方法二：DFS-》需要借助标志列表来标记
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        //创建adjacency接邻表与BFS的方法相同
        //创建接邻表
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] cp : prerequisites) {

            //通过列表实现有向图
            // cp[1]指向cp[0]
            adjacency.get(cp[1]).add(cp[0]);
        }
        //标志列表
        int[] flag=new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacency,flag,i)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adjacency, int[] flag, int i) {
        //递归跳出的两个条件
        if (flag[i]==1)return false;
        if (flag[i]==-1)return true;
        //遍历i指向的点
        //对flag[i]进行标记，递归跳出条件
        flag[i]=1;
        for (Integer j : adjacency.get(i)) {
            //递归判断
            if (!dfs(adjacency,flag,j))return false;
        }
        //递归完成之后,对i进行标记，表示已经被标记过
        flag[i]=-1;
        return true;

    }

}
