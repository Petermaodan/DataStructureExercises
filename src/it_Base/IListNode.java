package it_Base;

import java.util.ArrayList;

public class IListNode {
    public int val;
    public IListNode next;
    public IListNode random;
    public IListNode(int x) {
        val = x;
        next = null;
    }

    //创建单链表
    public static IListNode makeNode(int[] nums) {
        if (nums.length == 0) return null;
        IListNode IListNode = new IListNode(nums[0]);
        IListNode head = IListNode;
        for (int i = 1; i < nums.length; i++) {
            IListNode node = new IListNode(nums[i]);
            IListNode.next = node;
            IListNode = node;
        }
        return head;
    }

    /**
     *
     * @param nums
     * @param pos 需要循环的点
     * @return
     */
    //创建循环链表
    public static IListNode makeNode(int[] nums, int pos) {
        if (nums.length == 0) return null;
        IListNode[] IListNodes = new IListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            IListNodes[i] = new IListNode(nums[i]);
        }

        IListNode IListNode = IListNodes[0];
        for (int i = 1; i < IListNodes.length; i++) {
            IListNode.next = IListNodes[i];
            IListNode = IListNodes[i];
        }
        if (pos >= 0 && pos < nums.length) {
            IListNode.next = IListNodes[pos];
        }
        return IListNodes[0];
    }

    /**
     *
     * @param listA
     * @param skipA 交点
     * @param listB
     * @param skipB 交点
     * @return
     */
    //创建两条相交链表
    public static IListNode[] makeIntersectNode(int[] listA, int skipA, int[] listB, int skipB) {
        if (listA.length == 0 || listB.length == 0) return null;
        IListNode[] nodesA = new IListNode[listA.length];
        for (int i = 0; i < nodesA.length; i++) {
            nodesA[i] = new IListNode(listA[i]);
        }
        IListNode nodeA = nodesA[0];
        for (int i = 1; i < nodesA.length; i++) {
            nodeA.next = nodesA[i];
            nodeA = nodesA[i];
        }

        IListNode[] nodesB = new IListNode[listB.length];
        for (int i = 0; i < nodesB.length; i++) {
            nodesB[i] = new IListNode(listB[i]);
        }
        IListNode nodeB = nodesB[0];
        for (int i = 1; i < nodesB.length; i++) {
            nodeB.next = nodesB[i];
            nodeB = nodesB[i];
        }

        if (skipA < listA.length && skipB < listB.length && listA[skipA] == listB[skipB]) {
            nodesB[skipB].next = nodesA[skipA];
        }

        IListNode[] nodes = new IListNode[2];
        nodes[0] = nodesA[0];
        nodes[1] = nodesB[0];
        return nodes;
    }

    //遍历链表
    public static   ArrayList<Integer> traverse(IListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        return arrayList;
    }
}
