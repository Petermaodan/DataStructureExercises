package jianzhioffer2;

import it_Base.ITreeNode;

import java.util.Stack;

public class it_55_二叉搜索树迭代器 {

    class BSTIterator {

        Stack<Integer> stack;

        public BSTIterator(ITreeNode root) {
            stack = new Stack<>();
            dfs(root);
        }

        private void dfs(ITreeNode root) {
            if (root==null){
                return;
            }
            dfs(root.right);
            stack.add(root.val);
            dfs(root.left);
        }

        public int next() {
            if (!stack.isEmpty()){
                return stack.pop();
            }
            return -1;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
