package jianzhioffer;

import it_Base.IListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 */
public class it_52_两个链表的第一个公共节点 {

    public IListNode getIntersectionNode(IListNode headA, IListNode headB) {
        if (headA==null||headB==null)return null;
        IListNode head1=headA;
        IListNode head2=headB;
        while (head1!=head2){
            if (head1!=null){
                head1=head1.next;
            }else {
                head1=headB;
            }
            if (head2!=null){
                head2=head2.next;
            }else {
                head2=headA;
            }
        }
        return head1;

    }
}
