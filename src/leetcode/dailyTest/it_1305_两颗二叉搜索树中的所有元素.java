package leetcode.dailyTest;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class it_1305_两颗二叉搜索树中的所有元素 {
    public static void main(String[] args) {
        Integer[] nums1={2,1,4};
        Integer[] nums2={1,0,3};
        ITreeNode root1 = ITreeNode.makeTree(nums1);
        ITreeNode root2 = ITreeNode.makeTree(nums2);
        List<Integer> res = new it_1305_两颗二叉搜索树中的所有元素().getAllElements(root1, root2);
        ListUtil.arrayOne(res);
    }

    List<Integer> list1=new ArrayList<>();
    List<Integer> list2=new ArrayList<>();
    public List<Integer> getAllElements(ITreeNode root1, ITreeNode root2) {
        dfs(root1,list1);
        dfs(root2,list2);
        List<Integer> res=new ArrayList<>();
        int i=0,j=0;
        int n=list1.size(),m=list2.size();
        while (i<n&&j<m){
            if (list1.get(i)<=list2.get(j)){
                res.add(list1.get(i++));
            }else {
                res.add(list2.get(j++));
            }
        }
        while (i<n){
            res.add(list1.get(i++));
        }
        while (j<m){
            res.add(list2.get(j++));
        }
        return res;
    }

    private void dfs(ITreeNode root, List<Integer> list) {
        if (root==null)return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right,list);
    }
}
