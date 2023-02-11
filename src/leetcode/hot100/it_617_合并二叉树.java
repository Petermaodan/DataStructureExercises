package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.List;

public class it_617_合并二叉树 {
    public static void main(String[] args) {
        Integer[] nums1 = {1, 3, 2, 5, null, null, null};
        Integer[] nums2 = {2, 1, 3, null, 4, null, 7};
        ITreeNode tree1 = ITreeNode.makeTree(nums1);
        ITreeNode tree2 = ITreeNode.makeTree(nums2);
        ITreeNode res = new it_617_合并二叉树().mergeTrees(tree1, tree2);
        List<Integer> result = ITreeNode.sequenceTraverse(res);
        ListUtil.arrayOne(result);
    }

    public ITreeNode mergeTrees(ITreeNode root1, ITreeNode root2) {
        return addTrees(root1, root2);
    }

    private ITreeNode addTrees(ITreeNode root1, ITreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        ITreeNode root = new ITreeNode(root1.val + root2.val);
        root.left = addTrees(root1.left, root2.left);
        root.right = addTrees(root1.right, root2.right);
        return root;
    }

    public ITreeNode mergeTrees2(ITreeNode t1, ITreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        ITreeNode merged = new ITreeNode(t1.val + t2.val);
        merged.left = mergeTrees2(t1.left, t2.left);
        merged.right = mergeTrees2(t1.right, t2.right);
        return merged;
    }

}
