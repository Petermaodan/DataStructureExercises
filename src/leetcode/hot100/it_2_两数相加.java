package leetcode.hot100;
/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 */

import it_Base.IListNode;

import java.util.ArrayList;

public class it_2_两数相加 {
    public static void main(String[] args) {
        int[] l1={2,4,3};
        int[] l2={5,6,4};
        IListNode node1= IListNode.makeNode(l1);
        IListNode node2= IListNode.makeNode(l2);

        IListNode resnode=new it_2_两数相加().addTwoNumbers(node1,node2);
        ArrayList<Integer> arrayList=IListNode.traverse(resnode);
        for (Integer integer : arrayList) {
            System.out.print(integer+"-");
        }


    }

    public IListNode addTwoNumbers(IListNode l1, IListNode l2) {
        //定义一个pre指针
        IListNode pre=new IListNode(0);
        IListNode cur=pre;
        int carry=0;
        while (l1!=null||l2!=null){
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int sum=x+y+carry;

            //carry携带进位的数据进入下一个节点
            carry=sum/10;
            //sum留在当前节点，及cur头节点的下一个节点
            sum=sum%10;
            cur.next=new IListNode(sum);
            //指针分别向后移
            cur=cur.next;
            if (l1!=null)l1=l1.next;
            if (l2!=null)l2=l2.next;
        }
        //若最终carry=1，这需要进一位
        if (carry==1){
            cur.next=new IListNode(carry);
        }
        //pre.next即为head节点
        return pre.next;
    }
}
