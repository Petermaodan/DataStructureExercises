package leetcode.hot100;
/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 进阶：你能尝试使用一趟扫描实现吗
 */

import it_Base.IListNode;

import java.util.ArrayList;

public class it_19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        IListNode iListNode = IListNode.makeNode(nums);
        ArrayList<Integer> res1=IListNode.traverse(iListNode);
        for (Integer integer : res1) {
            System.out.print(integer+"->");
        }
        System.out.println("=======================");

        ArrayList<Integer> res2=IListNode.traverse(new it_19_删除链表的倒数第N个结点()
                .removeNthFromEnd2(iListNode,2));
        for (Integer integer : res2) {
            System.out.print(integer+"->");
        }

    }

    //只需遍历一遍链表即可
    public IListNode removeNthFromEnd2(IListNode head, int n){
        IListNode dummy=new IListNode(0);
        dummy.next=head;
        IListNode p=dummy;
        IListNode q=dummy;
        for (int i = 0; i < n+1 ; i++) {
            q=q.next;
        }
        while (q!=null){
            p=p.next;
            q=q.next;
        }
        p.next=p.next.next;
        IListNode ans=dummy.next;
        return ans;
    }

    //为了与题目中的 nn保持一致，节点的编号从 1 开始，头节点为编号 1 的节点。
    //一种容易想到的方法是，我们首先从头节点开始对链表进行一次遍历，
    // 得到链表的长度 LL。随后我们再从头节点开始对链表进行一次遍历，
    // 当遍历到第 L-n+1L−n+1 个节点时，它就是我们需要删除的节点。

    public IListNode removeNthFromEnd(IListNode head, int n) {
        IListNode dummy=new IListNode(0);
        dummy.next=head;
        int L=getLength(head);
        IListNode cur=dummy;
        for (int i = 1; i <L-n+1 ; i++) {
            cur=cur.next;
        }
        cur.next=cur.next.next;
        IListNode ans=dummy.next;
        return ans;
    }

    private int getLength(IListNode head) {
        int i=0;
        while (head!=null){
            head=head.next;
            i++;
        }
        return i;
    }
}
