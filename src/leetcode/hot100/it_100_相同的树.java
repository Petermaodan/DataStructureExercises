package leetcode.hot100;

import com.sun.media.jfxmediaimpl.HostUtils;
import it_Base.ITreeNode;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1：
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 */
public class it_100_相同的树 {
    public static void main(String[] args) {
        Integer[] nums1 = {1, null, 3};
        Integer[] nums2 = {1, 2, 3};
        ITreeNode node1 = ITreeNode.makeTree(nums1);
        ITreeNode node2 = ITreeNode.makeTree(nums2);
        boolean res = new it_100_相同的树().isSameTree(node1, node2);
        System.out.println(res);
    }

    public boolean isSameTree(ITreeNode p, ITreeNode q) {
        if (p == null && q == null) return true;
        if (p==null||q==null)return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
