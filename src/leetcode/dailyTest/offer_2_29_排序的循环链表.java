package leetcode.dailyTest;

/**
 * 给定循环单调非递减列表中的一个点，写一个函数向这个列表中插入一个新元素 insertVal ，使这个列表仍然是循环升序的。
 *
 * 给定的可以是这个列表中任意一个顶点的指针，并不一定是这个列表中最小元素的指针。
 *
 * 如果有多个满足条件的插入位置，可以选择任意一个位置插入新的值，插入后整个列表仍然保持有序。
 *
 * 如果列表为空（给定的节点是 null），需要创建一个循环有序列表并返回这个节点。否则。请返回原先给定的节点。
 *
 * 基本思路就是要判定在何时插入
 * 如果在中间插入，就是要比当前的大，比后一个节点小
 * 如果在首尾插入就是要比最后的大或者比最小的小
 */
public class offer_2_29_排序的循环链表 {
    public Node insert(Node head, int insertVal) {
        Node newNode=new Node(insertVal);
        Node cur=head;
        if (head==null){
            newNode.next=newNode;
            return newNode;
        }

        while (cur.next!=head){
            //第一种情况
            if (cur.val<=insertVal&&cur.next.val>=insertVal){
                Node nxt=cur.next;
                cur.next=newNode;
                newNode.next=nxt;
                break;
            }
            //第二种情况
            if (cur.next.val<cur.val){
                if (cur.val<=insertVal||cur.next.val>=insertVal){
                    Node nxt=cur.next;
                    cur.next=newNode;
                    newNode.next=nxt;
                    break;
                }
            }
            cur=cur.next;
        }
        if (cur.next==head){
            cur.next=newNode;
            newNode.next=head;
        }
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
