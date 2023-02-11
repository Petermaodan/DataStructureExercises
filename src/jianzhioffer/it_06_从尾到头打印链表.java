package jianzhioffer;
//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;
import java.util.Stack;

public class it_06_从尾到头打印链表 {
    public static void main(String[] args) {
        int[] nums={};
        IListNode head = IListNode.makeNode(nums);
        int[] res=new it_06_从尾到头打印链表().reversePrint(head);
        ListUtil.arrayOneNums(res);
    }

    //借用辅助栈是实现
    public int[] reversePrint(IListNode head) {
        if (head==null)return new int[0];

        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();

        while (head!=null){
            stack.add(head.val);
            head=head.next;
        }
        int n=stack.size();
        for (int i = 0; i < n; i++) {
            list.add(stack.pop());
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
