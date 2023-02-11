package niuke;

import java.util.Arrays;

/**
 * 给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
 * 注意：
 * 可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和
 *
 * 采用逆向并归，这样就不会把A数组原有的元素覆盖掉，双指针
 */
public class it_18_合并两个有序的数组 {


    public void merge(int A[], int m, int B[], int n) {
        int i=m-1;
        int j=n-1;
        int index=m+n+-1;
        while (i>=0&&j>=0){
            A[index--]=A[i]>B[j]?A[i--]:B[j--];
        }
        //若A数组已经全部排完，就直接将B全部排进去就可以
        while (j>=0){
            A[index--]=B[j--];
        }
    }
}
