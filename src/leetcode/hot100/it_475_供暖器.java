package leetcode.hot100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 *
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 *
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 *
 * 先对 houseshouses 和 heatersheaters 进行排序，使用 ii 指向当前处理到的 houses[i]houses[i]；jj 指向 可能 覆盖到 houses[i]houses[i] 的最小下标 heaters[j]heaters[j]；xx 代表当前需要 check 的半径。
 *
 * 当且仅当 heaters[j] + x < houses[i]heaters[j]+x<houses[i] 时，houses[i]houses[i] 必然不能被 heaters[j]heaters[j] 所覆盖，此时让 jj 自增。
 *
 * 找到合适的 jj 之后，再检查 heaters[j] - x <= houses[i] <= heaters[j] + xheaters[j]−x<=houses[i]<=heaters[j]+x 是否满足，即可知道 houses[i]houses[i] 的覆盖情况。
 *
 * 使用二分法＋双指针操作
 *
 */
public class it_475_供暖器 {
    public static void main(String[] args) {
        int[] houses={1,2,3,4};
        int[] heaters={1,4};
        int res = new it_475_供暖器().findRadius(houses, heaters);
        System.out.println(res);
    }
    public int findRadius(int[] houses, int[] heaters) {
        //先排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l=0,r= (int) 1e9;
        while (l<r){
            int mid=l+r>>1;
            if (check(houses,heaters,mid)){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return r;
    }

    private boolean check(int[] houses, int[] heaters, int mid) {
        //双指针
        int i=0,j=0;
        for (; i <houses.length ;i++) {
            //若存在不能覆盖的情况，则进行自增，看下一个能不能覆盖
            while (j<heaters.length&&houses[i]>heaters[j]+mid){
                j++;
            }
            if (j<heaters.length&&heaters[j]-mid<=houses[i]&&heaters[j]+mid>=houses[i]){
                continue;
            }
            return false;
        }
        return true;
    }
}
