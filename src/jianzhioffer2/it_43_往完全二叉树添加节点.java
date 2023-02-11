package jianzhioffer2;

import it_Base.ITreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 *
 * CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的根节点。
 *  
 *
 * 示例 1：
 *
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 */
public class it_43_往完全二叉树添加节点 {
    class CBTInserter {

        Deque<ITreeNode> deque;
        ITreeNode root;
        public CBTInserter(ITreeNode root) {
            this.root=root;
            deque=new LinkedList<>();
            deque.addLast(root);
            while (deque.peekFirst().left!=null&&deque.peekFirst().right!=null){
                ITreeNode node = deque.pollFirst();
                deque.addLast(node.left);
                deque.addLast(node.right);
            }
        }

        public int insert(int v) {
            ITreeNode front = deque.peekFirst();
            if (front.left==null){
                front.left=new ITreeNode(v);
            }else {
                front.right=new ITreeNode(v);
                deque.pollFirst();
                deque.addLast(front.left);
                deque.addLast(front.right);
            }
            return front.val;
        }

        public ITreeNode get_root() {
            return root;
        }
    }
}
