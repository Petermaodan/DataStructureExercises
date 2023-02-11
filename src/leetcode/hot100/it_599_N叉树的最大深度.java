package leetcode.hot100;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 */

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
public class it_599_N叉树的最大深度 {

    public int maxDepth2(Node root) {
        //跳出递归
        if (root==null)return 0;
        int ans=0;
        for (Node child : root.children) {
            ans=Math.max(ans,maxDepth2(child));
        }
        return ans+1;

    }


    public int maxDepth(Node root) {
        if (root==null)return 0;
        int maxStep=0;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int curLen=queue.size();
            for (int i = 0; i < curLen; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    queue.add(child);
                }
            }
            maxStep++;
        }
        return maxStep;
    }
}
