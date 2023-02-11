package niuke;

import BaseUtil.ListUtil;
import it_Base.IListNode;
import leetcode.hot100.it_2_两数相加;

import java.util.ArrayList;

/**
 * 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 * 例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
 *
 * 注意，本题和两数相加存在较大不同，这个是链表末尾相加
 */
public class it_26_两个链表生成相加链表 {
    public static void main(String[] args) {
        int[] l1={2,4,3};
        int[] l2={5,6,4};
        IListNode node1= IListNode.makeNode(l1);
        IListNode node2= IListNode.makeNode(l2);

        IListNode resnode=new it_26_两个链表生成相加链表().addInList(node1,node2);
        ArrayList<Integer> arrayList=IListNode.traverse(resnode);
        ListUtil.arrayOne(arrayList);


    }

    /**
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public IListNode addInList (IListNode head1, IListNode head2) {
        // write code here
        IListNode headA=reverse(head1);
        IListNode headB=reverse(head2);
        //定义一个pre,防止cur指针在移动的时候丢失头指针
        IListNode pre=new IListNode(-1);
        IListNode cur=pre;
        int carry = 0;int sum=0;
        while (headA!=null||headB!=null){
            int x=headA==null?0:headA.val;
            int y=headB==null?0:headB.val;
            sum=x+y+carry;
            carry=sum/10;
            sum=sum%10;
            cur.next=new IListNode(sum);

            //指针后移
            cur=cur.next;
            if (headA!=null){
                headA=headA.next;
            }
            if (headB!=null){
                headB=headB.next;
            }
        }
        if (carry!=0){
            cur.next=new IListNode(carry);
        }
        return reverse(pre.next);
    }

    private IListNode reverse(IListNode head) {
        IListNode pre,cur,nxt;
        pre=null;
        cur=head;nxt=head;
        while (cur!=null){
            nxt=cur.next;
            //z逐个翻转结点
            cur.next=pre;

            //更新指针
            pre=cur;
            cur=nxt;

        }
        return pre;
    }
}
