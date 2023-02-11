package jianzhioffer;

import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

public class it_54_二叉搜索树的第k大节点 {
    public static void main(String[] args) {
        Integer[] nums={3,1,4,null,2};
        ITreeNode root = ITreeNode.makeTree(nums);
        int k=1;
        int res = new it_54_二叉搜索树的第k大节点().kthLargest(root, k);
        System.out.println(res);
    }

    //优化
    int res=0,count=0;
    public int kthLargest(ITreeNode root, int k) {
        dfs(root,k);
        return res;
    }

    private void dfs(ITreeNode root, int k) {
        if (root==null)return;
        dfs(root.right,k);
        if (++count==k){
            res=root.val;
            return;
        }
        dfs(root.left,k);
    }



//    List<Integer> res=new ArrayList<>();
//    public int kthLargest(ITreeNode root, int k) {
//        dfs(root);
//        return res.get(res.size()-k);
//    }
//
//    private void dfs(ITreeNode root) {
//        if (root==null)return;
//        dfs(root.left);
//        res.add(root.val);
//        dfs(root.right);
//    }
}
