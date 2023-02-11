package niuke;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

public class moni8_原地交替合并链表 {
    public static void main(String[] args) {
        int[] list1={1,2,3,4};
        IListNode head = IListNode.makeNode(list1);
        new moni8_原地交替合并链表().reorderList(head);
        ArrayList<Integer> traverse = IListNode.traverse(head);
        ListUtil.arrayOne(traverse);
    }


    public void reorderList(IListNode head) {
        IListNode slow=head,fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        IListNode temp=slow.next;
        slow.next=null;
        IListNode head2=reserve(temp);

        merge(head,head2);
    }

    private IListNode reserve(IListNode head) {
        IListNode pre,cur,nxt;
        pre=null;
        cur=head;nxt=head;
        while (cur!=null){
            nxt=cur.next;
            cur.next=pre;

            pre=cur;
            cur=nxt;
        }
        return pre;
    }

    public  void merge(IListNode head1,IListNode head2){

        while (head2!=null){
            IListNode temp=head2.next;
            head2.next=head1.next;
            head1.next=head2;
            head1=head2.next;
            head2=temp;
        }
    }
}
