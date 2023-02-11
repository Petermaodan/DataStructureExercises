package it_22_递归反转链表;

import it_Base.IListNode;

import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5,6};
        IListNode head = new IListNode(nums.length).makeNode(nums);
        ArrayList<Integer> arrayList = head.traverse(head);
        for (Integer integer : arrayList) {
            System.out.print(integer);
            System.out.print("->");
        }
        System.out.println();

        //反转整个链表
        int k=2;
        ArrayList<Integer> arrayList2=head.traverse(new Test2().reverseKGroup(head,k));
        for (Integer integer : arrayList2) {
            System.out.print(integer);
            System.out.print("->");
        }
    }

    public IListNode reverseKGroup(IListNode head, int k) {
        if (head==null) return null;
        //区间[a,b)包含k个待反转元素
        IListNode a,b;
        a=b=head;
        for (int i = 0; i < k; i++) {
            //不足k个，不需要反转
            if (b==null) return head;
            b=b.next;
        }
        //反转前k个元素
        IListNode newHead=reverse(a,b);
        //将反转后的结点进行连接
        a.next=reverseKGroup(b,k);
        return newHead;
    }

    public IListNode reverse(IListNode a, IListNode b) {
        IListNode pre,cur,nxt;
        pre=null;
        cur=a;
        nxt=a;
        while (cur!=b){
            nxt=cur.next;
            //逐个结点反转
            cur.next=pre;
            //更新结点
            pre=cur;
            cur=nxt;
        }

        //返回反转后的头节点
        return pre;
    }
}
