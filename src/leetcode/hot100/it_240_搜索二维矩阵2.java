package leetcode.hot100;

public class it_240_搜索二维矩阵2 {
    public static void main(String[] args) {
       int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
       int target = 5;
       boolean res=new it_240_搜索二维矩阵2().searchMatrix(matrix,target);
       System.out.println(res);

    }

    //方法四 初始化指针在左下角，向上和向右移动，不会删除正确答案，右边都比其大，上边都比其小；
    private boolean searchMatrix(int[][] matrix, int target) {
        int col=0;
        int row=matrix.length-1;
        while (col<matrix[0].length&&row>=0){
            if (matrix[row][col]>target){
                row--;
            }else if (matrix[row][col]<target){
                col++;
            }else {
                return true;
            }
        }
        return false;
    }


    //二分法搜索，行和列分开同时搜索
    public boolean searchMatrix2(int[][] matrix, int target){
        if(matrix==null||matrix.length==0){
            return false;
        }

        //防止越界，遍历小的那个
        //在对角线上迭代，二分搜索行和列，直到对角线的迭代元素用完为止（意味着我们可以返回 false ）或者找到目标（意味着我们可以返回 true ）
        int shorterDim=Math.min(matrix.length,matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound=binarySearch(matrix,target,i,true);
            boolean horizontalFound=binarySearch(matrix,target,i,false);
            if (verticalFound||horizontalFound){
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo=start;
        //判断是遍历行还是列
        int hi=vertical?matrix[0].length-1:matrix.length-1;
        while (lo<=hi){
            //遍历列
            if (vertical){
                int mid=(lo+hi)/2;
                //行不变
                if (matrix[start][mid]<target){
                    lo=mid+1;
                }else if (matrix[start][mid]>target){
                    hi=mid-1;
                }else {
                    return true;
                }
            }else {
                //遍历行，列不变
                int mid=(lo+hi)/2;
                if (matrix[mid][start]<target){
                    lo=mid+1;
                }else if (matrix[mid][start]>target){
                    hi=mid-1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }
}
