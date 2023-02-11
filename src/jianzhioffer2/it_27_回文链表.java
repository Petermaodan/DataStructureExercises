package jianzhioffer2;

import it_Base.IListNode;

import java.util.Stack;

/**
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * 示例 1：
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 */
public class it_27_回文链表 {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,2,1};
        IListNode head = IListNode.makeNode(nums);
        boolean res=new it_27_回文链表().isPalindrome2(head);
        System.out.println(res);
    }

    private boolean isPalindrome2(IListNode head) {
        IListNode slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if (fast!=null){
            //表明是链表长度为奇数
            slow=slow.next;
        }
        //反转从slow开始的链表
        IListNode right=reverse(slow);
        IListNode left=head;
        while (right!=null){
            if (right.val!=left.val){
                return false;
            }
            right=right.next;
            left=left.next;
        }
        return true;
    }

    private IListNode reverse(IListNode head) {
        IListNode cur=head,nxt=head;
        IListNode pre=null;
        while (cur!=null){
            nxt=cur.next;
            cur.next=pre;

            pre=cur;
            cur=nxt;
        }
        return pre;
    }

    public boolean isPalindrome(IListNode head) {
        Stack<Integer> stack=new Stack<>();
        IListNode cur=head;
        while (cur!=null){
            stack.add(cur.val);
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            if (cur.val==stack.pop()){
                cur=cur.next;
                continue;
            }
            return false;
        }
        return true;
    }
}
