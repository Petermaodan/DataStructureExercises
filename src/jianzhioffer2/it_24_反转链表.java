package jianzhioffer2;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

public class it_24_反转链表 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        IListNode node = IListNode.makeNode(nums);
        IListNode node1 = new it_24_反转链表().reverseList(node);
        ArrayList<Integer> traverse = IListNode.traverse(node1);
        ListUtil.arrayOne(traverse);
    }
    public IListNode reverseList(IListNode head) {
        IListNode pre,cur,nxt;
        pre=null;
        cur=head;
        nxt=head;
        while (cur!=null){
            nxt=cur.next;
            cur.next=pre;

            pre=cur;
            cur=nxt;
        }
        return pre;
    }
}
