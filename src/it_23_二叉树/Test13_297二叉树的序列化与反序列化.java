package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，
 * 进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，
 * 采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 */
public class Test13_297二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        Integer[] rootval = {1,2,3,null,null,4,5};
        ITreeNode root = ITreeNode.makeTree(rootval);

        String data=new Test13_297二叉树的序列化与反序列化().serialize(root);
        System.out.println(data);

        ITreeNode rootresult=new Test13_297二叉树的序列化与反序列化().deserialize(data);
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
        StringBuilder sb=new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    public void serialize(ITreeNode root, StringBuilder sb) {
        if (root==null){
            sb.append(NULL).append(SEP);
            return;
        }
        //前序遍历开始的位置
        sb.append(root.val).append(SEP);
        serialize(root.left,sb);
        serialize(root.right, sb);
    }

    //根据空指针已经是#的特性构造二叉树
    // Decodes your encoded data to tree.
    public ITreeNode deserialize(String data) {
        //首先要将字符串转变为数组
        LinkedList<String> nodes=new LinkedList<>();
        for (String datum : data.split(SEP)) {
            nodes.addLast(datum);
        }
        return deserialize(nodes);

    }

    public ITreeNode deserialize(LinkedList<String> nodes) {
        //跳出递归的条件
        if (nodes.isEmpty())return null;
        //移除数组第一个
        String first=nodes.removeFirst();
        if (first.equals(NULL)){
            return null;
        }
        //前序遍历开始
        ITreeNode root=new ITreeNode(Integer.parseInt(first));
        root.left=deserialize(nodes);
        root.right=deserialize(nodes);

        return root;
    }
}
