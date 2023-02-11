package it_04_贪心;

import java.util.Arrays;
import java.util.Comparator;

public class test1 {
    public static void main(String[] args) {
        int[][] intvs={{1,3},{2,4},{3,6}};
//        int c=intervalSchedule(intvs);
//        System.out.println(c);

        int[][] intvs1={ {1,2}, {2,3}, {3,4}, {1,3} };

//        int result=eraseOverlapIntervals(intvs1);
//        System.out.println(result);

//        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points={{-2147483646,-2147483645},{2147483646,2147483647}};
        int result=findMinArrowShots(points);
        System.out.println(result);
    }

    private static int findMinArrowShots(int[][] points) {
        if (points.length==0){
            return 0;
        }
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }
//        });
        //测试用例溢出，无法通过。
        Arrays.sort(points,(o1,o2)->Integer.compare(o1[1],o2[1]));
        int count=1;
        int x_end=points[0][1];
        for (int[] point : points) {
            int start=point[0];
            if (start>x_end){
                x_end=point[1];
                count++;
            }
        }
        return count;

    }

    private static int eraseOverlapIntervals(int[][] intvs1) {
        int size=intvs1.length;
        if (size==0){
            return 0;
        }
        Arrays.sort(intvs1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1;
        int x_end=intvs1[0][1];
        for (int[] ints : intvs1) {
            int start=ints[0];
            if (start>=x_end){
                x_end=ints[1];
                count++;
            }
        }
        return size-count;

    }

    private static int intervalSchedule(int[][] intvs) {
        if (intvs.length==0){
            return 0;
        }
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1;
        int x_end=intvs[0][1];
        for (int[] intv : intvs) {
            if (intv[0]>=x_end){
                x_end=intv[1];
                count++;
            }
        }
        return count;

    }
}
