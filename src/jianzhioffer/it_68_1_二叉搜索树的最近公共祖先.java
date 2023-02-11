package jianzhioffer;

import it_Base.ITreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 *
 * 时间复杂度 O(N)O(N) ： 其中 NN 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为 \log NlogN （满二叉树），最大为 NN （退化为链表）。
 * 空间复杂度 O(N)O(N) ： 最差情况下，即树退化为链表时，递归深度达到树的层数 NN 。
 *
 *
 */
public class it_68_1_二叉搜索树的最近公共祖先 {
    public static void main(String[] args) {
        Integer[] nums={6,2,8,0,4,7,9,null,null,3,5};
        ITreeNode root = ITreeNode.makeTree(nums);
        ITreeNode p=new ITreeNode(2);
        ITreeNode q=new ITreeNode(4);
        ITreeNode res=new it_68_1_二叉搜索树的最近公共祖先().lowestCommonAncestor(root,p,q);
        System.out.println(res.val);
    }

    public ITreeNode lowestCommonAncestor(ITreeNode root, ITreeNode p, ITreeNode q) {
        if ((root.val >= p.val && root.val <= q.val)||(root.val <=p.val && root.val >= q.val)){
            return root;
        }else if (root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if (root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return null;
    }
}
