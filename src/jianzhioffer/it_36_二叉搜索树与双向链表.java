package jianzhioffer;

import it_Base.INode;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 *
 * 特别地，我们希望可以就地完成转换操作。
 * 当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
 * 还需要返回链表中的第一个节点的指针。
 *
 * 利用二叉搜索树中序遍历有序递增的特性
 */
public class it_36_二叉搜索树与双向链表 {

    INode head,pre;
    public INode treeToDoublyList(INode root) {
        if (root==null)return null;
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;
    }

    private void dfs(INode cur) {
        if (cur==null)return;//超过叶子节点，跳出循环
        //中序遍历
        dfs(cur.left);
        if (pre!=null)pre.right=cur;
        //递归到叶子节点
        else head=cur;
        //双向链表
        cur.left=pre;
        //更新pre
        pre=cur;
        //中序遍历递归右边
        dfs(cur.right);
    }

}
