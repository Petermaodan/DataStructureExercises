package niuke;

import it_Base.ITreeNode;

import java.util.ArrayList;

/**
 * 给定一个二叉树和一个值\ sum sum，请找出所有的根节点到叶子节点的节点值之和等于\ sum sum 的路径，
 * 例如：
 * 给出如下的二叉树，\ sum=22 sum=22，
 *
 * 返回
 * [
 * [5,4,11,2],
 * [5,8,9]
 * ]
 */
public class nc_8_二叉树根节点到叶子节点的和为sum {

    public static void main(String[] args) {

    }

    ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    ArrayList<Integer> track=new ArrayList<>();
    public ArrayList<ArrayList<Integer>> pathSum (ITreeNode root, int sum) {
        // write code here
        if (root==null)return new ArrayList<>();
        backtrack(root,sum,0);
        return res;
    }

    private void backtrack(ITreeNode root, int sum, int nowSum) {
        track.add(root.val);
        //当前节点是叶子节点
        if (root.left==null&&root.right==null&&sum==nowSum+root.val){
            res.add(new ArrayList<>(track));
        }
        if (root.left!=null){
            backtrack(root.left,sum,nowSum+root.val);
            track.remove(track.size()-1);
        }
        if (root.right!=null){
            backtrack(root.right,sum,nowSum+root.val);
            track.remove(track.size()-1);
        }
    }
}
