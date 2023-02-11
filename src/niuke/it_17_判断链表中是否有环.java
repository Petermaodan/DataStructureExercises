package niuke;

import it_Base.IListNode;

/**
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * 你能给出空间复杂度的解法么？
 *
 * 思路，一般涉及到链表的问题可以考虑双指针
 */
public class it_17_判断链表中是否有环 {

    public boolean hasCycle(IListNode head) {
        if (head==null||head.next==null)return false;
        IListNode fast,slow;
        fast=slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast)return true;
        }
        return false;

    }
}
