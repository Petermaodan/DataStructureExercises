package jianzhioffer2;

import it_Base.IListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。

 */
public class it_22_链表中环的入口节点 {
    public static void main(String[] args) {
        int[] nums={3,2,0,4};
        IListNode head = IListNode.makeNode(nums);
    }
    public IListNode detectCycle(IListNode head) {
        Set<IListNode> visited=new HashSet<>();
        IListNode cur=head;
        while (cur!=null){
            if (!visited.contains(cur)){
                visited.add(cur);
            }else {
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }

    public IListNode detectCycle2(IListNode head) {
        //快慢指针
        IListNode fast=head,slow=head;
        while (fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                IListNode pre=head;
                while (pre!=slow){
                    pre=pre.next;
                    slow=slow.next;
                }
                return pre;
            }
        }
        return null;
    }
}
