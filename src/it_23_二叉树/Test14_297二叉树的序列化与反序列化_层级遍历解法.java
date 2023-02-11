package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test14_297二叉树的序列化与反序列化_层级遍历解法 {
    public static void main(String[] args) {
        Integer[] rootval = {1,2,3,null,null,4,5};
        ITreeNode root = ITreeNode.makeTree(rootval);

        String data=new Test14_297二叉树的序列化与反序列化_层级遍历解法().serialize(root);
        System.out.println(data);

        ITreeNode rootresult=new Test14_297二叉树的序列化与反序列化_层级遍历解法().deserialize(data);
        ArrayList<Integer> arrayList = ITreeNode.sequenceTraverse(rootresult);
        for (Integer integer : arrayList) {
            System.out.print(integer + " ");
        }
    }

    String SEP=",";
    String NULL="#";

    // Encodes a tree to a single string.
    //前序遍历序列化
    public String serialize(ITreeNode root) {

        //通过StringBuilder来储存字符串
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        // 初始化队列，将 root 加入队列
        Queue<ITreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            ITreeNode cur = q.poll();

            /* 层级遍历代码位置 */
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            /*****************/

            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }


    //根据空指针已经是#的特性构造二叉树
    // Decodes your encoded data to tree.
    public ITreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(SEP);
        // 第一个元素就是 root 的值
        ITreeNode root = new ITreeNode(Integer.parseInt(nodes[0]));

        // 队列 q 记录父节点，将 root 加入队列
        Queue<ITreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < nodes.length; ) {
            // 队列中存的都是父节点
            ITreeNode parent = q.poll();
            // 父节点对应的左侧子节点的值
            String left = nodes[i++];
            if (!left.equals(NULL)) {
                parent.left = new ITreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            } else {
                parent.left = null;
            }
            // 父节点对应的右侧子节点的值
            String right = nodes[i++];
            if (!right.equals(NULL)) {
                parent.right = new ITreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;

    }
}
