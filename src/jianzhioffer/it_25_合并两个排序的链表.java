package jianzhioffer;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class it_25_合并两个排序的链表 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        int[] nums2 = {1, 3, 4};
        IListNode l1 = IListNode.makeNode(nums);
        IListNode l2 = IListNode.makeNode(nums2);
        IListNode res = new it_25_合并两个排序的链表().mergeTwoLists(l1, l2);
        ArrayList<Integer> traverse = IListNode.traverse(res);
        ListUtil.arrayOne(traverse);
    }

    public IListNode mergeTwoLists(IListNode l1, IListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        IListNode pre = new IListNode(0);
        IListNode head=pre;

        while (l1 != null && l2 != null) {
            if (l1 .val <= l2.val) {
                head.next = l1 ;
                l1  = l1 .next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1  == null) {
            head.next = l2;
        } else {
            head.next = l1 ;
        }
        return pre.next;

    }
}
