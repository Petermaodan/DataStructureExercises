package jianzhioffer;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * 注意：此题对比原题有改动
 *
 * 示例 1:
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class it_18_删除链表的节点 {
    public static void main(String[] args) {
        int[] nums={-3,5,-99};
        IListNode head = IListNode.makeNode(nums);
        int val=-3;
        IListNode res=new it_18_删除链表的节点().deleteNode(head,val);
        ArrayList<Integer> traverse = IListNode.traverse(res);
        ListUtil.arrayOne(traverse);
    }
    public IListNode deleteNode(IListNode head, int val) {
        //base case
        if (head.val==val)return head.next;
        //简化版本
        IListNode pre=head,cur=head.next;
        while (cur!=null){
            if (cur.val==val){
                pre.next=cur.next;
            }
            pre=cur;
            cur=cur.next;
        }
        return head;
    }
}
