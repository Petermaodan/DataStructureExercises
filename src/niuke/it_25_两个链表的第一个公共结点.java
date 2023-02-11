package niuke;

import it_Base.IListNode;

/**
 * 输入两个无环的单链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class it_25_两个链表的第一个公共结点 {

    public IListNode FindFirstCommonNode(IListNode pHead1, IListNode pHead2) {
        if (pHead1==null||pHead2==null)return null;

        IListNode head1=pHead1;
        IListNode head2=pHead2;
        while (head1!=head2){
            if (head1!=null){
                head1=head1.next;
            }else {
                head1=pHead2;
            }

            if (head2!=null){
                head2=head2.next;
            }else {
                head2=pHead1;
            }
        }
        return head1;

    }
}
