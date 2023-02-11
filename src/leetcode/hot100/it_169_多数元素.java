package leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class it_169_多数元素 {
    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2};
        int res=new it_169_多数元素().majorityElement3(nums);
        System.out.println(res);

    }
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);
        int n=nums.length;
        int temp=0;
        int x=nums[0];
        int res=Integer.MAX_VALUE;
        for (int num : nums) {
            if (x==num){
                ++temp;
                if (temp>n/2){
                    res=x;
                }
            }else {
                //跳到该循环，表明之前已经比较过一次了，所以temp=1
                temp=1;
                x=num;
            }
        }
        return res;
    }


    //hashMap对数据进行储存
    public int majorityElement2(int[] nums){
        Map<Integer,Integer> counts=new HashMap<>();
        for (int num : nums) {
            counts.put(num,counts.getOrDefault(num,0)+1);
        }

        //对Map数组进行遍历，找出最大value对应的key
        Map.Entry<Integer,Integer> majorityMap=null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityMap==null||entry.getValue()>majorityMap.getValue()){
                majorityMap=entry;
            }
        }
        return majorityMap.getKey();
    }

    //排序之后求下标为n/2的值

    //摩尔投票法
    /**
     * 我们维护一个候选众数 candidate 和它出现的次数 count。初始时 candidate 可以为任意值，count 为 0；
     *
     * 我们遍历数组 nums 中的所有元素，对于每个元素 x，在判断 x 之前，如果 count 的值为 0，我们先将 x 的值赋予 candidate，随后我们判断 x：
     *
     * 如果 x 与 candidate 相等，那么计数器 count 的值增加 1；
     *
     * 如果 x 与 candidate 不等，那么计数器 count 的值减少 1。
     *
     * 在遍历完成后，candidate 即为整个数组的众数。
     *
     */
    public int majorityElement3(int[] nums){
        int count=0;
        Integer candidate=null;
        for (int num : nums) {
            if (count==0){//开始变
                candidate=num;
            }
            //判断count自增还是自减
            count+=(num==candidate)?1:-1;
        }
        return candidate;

    }
}
