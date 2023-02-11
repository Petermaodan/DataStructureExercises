package leetcode.dailyTest;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 *
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * 示例 1:
 *
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 *
 */
public class it_599_两个列表的最小索引总和 {
    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"},
        list2 = {"KFC", "Shogun", "Burger King"};
        String[] restaurant = new it_599_两个列表的最小索引总和().findRestaurant(list1, list2);
        ListUtil.arrayStringStr(restaurant);

    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map=new HashMap<>();
        List<String> list=new ArrayList<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }
        int minSum=Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int tempSum=map.get(list2[i])+i;
                if (tempSum<minSum){
                    minSum=tempSum;
                    list.clear();
                    list.add(list2[i]);
                }else if (tempSum==minSum){
                    list.add(list2[i]);
                }else {
                    continue;
                }
            }
        }
        String[] res=new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
