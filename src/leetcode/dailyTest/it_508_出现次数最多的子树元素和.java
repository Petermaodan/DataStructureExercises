package leetcode.dailyTest;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class it_508_出现次数最多的子树元素和 {
    public static void main(String[] args) {
        Integer[] nums={3,1,5,0,2,4,6,null,null,null,3};
        ITreeNode root = ITreeNode.makeTree(nums);
        int[] frequentTreeSum = new it_508_出现次数最多的子树元素和().findFrequentTreeSum(root);
        ListUtil.arrayOneNums(frequentTreeSum);
    }

    Map<Integer,Integer> map=new HashMap<>();
    int max=0;
    public int[] findFrequentTreeSum(ITreeNode root) {
        dfs(root);
        List<Integer> list=new ArrayList<>();
        for (int k : map.keySet()) {
            if (map.get(k) == max) list.add(k);
        }
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = list.get(i);
        return ans;
    }

    private int dfs(ITreeNode root) {
        if (root==null){
            return 0;
        }

        int temp=root.val+dfs(root.left)+dfs(root.right);
        map.put(temp,map.getOrDefault(temp,0)+1);
        max=Math.max(max,map.get(temp));
        return temp;
    }
}
