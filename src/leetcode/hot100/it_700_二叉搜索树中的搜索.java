package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * 例如，
 * 给定二叉搜索树:
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和值: 2
 * 你应该返回如下子树:
 * <p>
 * 2
 * / \
 * 1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 */
public class it_700_二叉搜索树中的搜索 {
    public static void main(String[] args) {
        Integer[] nums={4,2,7,1,3,null,null};
        ITreeNode root = ITreeNode.makeTree(nums);
        ITreeNode node = new it_700_二叉搜索树中的搜索().searchBST(root, 2);
        ArrayList<Integer> list = ITreeNode.sequenceTraverse(node);
        ListUtil.arrayOne(list);
    }
    public ITreeNode searchBST(ITreeNode root, int val) {
        if (root==null||root.val==val)return root;
        return root.val<val?searchBST(root.right,val):searchBST(root.left,val);
    }
}
