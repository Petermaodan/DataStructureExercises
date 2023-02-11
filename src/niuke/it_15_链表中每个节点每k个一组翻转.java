package niuke;

import it_Base.IListNode;

/**
 * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 \ O(1) O(1)
 * 例如：
 * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
 * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
 * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
 */
public class it_15_链表中每个节点每k个一组翻转 {
    /**
     *
     * @param head ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public IListNode reverseKGroup (IListNode head, int k) {
        // write code here
        if (head==null)return null;
        IListNode a,b;
        a=b=head;
        //若列表长度小于k，直接不用翻转返回
        for (int i = 0; i < k; i++) {
            if (b==null)return head;
            b=b.next;
        }
        IListNode newHead=reverse(a,b);//特别注意，这个b是开区间，就是翻转区间[a,b)
        a.next=reverseKGroup(b,k);
        return newHead;
    }

    //使用类似双指针的形式翻转列表
    private IListNode reverse(IListNode a, IListNode b) {
        IListNode pre,cur,nxt;
        pre=null;cur=nxt=a;
        while (cur!=b){
            nxt=cur.next;
            //逐个翻转链表
            cur.next=pre;
            //更新指针
            pre=cur;
            cur=nxt;
        }
        return pre;
    }



}
