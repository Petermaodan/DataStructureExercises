package it_23_二叉树;

import it_Base.ITreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 使用后序遍历解决
 */
public class Test6_寻找重复的子树 {
    public static void main(String[] args) {
        Integer[] tree={1,2,3,4,2,4,4};
        ITreeNode root=ITreeNode.makeTree(tree);
        List<ITreeNode> list =new Test6_寻找重复的子树().findDuplicateSubtrees(root);
        for (ITreeNode treeNode : list) {
            System.out.print(treeNode.val+" ");
        }
    }

    HashMap<String,Integer> memo=new HashMap<>();
    LinkedList<ITreeNode> res=new LinkedList<>();

    public List<ITreeNode> findDuplicateSubtrees(ITreeNode root) {
        traverse(root);
        return res;
    }

    //将二叉树序列化
    public String traverse(ITreeNode root) {
        //空节点用特殊字符表示
        if (root==null){
            return "#";
        }
        //将左右子树序列化成字符串
        String left=traverse(root.left);
        String right=traverse(root.right);

        String subTree=left+","+right+","+root.val;
        //将序列化后的结果与哈希表进行比较
        int freq=memo.getOrDefault(subTree,0);
        //保证即使重复，也只加入列表一次
        if (freq==1){
            res.add(root);
        }
        memo.put(subTree,freq+1);
        return subTree;
    }
}
