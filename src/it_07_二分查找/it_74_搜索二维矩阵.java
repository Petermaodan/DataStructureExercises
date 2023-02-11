package it_07_二分查找;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
对于有规律的 矩阵最好可以使用路径法
 */
public class it_74_搜索二维矩阵 {
    public static void main(String[] args) {

        int[][] matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=3;
        boolean res=new it_74_搜索二维矩阵().searchMatrix(matrix,target);
        System.out.println(res);

    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length-1,col=0;
        while (row>=0&&col<=matrix[0].length-1){
            if (matrix[row][col]==target){
                return true;
            }else if (matrix[row][col]>target){
                row--;
            }else {
                col++;
            }
        }
        return false;
}

//    public int binarySearch()
}
