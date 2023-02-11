package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *

 */
public class it_590_N叉树的后续遍历 {
    public static void main(String[] args) {
        Integer[] root = {1,null,3,2,4,null,5,6};
        ITreeNode node = ITreeNode.makeTree(root);
        List<Integer> postorder = new it_590_N叉树的后续遍历().postorder(node);
        ListUtil.arrayOne(postorder);
    }

    List<Integer> res=new ArrayList<>();
    public List<Integer> postorder(ITreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(ITreeNode root) {
        if (root==null)return;
        for (ITreeNode child : root.children) {
            dfs(child);
        }
        res.add(root.val);
    }
}
