package it_22_递归反转链表;

import it_Base.IListNode;

import java.util.ArrayList;

public class Text3_判断回文单链表 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 2,1};
        IListNode head = new IListNode(nums.length).makeNode(nums);
        ArrayList<Integer> arrayList = head.traverse(head);
        for (Integer integer : arrayList) {
            System.out.print(integer);
            System.out.print("->");
        }
        System.out.println();

        System.out.println(new Text3_判断回文单链表().ispalindrome2(head));
    }


    //优化->使用快慢指针来寻找链表中点，将空间复杂度降到O(1)
    public boolean ispalindrome2(IListNode head){
        IListNode slow,fast;
        slow=fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //当fast指针未指向null，说明链表长度为奇数，slow还要前进一步
        if (fast!=null){
            slow=slow.next;
        }

        //从slow开始反转后面的列表
        IListNode left=head;
        IListNode right=reverse(slow);
        while (right!=null){
            if (left.val!=right.val)return false;
            left=left.next;
            right=right.next;
        }
        return true;

    }

    private IListNode reverse(IListNode head) {
        IListNode pre=null,cur=head,nxt=head;
        while (cur!=null){
            nxt=cur.next;
            //逐个结点反转
            cur.next=pre;
            //更新结点
            pre=cur;
            cur=nxt;
        }
        return pre;
    }


    //将链表压入一个栈中，元素的顺序自然就反过来了
//    IListNode left;
//    public   boolean ispalindrome(IListNode head) {
//         left=head;
//        return traverse(head);
//    }
//
//    private  boolean traverse(IListNode right) {
//        if (right==null)return true;
//        //压入栈中
//        boolean res=traverse(right.next);
//        //后序遍历代码
//        res=res&&(left.val==right.val);
//        //左指针右移
//        left=left.next;
//        return res;
//    }
}
