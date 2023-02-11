package leetcode.dailyTest;

import it_23_二叉树.Test10_删除二叉搜索树的节点;
import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * 有两个子节点，麻烦了，为了不破坏 BST 的性质，A必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己。我们以第二种方式讲解。
 */
public class it_450_删除二叉搜索树中的节点 {
    public static void main(String[] args) {
        Integer[] rootval={5,3,6,2,4,null,7};
        ITreeNode root=ITreeNode.makeTree(rootval);
        ITreeNode rootresult=new it_450_删除二叉搜索树中的节点().deleteNode(root,3);
        ArrayList<Integer> arrayList=ITreeNode.sequenceTraverse(rootresult);
        for (Integer integer : arrayList) {
            System.out.print(integer+" ");
        }
    }

    public ITreeNode deleteNode(ITreeNode root, int key) {
        if (root==null){
            return null;
        }
        if (root.val==key){
            if (root.left==null){
                return root.right;
            }
            if (root.right==null){
                return root.left;
            }
            ITreeNode minNode=getMin(root.right);
            root.val=minNode.val;
            //删除右边的最小值
            root.right=deleteNode(root.right,minNode.val);
        }else if (root.val>key){
            root.left=deleteNode(root.left,key);
        }else if (root.val<key){
            root.right=deleteNode(root.right,key);
        }
        return root;
    }

    private ITreeNode getMin(ITreeNode root) {
        while (root.left!=null){
            root=root.left;
        }
        return root;
    }
}
