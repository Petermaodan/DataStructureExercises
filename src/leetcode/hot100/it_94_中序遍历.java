package leetcode.hot100;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 非递归方法，通过一个显式的栈来实现
 */
public class it_94_中序遍历 {
    public static void main(String[] args) {
        Integer[] nums = {1,null,2,3};
        ITreeNode root=ITreeNode.makeTree(nums);
        ListUtil.arrayOne(new it_94_中序遍历().inorderTraversal(root));
    }
    public List<Integer> inorderTraversal(ITreeNode root) {
        ArrayList<Integer> res=new ArrayList<>();
        Deque<ITreeNode> stk=new LinkedList<>();
        //压入栈的条件
        while (root!=null||!stk.isEmpty()){
            while (root!=null){
                //push=将元素推送到由此列表表示的堆栈上。
                stk.push(root);
                //搜索所有左子树
                root=root.left;
            }
            //深度搜索完成之后，出栈
            root=stk.pop();
            res.add(root.val);
            //搜索添加的对应的右子树
            root=root.right;
        }
        return res;
    }
}
