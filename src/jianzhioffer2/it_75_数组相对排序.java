package jianzhioffer2;

import BaseUtil.ListUtil;

import java.util.*;

/**
 * 给定两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 */
public class it_75_数组相对排序 {
    public static void main(String[] args) {
        int[] arr1={2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};
        int[] ints = new it_75_数组相对排序().relativeSortArray(arr1, arr2);
        ListUtil.arrayOneNums(ints);
    }
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for (int i : arr1) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int[] res=new int[arr1.length];
        int idx=0;
        for (int i : arr2) {
            Integer len = map.get(i);
            for (int j = idx; j <idx+len ; j++) {
                res[j]=i;
            }
            idx+=len;
            set.add(i);
        }
        for (int i : arr1) {
            if (!set.contains(i)){
                list.add(i);
            }
        }
        Collections.sort(list);
        for (int i = idx; i <res.length ; i++) {
            res[i]=list.get(i-idx);
        }
        return res;
    }
}
