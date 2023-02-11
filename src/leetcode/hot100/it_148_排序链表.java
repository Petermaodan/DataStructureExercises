package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 */
public class it_148_排序链表 {
    public static void main(String[] args) {
        int [] nums = {4,2,1,3};
        IListNode head=IListNode.makeNode(nums);
        IListNode newHead=new it_148_排序链表().sortList(head);
        ArrayList<Integer> result=IListNode.traverse(newHead);
        ListUtil.arrayOne(result);

    }

    //方法一：自顶向下的归并排序
    //先使用快慢指针找到链表中点，之后将两个链表分别排序，最后将排序后的链表merge
    public IListNode sortList(IListNode head) {
        if (head==null||head.next==null)return head;
        IListNode fast=head.next, slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //截断链表
        IListNode temp=slow.next;
        slow.next=null;
        IListNode left=sortList(head);
        IListNode right=sortList(temp);

        //合并链表,设置两个指针，从头部交替前进，比较大小，将小的加入合并链表头部
        IListNode h=new IListNode(0);
        IListNode res=h;
        while (left!=null&&right!=null){
            if (left.val<right.val){
                h.next=left;
                left=left.next;
            }else {
                h.next=right;
                right=right.next;
            }
            h=h.next;
        }
        h.next=left!=null?left:right;
        return res.next;
    }
}
