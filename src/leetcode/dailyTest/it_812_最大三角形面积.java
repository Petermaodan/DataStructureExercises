package leetcode.dailyTest;

/**
 * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
 *
 * 示例:
 * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出: 2
 * 解释:
 * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
 */
public class it_812_最大三角形面积 {
    public static void main(String[] args) {
        int[][] points={{0,0},{0,1},{1,0},{0,2},{2,0}};
        double res = new it_812_最大三角形面积().largestTriangleArea(points);
        System.out.println(res);
    }
    public double largestTriangleArea(int[][] points) {
        double res=0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j <points.length; j++) {
                for (int k = j+1; k <points.length ; k++) {
                    int cur=cross(points[j][0]-points[i][0],points[j][1]-points[i][1],points[k][0]-points[i][0],points[k][1]-points[i][1]);
                    res=Math.max(res,Math.abs(cur/2.0));
                }
            }
        }
        return res;
    }

    private int cross(int x1, int y1, int x2, int y2){
        return Math.abs(x1*y2-x2*y1);
    }
}
