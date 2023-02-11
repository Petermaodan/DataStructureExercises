package niuke;

import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class it_5_求二叉树的层序遍历 {
    public static void main(String[] args) {

    }
    //使用列队解决
    public ArrayList<ArrayList<Integer>> levelOrder (ITreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> resList=new ArrayList<>();
        if (root==null)return resList;
        Queue<ITreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> subITreeNodes=new ArrayList<>();
            int i=queue.size();
            for (int j = 0; j < i; j++) {
                if (queue.peek().left!=null){
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right!=null){
                    queue.offer(queue.peek().right);
                }
                subITreeNodes.add(queue.poll().val);
            }
            resList.add(subITreeNodes);
        }
        return resList;

    }
}
