package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;
import jianzhioffer.it_07_从前序与中序遍历重建二叉树;

import java.util.*;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]

 */
public class it_199_二叉树的右视图 {
    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,3};
        int[] inorder = {4,2,5,1,3};
        ITreeNode root = new it_199_二叉树的右视图().buildTree(preorder, inorder);
        List<Integer> res = new it_199_二叉树的右视图().rightSideView(root);
        ListUtil.arrayOne(res);

    }
    public List<Integer> rightSideView(ITreeNode root) {
        if (root==null)return null;
        Queue<ITreeNode> queue=new LinkedList<>();
        List<Integer> res=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int curLen=queue.size();
            for (int i = 0; i < curLen; i++) {
                if (i==curLen-1)res.add(queue.peek().val);
                ITreeNode node=queue.poll();
                if (node.left!=null)queue.add(node.left);
                if (node.right!=null)queue.add(node.right);
            }
        }
        return res;
    }

    public ITreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private ITreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart>preEnd)return null;
        int preValue=preorder[preStart];
        int idx=0;
        for (int i = inStart; i <=inEnd ; i++) {
            if (preValue==inorder[i]){
                idx=i;
                break;
            }
        }

        ITreeNode root=new ITreeNode(preValue);
        int leftSize=idx-inStart;
        root.left=buildTree(preorder,preStart+1,preStart+leftSize,inorder,inStart,idx-1);
        root.right=buildTree(preorder,preStart+leftSize+1,preEnd,inorder,idx+1,inEnd);
        return root;
    }
}
