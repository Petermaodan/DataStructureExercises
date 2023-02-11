package leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 */
public class it_677_键值映射 {
    public static void main(String[] args) {
        MapSum mapSum=new MapSum();
        mapSum.insert("a",3);
        int sum1 = mapSum.sum("ap");
        System.out.println(sum1);
        mapSum.insert("b",2);
        int sum2=mapSum.sum("a");
        System.out.println(sum2);

    }

    static class MapSum {
        Map<String,Integer> map;

        public MapSum() {
            map=new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key,val);
        }

        public int sum(String prefix) {
            int sum=0;
            int len=prefix.length();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key.length()>=len&&key.substring(0,len).equals(prefix)){
                    sum+=entry.getValue();
                }
            }
            return sum;

        }
    }
}
