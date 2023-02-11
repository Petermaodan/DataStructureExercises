package jianzhioffer2;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

/**
 * 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 示例1：
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]

 */
public class it_25_链表中的两数相加 {
    public static void main(String[] args) {
        int[] l1 = {7,2,4,3}, l2 = {5,6,4};
        IListNode head1 = IListNode.makeNode(l1);
        IListNode head2=IListNode.makeNode(l2);
        IListNode node = new it_25_链表中的两数相加().addTwoNumbers(head1, head2);
        ArrayList<Integer> traverse = IListNode.traverse(node);
        ListUtil.arrayOne(traverse);
    }
    public IListNode addTwoNumbers(IListNode l1, IListNode l2) {
        IListNode head1=reverse(l1);
        IListNode head2=reverse(l2);
        IListNode dummy=new IListNode(0);
        IListNode cur=dummy;
        int carry=0;
        while (head1!=null||head2!=null){
            int x=head1!=null?head1.val:0;
            int y=head2!=null?head2.val:0;
            int sum=x+y+carry;
            int temp=sum%10;
            carry=sum/10;
            cur.next=new IListNode(temp);
            cur=cur.next;
            head1=head1==null?null:head1.next;
            head2=head2==null?null:head2.next;
        }
        if (carry!=0){
            cur.next=new IListNode(carry);
        }
        return reverse(dummy.next);
    }

    private IListNode reverse(IListNode head) {
        IListNode pre=null;
        IListNode cur=head,nxt=head;
        while (cur!=null){
            nxt=cur.next;
            cur.next=pre;

            pre=cur;
            cur=nxt;
        }
        return pre;
    }
}
