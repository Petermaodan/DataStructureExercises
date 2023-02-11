package leetcode.dailyTest;

/**
 * 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。
 *
 * 环线上的公交车都可以按顺时针和逆时针的方向行驶。
 *
 * 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
 *
 */
public class it_1184_公交站间的距离 {
    public static void main(String[] args) {
        int[] distance = {7,10,1,12,11,14,5,0};
        int  start = 7, destination = 2;
        int res = new it_1184_公交站间的距离().distanceBetweenBusStops(distance, start, destination);
        System.out.println(res);
    }

    //双指针前后模拟
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n=distance.length;
        int disA=0,disB=0;
        int i=start,j=start;
        while (i!=destination){
            disA+=distance[i];
            if (++i==n){
                i=0;
            }
        }
        //distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离
        while (j!=destination){
            if (--j<0){
                j=n-1;
            }
            disB+=distance[j];
        }

        return Math.min(disA,disB);
    }
}
