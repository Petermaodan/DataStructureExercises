package jianzhioffer2;

/**
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 *
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。

 */
public class it_29_排序的循环链表 {
    public Node insert(Node head, int insertVal) {
        Node cur=head;
        Node temp=new Node(insertVal);
        if (cur==null){
            temp.next=temp;
            return temp;
        }

        while (cur.next!=head){
            if (cur.val<=insertVal&&cur.next.val>=insertVal){
                Node nxt=cur.next;
                cur.next=temp;
                temp.next=nxt;
                break;
            }
            if (cur.next.val<cur.val){
                if (insertVal>=cur.val||insertVal<=cur.next.val){
                    Node nxt=cur.next;
                    cur.next=temp;
                    temp.next=nxt;
                    break;
                }
            }
            cur=cur.next;
        }
        if (cur.next==head){
            cur.next=temp;
            temp.next=head;
        }
        return head;
    }
    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}


