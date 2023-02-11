package niuke;

import it_Base.IListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
 * 拓展：
 * 你能给出不利用额外空间的解法么？
 */
public class it_19_链表中环的入口节点 {


    public IListNode detectCycle(IListNode head) {
        //方法一：使用一个hashSet来储存
//        Set<IListNode> visited=new HashSet<>();
//        while (head!=null){
//            if (visited.contains(head)){
//                return head;
//            }else {
//
//                visited.add(head);
//            }
//            head=head.next;
//        }
//        return null;

        //方法二：快慢指针推导->
        //fast走过的路程为slow的两倍-》a+n(b+c)+b（fast走过的路程）=2(a+b)(slow走过的路程)
        //从而可以推导出a=c+(n-1)(b+c)->pre从head开始走，正好可以和slow在入环点相遇
        IListNode fast,slow;
        fast=slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (fast==slow){
                IListNode pre=head;
                while (pre!=slow){
                    slow=slow.next;
                    pre=pre.next;
                }
                return pre;
            }
        }
        return null;
    }
}
