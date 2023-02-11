package leetcode.dailyTest;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 *
 * 实现 CBTInserter 类:
 *
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 *  

 */
public class it_919_完全二叉树插入器 {

    class CBTInserter {
        TreeNode root;
        Deque<TreeNode> deque;
        public CBTInserter(TreeNode root) {
            this.root=root;
            deque=new ArrayDeque<>();
            if (root!=null){
                deque.addLast(root);
            }
            out:
            while (!deque.isEmpty()){
                int curLen=deque.size();
                in:
                for (int i = 0; i < curLen; i++) {
                    TreeNode node = deque.peekFirst();
                    if (node.left!=null){
                        deque.addLast(node.left);
                    }
                    if (node.right!=null){
                        deque.addLast(node.right);
                    }
                    if (node.left==null||node.right==null){
                        break out;
                    }
                    deque.pollFirst();
                }
            }
        }

        public int insert(int val) {
            TreeNode preNode = deque.peekFirst();
            if (preNode.left==null){
                preNode.left=new TreeNode(val);
                deque.addLast(preNode.left);
            }else if (preNode.right==null){
                preNode.right=new TreeNode(val);
                deque.addLast(preNode.right);
                deque.pollFirst();
            }
            return preNode.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }


    class TreeNode {
        int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
             this.left = left;
             this.right = right;
          }
    }

}
