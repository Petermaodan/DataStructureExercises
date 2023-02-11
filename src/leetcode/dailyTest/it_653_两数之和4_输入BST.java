package leetcode.dailyTest;

import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true
 */
public class it_653_两数之和4_输入BST  {
    List<Integer> list=new ArrayList<>();
    public boolean findTarget(ITreeNode root, int k) {
        dfs(root);
        int l=0,r=list.size()-1;
        while (l<r){
            int sum=list.get(l)+list.get(r);
            if (sum<k){
                l++;
            }else if (sum>k){
                r--;
            }else {
                return true;
            }
        }
        return false;
    }

    private void dfs(ITreeNode root) {
        if (root==null)return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
