package jianzhioffer2;

import java.util.Map;
import java.util.TreeMap;

/**
 * 请实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内没有其他安排，则可以存储这个新的日程安排。
 *
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 *
 * 当两个日程安排有一些时间上的交叉时（例如两个日程安排都在同一时间内），就会产生重复预订。
 *
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致重复预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 *
 * 平衡二叉树
 */
public class it_58_日程表 {

    class MyCalendar {

        TreeMap<Integer,Integer> map;
        public MyCalendar() {
            this.map=new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer,Integer> entryFloor=map.floorEntry(start);
            Map.Entry<Integer,Integer> entryCeiling=map.ceilingEntry(start);
            if (entryFloor!=null&&entryFloor.getValue()>start){
                return false;
            }
            if (entryCeiling!=null&&entryCeiling.getKey()<end){
                return false;
            }
            map.put(start,end);
            return true;
        }
    }
}
