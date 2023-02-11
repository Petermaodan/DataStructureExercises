package jianzhioffer2;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

/**
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class it_21_删除链表的倒数第n个节点 {
    public static void main(String[] args) {
        int[] head={1,2,3,4,5};
        IListNode node = IListNode.makeNode(head);
        IListNode node1 = new it_21_删除链表的倒数第n个节点().removeNthFromEnd(node, 2);
        ArrayList<Integer> traverse = IListNode.traverse(node1);
        ListUtil.arrayOne(traverse);
    }

    public IListNode removeNthFromEnd(IListNode head, int n) {
        IListNode dummy=new IListNode(0);
        dummy.next=head;
        IListNode fast=dummy,slow=dummy,cur=dummy;
        for (int i = 0; i < n; i++) {
            cur=cur.next;
        }
        fast=fast.next;
        while (cur.next!=null){
            cur=cur.next;
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=fast.next;
        return dummy.next;
    }
}
