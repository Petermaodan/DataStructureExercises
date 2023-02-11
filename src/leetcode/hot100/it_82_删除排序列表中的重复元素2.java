package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 返回同样按升序排列的结果链表。
 */

public class it_82_删除排序列表中的重复元素2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3};
        IListNode head = IListNode.makeNode(nums);
        IListNode res = new it_82_删除排序列表中的重复元素2().deleteDuplicates2(head);
        ArrayList<Integer> list = IListNode.traverse(res);
        ListUtil.arrayOne(list);
    }

    public IListNode deleteDuplicates(IListNode head) {
        IListNode preHead = new IListNode(0);
        preHead.next = head;
        IListNode pre = preHead;
        IListNode cur = head;

        while (cur != null) {
            //寻找重复的结点
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                //存在重复值的结点
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return preHead.next;

    }


    //通用方法，链表无序也可以使用
    public IListNode deleteDuplicates2(IListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        IListNode dummy = new IListNode(0);
        dummy.next = head;
        IListNode move = head;
        while (move != null) {
            map.put(move.val, map.getOrDefault(move.val, 0) + 1);
            move = move.next;
        }
        move = dummy;
        while (move != null && move.next != null) {
            while (move.next != null && map.getOrDefault(move.next.val, 0) >1) {
                move.next = move.next.next;
            }
            move = move.next;
        }
        return dummy.next;
    }
}
