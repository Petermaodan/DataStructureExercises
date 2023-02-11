package niuke;

import it_Base.IListNode;

/**
 * 给定一个链表，删除链表的倒数第 nn 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
 * 删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.
 *
 * 备注：
 * 题目保证 nn 一定是有效的
 * 请给出请给出时间复杂度为\ O(n) O(n) 的算法
 *
 * 思路，涉及到链表的问题，使用双指针解决
 */
public class it_21_删除链表的倒数第n个节点 {
    public static void main(String[] args) {

    }
    /**
     *
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public IListNode removeNthFromEnd (IListNode head, int n) {
        // write code here
        if (head==null){
            return null;
        }

        IListNode fast,slow,pre;
        pre=new IListNode(0);
        pre.next=head;
        fast=slow=pre;
        int i=0;

        //最好画图观察在指针指向哪儿
        while (i<n&&fast.next!=null){
            fast=fast.next;
            i++;
        }
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return pre.next;
    }
}
