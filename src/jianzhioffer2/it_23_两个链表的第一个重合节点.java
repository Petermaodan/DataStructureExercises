package jianzhioffer2;

import it_Base.IListNode;

/**
 * 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 *
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 *
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 *
 */
public class it_23_两个链表的第一个重合节点 {
    public IListNode getIntersectionNode(IListNode headA, IListNode headB) {
        IListNode cur1=headA,cur2=headB;

        while (cur1!=cur2){
            if (cur1!=null){
                cur1=cur1.next;
            }else {
                cur1=headB;
            }

            if (cur2!=null){
                cur2=cur2.next;
            }else {
                cur2=headA;
            }
        }
        return cur1;
    }
}
