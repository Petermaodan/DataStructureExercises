package it_02_BFSDFS;

/*
public class BfsTest1_二叉树的深度 {
    public int minDepth(TreeINode root){
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);

        int step=0;

        while (queue!=null){
            int size=queue.size();
            for (int i = 0; i <size ; i++) {
                TreeNode node=queue.poll();
                if (node.left==null&&node.right==null){
                    return step;
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            step++;
        }
        return step;
    }
}*/
