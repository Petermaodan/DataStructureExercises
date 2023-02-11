package leetcode.dailyTest;

/**
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
 *
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 
 *
 */
public class it_1037_有效的回旋镖 {
    public static void main(String[] args) {
        int[][] points = {{1,1},{2,3},{3,2}};
        boolean res = new it_1037_有效的回旋镖().isBoomerang(points);
        System.out.println(res);
    }
    public boolean isBoomerang(int[][] points) {
        if ((points[1][0]-points[0][0])*(points[2][1]-points[0][1])
        ==((points[2][0]-points[0][0])*(points[1][1]-points[0][1]))){
            return false;
        }
        return true;
    }
}
