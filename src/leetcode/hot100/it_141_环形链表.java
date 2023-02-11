package leetcode.hot100;

import it_Base.IListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false
 *
 */
public class it_141_环形链表 {
    //方法一：遍历所有结点，用哈希表储存已经被访问过的结点
    public boolean hasCycle(IListNode head) {
        Set<IListNode> seen=new HashSet<IListNode>();
        while (head!=null){
            if (!seen.add(head)){
                return true;
                
            }
            head=head.next;
        }
        return false;
    }
    //方法二：快慢指针，因为While循环条件优先于循环体，所以两个指针不能都置于head
    public boolean hasCycle2(IListNode head){
        if (head==null||head.next==null){
            return false;
        }
        IListNode slow=head;
        IListNode fast=head.next;
        while (fast!=slow){
            if (fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
