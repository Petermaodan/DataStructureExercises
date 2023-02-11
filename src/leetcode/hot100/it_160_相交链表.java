package leetcode.hot100;

import it_Base.IListNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 * 创建两个指针 pApA 和 pBpB，分别初始化为链表 A 和 B 的头结点。然后让它们向后逐结点遍历。
 * 当 pApA 到达链表的尾部时，将它重定位到链表 B 的头结点 (你没看错，就是链表 B); 类似的，当 pBpB 到达链表的尾部时，将它重定位到链表 A 的头结点。
 * 若在某一时刻 pApA 和 pBpB 相遇，则 pApA/pBpB 为相交结点。
 *
 */
public class it_160_相交链表 {
    public static void main(String[] args) {
        int[] nums1={1,3,5,7,9,11};
        int[] nums2={2,4,9,11};
        IListNode[] nodes=IListNode.makeIntersectNode(nums1,4,nums2,2);
        IListNode headA=nodes[0];
        IListNode headB=nodes[1];
        IListNode res=new it_160_相交链表().getIntersectionNode(headA,headB);
        System.out.println(res.val);
    }

    public IListNode getIntersectionNode(IListNode headA, IListNode headB) {
        if (headA==null||headB==null)return null;

        //双指针
        IListNode head1=headA;
        IListNode head2=headB;
        while (head1!=head2){
            if (head1!=null){
                head1=head1.next;
            }else {
                head1=headB;
            }
            if (head2!=null){
                head2=head2.next;
            }else {
                head2=headA;
            }
        }
        return head1;
    }
}
