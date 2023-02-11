package jianzhioffer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class it_04_二维数组中查找 {

    public static void main(String[] args) {
//        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] matrix={};
        int target = 5;
        boolean res = new it_04_二维数组中查找().findNumberIn2DArray2(matrix, target);
        System.out.println(res);

    }

    //方法四 初始化指针在左下角，向上和向右移动，不会删除正确答案，右边都比其大，上边都比其小；
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0)return false;
        int col = 0;
        int row = matrix.length - 1;
        while (col < matrix[0].length && row >= 0) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }


    //方法一：二分法搜索
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;


        //递归搜索对角线
        int minDim = Math.min(matrix.length - 1, matrix[0].length - 1);
        for (int i = 0; i <= minDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix, int target, int i, boolean vertical) {
        int lo = i;
        //判断是遍历行还是列
        int hi = vertical ? matrix[0].length - 1 : matrix.length - 1;
        //二分法常规代码
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            //判断是遍历行还是列
            if (vertical) {
                //行固定
                if (matrix[i][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[i][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else {
                //列固定
                if (matrix[mid][i] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][i] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
