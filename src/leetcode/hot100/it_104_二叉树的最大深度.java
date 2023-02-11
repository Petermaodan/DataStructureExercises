package leetcode.hot100;

import it_Base.ITreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点
 */
public class it_104_二叉树的最大深度 {
    public static void main(String[] args) {
        Integer[] nums={3,9,20,null,null,15,7};
        ITreeNode root=ITreeNode.makeTree(nums);
        int res=new it_104_二叉树的最大深度().maxDepth2(root);
        System.out.println(res);
    }

    /**
     * 深度优先搜索
     * 如果我们知道了左子树和右子树的最大深度 ll 和 rr，那么该二叉树的最大深度即为
     *
     * \max(l,r) + 1
     * max(l,r)+1
     *
     * 而左子树和右子树的最大深度又可以以同样的方式进行计算。因此我们可以用「深度优先搜索」
     * 的方法来计算二叉树的最大深度。具体而言，在计算当前二叉树的最大深度时，可以先递归计算出其左子树和右子树的最大深度，
     * 然后在 O(1) 时间内计算出当前二叉树的最大深度。递归在访问到空节点时退出
     *
     *
     */
    public int maxDepth(ITreeNode root) {
        if (root==null){
            return 0;
        }
        int leftHeight=maxDepth(root.left);
        int rightHeight=maxDepth(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }

    /**
     * 广度优先搜索
     * 我们也可以用「广度优先搜索」的方法来解决这道题目，但我们需要对其进行一些修改，
     * 此时我们广度优先搜索的队列里存放的是「当前层的所有节点」。每次拓展下一层的时候，
     * 不同于广度优先搜索的每次只从队列里拿出一个节点，我们需要将队列里的所有节点都拿出来进行拓展，
     * 这样能保证每次拓展完的时候队列里存放的是当前层的所有节点，即我们是一层一层地进行拓展，
     * 最后我们用一个变量 \textit{ans}ans 来维护拓展的次数，该二叉树的最大深度即为 \textit{ans}ans

     */
    public int maxDepth2(ITreeNode root){
        if (root==null){
            return 0;
        }
        Queue<ITreeNode> queue=new LinkedList<>();
        int ans=0;
        queue.offer(root);
        while (!queue.isEmpty()){
            //用来将同一层的结点全部取出，同时将下一层的放入列队
            int size=queue.size();
            while (size>0){
                ITreeNode node=queue.poll();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }//同一层结束
            ans++;
        }
        return ans;
    }
}
