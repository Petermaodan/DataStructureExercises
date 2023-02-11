package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 可以借鉴k个一组反转链表的形式进行反转

 */
public class it_24_两两交换链表中的节点 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        IListNode head = IListNode.makeNode(nums);
        IListNode node = new it_24_两两交换链表中的节点().swapPairs(head);
        ArrayList<Integer> traverse = IListNode.traverse(node);
        ListUtil.arrayOne(traverse);
    }
    public IListNode swapPairs(IListNode head) {
        if (head==null)return null;
        IListNode a=head,b=head;
        for (int i = 0; i < 2; i++) {
            if (b==null)return head;
            b=b.next;
        }
        IListNode newHead=reverse(a,b);
        a.next=swapPairs(b);
        return newHead;
    }

    private IListNode reverse(IListNode a, IListNode b) {
        IListNode pre=null,cur=a,nxt=a;
        while (cur!=b){
            nxt=cur.next;
            cur.next=pre;

            pre=cur;
            cur=nxt;
        }
        return pre;
    }
}
