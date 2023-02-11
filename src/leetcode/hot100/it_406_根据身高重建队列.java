package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
 * 每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 *
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，
 * 其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）
 *
 */
public class it_406_根据身高重建队列 {
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] res=new it_406_根据身高重建队列().reconstructQueue(people);
        ListUtil.arrayTowNums(res);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(person1, person2) ->{
            //根据身高降序排
            if (person1[0]!=person2[0]){
                return person2[0]-person1[0];
            }else {
                //身高相同，根据ki排序升序排
                return person1[1]-person2[1];
            }
        } );

        //插入新的数组
        List<int []> res=new ArrayList<>();
        for (int[] person : people) {
            //person[1]为插入位置，当位置上有对象时，他之后的直接向后移动一位，根据ArraysList的源码
            res.add(person[1],person);
        }

        //使用while循环原地改变
//        int i=0;
//        while (i<people.length){
//            if (i>people[i][1]){
//
//            }
//        }

        return res.toArray(new int[res.size()][]);

    }
}
