package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 *
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * 示例 1：
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class it_86_分隔链表 {
    public static void main(String[] args) {
        int[] nums={1};
        IListNode head = IListNode.makeNode(nums);
        IListNode res = new it_86_分隔链表().partition(head, 2);
        ArrayList<Integer> traverse = IListNode.traverse(res);
        ListUtil.arrayOne(traverse);
    }

    public IListNode partition(IListNode head, int x) {
        if (head==null)return null;
        IListNode lowValue=new IListNode(0);
        IListNode lowCur=lowValue;
        IListNode highValue=new IListNode(0);
        IListNode highCur=highValue;
        IListNode cur=head;
        while (cur!=null){
            if (cur.val<x){
                lowCur.next=new IListNode(cur.val);
                lowCur=lowCur.next;
            }else {
                highCur.next=new IListNode(cur.val);
                highCur=highCur.next;
            }
            cur=cur.next;
        }
        lowCur.next=highValue.next;
        return lowValue.next;
    }
}
