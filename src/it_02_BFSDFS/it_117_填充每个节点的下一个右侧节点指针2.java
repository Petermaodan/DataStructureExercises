package it_02_BFSDFS;

import it_Base.ITreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 输入：root = [1,2,3,4,5,null,7]
 输出：[1,#,2,3,#,4,5,7,#]
 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。

 算法如下：初始化一个队列 qq，将根结点放入队列中。当队列不为空的时候，
 记录当前队列大小为 nn，从队列中以此取出 nn 个元素并通过这 nn 个元素拓展新节点。
 如此循环，直到队列为空。我们不难写出这样的代码：

 最后的一个节点不需要判定next指向null，默认指向null


 */

public class it_117_填充每个节点的下一个右侧节点指针2 {

    public ITreeNode connect(ITreeNode root) {
        if (root==null)return null;
        Queue<ITreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n=queue.size();
            //中间变量
            ITreeNode temp=null;
            for (int i = 0; i < n; i++) {
                ITreeNode node=queue.poll();
                if (node.left!=null)queue.offer(node.left);
                if (node.right!=null)queue.offer(node.right);
                //判断是不是第一个节点
                if (i!=0){
                    temp.next=node;
                }
                temp=node;
            }
        }
        return root;

    }
}
