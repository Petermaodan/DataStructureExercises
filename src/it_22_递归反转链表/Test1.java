package it_22_递归反转链表;

import it_Base.IListNode;

import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        IListNode head=new IListNode(nums.length).makeNode(nums);
        ArrayList<Integer> arrayList=head.traverse(head);
        for (Integer integer : arrayList) {
            System.out.print(integer);
            System.out.print("->");
        }
        System.out.println();

        //反转整个链表
        ArrayList<Integer> arrayList2=head.traverse(new Test1().reverse(head));
        for (Integer integer : arrayList2) {
            System.out.print(integer);
            System.out.print("->");
        }

        //反转链表前N个节点
        int n=4;
        ArrayList<Integer> arrayList3=head.traverse(new Test1().reverseN(head,n));
        for (Integer integer : arrayList3) {
            System.out.print(integer);
            System.out.print("->");
        }

        //反转区间数组
        int l=2,m=4;
        ArrayList<Integer> arrayList4=head.traverse(new Test1().reverseBetween(head,l,m));
        for (Integer integer : arrayList4) {
            System.out.print(integer);
            System.out.print("->");
        }

    }

    IListNode successor=null;//后驱节点
//不知为何存在空指针异常的问题
    public IListNode reverseN(IListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        IListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }

    //递归的优美
    public IListNode reverse(IListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        IListNode last=reverse(head.next);
        //反转的关键点，下一个节点的下一个节点指向头节点
        head.next.next=head;
        head.next=null;
        return last;
    }

    public IListNode reverseBetween(IListNode head,int m,int n){
        //base case:
        if (m==1){
            return reverseN(head,n);
        }

        //前进到反转的起点触发base case:
        head.next=reverseBetween(head.next,m-1,n-1);
        return head;
    }
}
