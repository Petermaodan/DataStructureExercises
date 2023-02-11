package leetcode.hot100;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 注意到障碍的个数不超过 200个，这说明网格中大部分的位置都不是障碍，只有极少一部分的位置是障碍。分析从source 无法走到 target 的情况，无非就是以下两种：
 *
 * source 被障碍完全包围，并且 target 不在包围圈中；
 * target 被障碍完全包围，并且source 不在包围圈中。
 *
 */
public class it_1036_逃离大迷宫 {
    public static void main(String[] args) {
        int[][] blocked = {{0,1},{1,0}};
        int[] source = {0,0}, target = {0,2};
        boolean possible = new it_1036_逃离大迷宫().isEscapePossible(blocked, source, target);
        System.out.println(possible);
    }

    static final int bound= (int) 1e6;
    static final int[][] direction={{1,0},{-1,0},{0,1},{0,-1}};
    //step是指障碍能围成的最大边
    int step=0;
    Set<String> set=new HashSet<String>();
    public boolean isEscapePossible(int[][] blocked,int[] source,int[] target){
        if (blocked.length<2){
            return true;
        }
        for (int[] ints : blocked) {
            set.add(ints[0]+""+ints[1]);
        }
        step=blocked.length*(blocked.length-1)/2;
        //防止target被围住
        return bfs(source,target)&&bfs(target,source);

    }

    private boolean bfs(int[] a, int[] b) {
        //记录节点是否走过
        Set<String> visited=new HashSet<>();
        //bfs一定是和队列结合使用
        Queue<int[]> queue=new LinkedList<>();

        queue.add(a);
        visited.add(a[0]+""+a[1]);
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            int x=temp[0],y=temp[1];
            //如果提前遇到终点，直接返回
            if (x==b[0]&&y==b[1]){
                return true;
            }

            //若大于step,则必定有路线可以出去
            if (visited.size()>step){
                return true;
            }
            //遍历四个方向
            for (int i = 0; i < 4; i++) {
                int newX=x+direction[i][0],newY=y+direction[i][1];
                String s=newX+""+newY;
                //剪枝操作，判断是否合法
                if (newX>=0&&newX<bound&&newY>=0&&newY<bound&&!visited.contains(s)&&!set.contains(s)){
                    queue.add(new int[]{newX,newY});
                    visited.add(s);
                }
            }
        }
        return false;
    }
}
