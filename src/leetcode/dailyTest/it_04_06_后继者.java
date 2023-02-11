package leetcode.dailyTest;

import it_Base.ITreeNode;

/**
 *设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * 若节点存在右子树，那么该最小值为右子树的最左叶节点；若无右子树，该最小值为进左子树时的父节点；再没有就是空了。
 * 我们维护一个进左子树时的父节点即可。
 */
public class it_04_06_后继者 {

    public ITreeNode inorderSuccessor(ITreeNode root, ITreeNode p) {
        ITreeNode parent=null,cur=root;
        while (cur!=null){
            if (cur.val>p.val){
                parent=cur;
                cur=cur.left;
            }else if (cur.val<p.val){
                cur=cur.right;
            }else if (cur.right!=null){
                cur=cur.right;
                while (cur.left!=null){
                    cur=cur.left;
                }
                return cur;
            }else {
                return parent;
            }
        }
        return parent;
    }
}

