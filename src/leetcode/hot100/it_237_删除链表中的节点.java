package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.IListNode;

import java.util.ArrayList;

/**
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 *
 * 题目数据保证需要删除的节点 不是末尾节点 。
 *

 *思路：
 * 由于我们只知道待删除节点本身，同时该链表为单链表（无法访问前一节点），因此我们只能先将后一节点的值复制到当前节点，然后将后一节点当作「待删除节点」来进行常规删除。
 *

 */
public class it_237_删除链表中的节点 {
    public static void main(String[] args) {
        int[] num={4,5,1,9};
        IListNode node = IListNode.makeNode(num);
        IListNode tempNode=node.next;
        new it_237_删除链表中的节点().deleteNode(tempNode);
        ArrayList<Integer> traverse = IListNode.traverse(node);
        ListUtil.arrayOne(traverse);
    }
    public void deleteNode(IListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
