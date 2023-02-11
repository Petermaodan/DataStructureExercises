package jianzhioffer;

import it_Base.IListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class it_24_反转链表 {

    //非递归法
    public IListNode reverseList2(IListNode head){
        IListNode pre,cur,nxt;
        pre=null;
        cur=nxt=head;
        while (cur!=null){
            nxt=cur.next;
            //反转
            cur.next=pre;

            //更新指针
            pre=cur;
            cur=nxt;
        }
        return pre;
    }

    //递归法
    public IListNode reverseList(IListNode head) {
        if (head==null||head.next==null)return head;
        IListNode last=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
}
