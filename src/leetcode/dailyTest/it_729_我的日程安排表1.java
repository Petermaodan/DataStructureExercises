package leetcode.dailyTest;

import java.util.Map;
import java.util.TreeMap;

public class it_729_我的日程安排表1 {

    class MyCalendar {
        TreeMap<Integer,Integer> map;
        public MyCalendar() {
            map=new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);
            if (floorEntry!=null&&floorEntry.getValue()>start){
                return false;
            }
            if (ceilingEntry!=null&&ceilingEntry.getKey()<end){
                return false;
            }
            map.put(start,end);
            return true;
        }
    }
}
