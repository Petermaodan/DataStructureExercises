package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

public class it_83_删除排序链表中的重复元素 {
    public static void main(String[] args) {
        int[] nums={1,1,2,3,3};
        IListNode head = IListNode.makeNode(nums);
        IListNode node = new it_83_删除排序链表中的重复元素().deleteDuplicates(head);
        ArrayList<Integer> traverse = IListNode.traverse(node);
        ListUtil.arrayOne(traverse);
    }

    public IListNode deleteDuplicates(IListNode head) {
        if (head==null)return null;
        IListNode pre=head,cur=head;
        while (cur!=null){
            while (cur!=null&&cur.val==pre.val){
                cur=cur.next;
            }
            pre.next=cur;
            pre=cur;
        }
        return head;
    }
}
