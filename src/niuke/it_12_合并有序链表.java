package niuke;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

public class it_12_合并有序链表 {
    public static void main(String[] args) {
        int[] list1={1,3,5};
        int[] list2={2,4,6};
        IListNode l1 = IListNode.makeNode(list1);
        IListNode l2 = IListNode.makeNode(list2);
        IListNode merge = new it_12_合并有序链表().merge(l1, l2);
        ArrayList<Integer> res = IListNode.traverse(merge);
        ListUtil.arrayOne(res);
    }

    /**
     *
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */

    //原地合并有序链表
    public IListNode merge(IListNode l1,IListNode l2){
        if (l1==null)return l2;
        if (l2==null)return l1;

        //使l1称为头节点最小的链表
        IListNode head=null;
        if (l1.val>l2.val){
            head=l1;
            l1=l2;
            l2=head;
        }
        head=l1;
        while (l1.next!=null&&l2!=null){
            if (l1.next.val<=l2.val){
                l1=l1.next;
            }else {
                IListNode temp=l2.next;
                l2.next=l1.next;
                l1.next=l2;
                l1=l2.next;
                l2=temp;
            }
        }
        //只需要关心l2即可
        if (l2!=null){
            l1.next=l2;
        }
        return head;


    }


    public IListNode mergeTwoLists (IListNode l1, IListNode l2) {
        // write code here
        if (l1==null)return l2;
        if (l2==null)return l1;

        //使用辅助头节点
        IListNode headList=new IListNode(0);
        IListNode tail=headList;
        while (l1!=null&&l2!=null){
            if (l1.val>l2.val){
                tail.next=l2;
                l2=l2.next;
            }else {
                tail.next=l1;
                l1=l1.next;
            }
            tail=tail.next;
        }
        tail.next=l1!=null?l1:l2;
        return headList.next;
    }


}
