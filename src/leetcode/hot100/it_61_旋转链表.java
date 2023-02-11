package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class it_61_旋转链表 {
    public static void main(String[] args) {
        int[] nums = {1};
        IListNode node = IListNode.makeNode(nums);
        int k = 1;
        IListNode res = new it_61_旋转链表().rotateRight(node, k);
        ArrayList<Integer> traverse = IListNode.traverse(res);
        ListUtil.arrayOne(traverse);
    }

    public IListNode rotateRight(IListNode head, int k) {
        if (head==null||k==0)return head;
        int len = 0;
        IListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        k %= len;
        IListNode fast = head, slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        IListNode res = slow.next;
        slow.next = null;

        return res;
    }
}
