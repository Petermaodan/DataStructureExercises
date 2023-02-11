package leetcode.dailyTest;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class it_623_在二叉树中增加一行 {
    public static void main(String[] args) {
        Integer[] nums={4,2,6,3,1,5};
        ITreeNode node = ITreeNode.makeTree(nums);
        ITreeNode treeNode = new it_623_在二叉树中增加一行().addOneRow(node, 1, 2);
        ArrayList<Integer> arrayList = ITreeNode.sequenceTraverse(treeNode);
        ListUtil.arrayOne(arrayList);
    }
    public ITreeNode addOneRow(ITreeNode root, int val, int depth) {
        if (depth==1){
            ITreeNode newRoot= new ITreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        Deque<ITreeNode> deque=new ArrayDeque<>();
        deque.addLast(root);
        int idx=2;
        while (!deque.isEmpty()){
            if (idx==depth){
                int curLen=deque.size();
                for (int i = 0; i < curLen; i++) {
                    ITreeNode node = deque.pollFirst();
                    ITreeNode tempLeft=node.left;
                    ITreeNode tempRight=node.right;
                    node.left=new ITreeNode(val);
                    node.right=new ITreeNode(val);
                    node.left.left=tempLeft;
                    node.right.right=tempRight;
                }
                break;
            }
            int curLen=deque.size();
            for (int i = 0; i < curLen; i++) {
                ITreeNode node = deque.pollFirst();
                if (node.left!=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
            }
            idx++;
        }
        return root;
    }
}
