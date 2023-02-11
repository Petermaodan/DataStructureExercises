package leetcode.dailyTest;

import BaseUtil.ListUtil;
import it_Base.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * 编码的字符串应尽可能紧凑。
 */
public class it_449_序列化和反序列化二叉搜索树 {
    public static void main(String[] args) {
        Integer[] nums={2,1,3};
        ITreeNode root = ITreeNode.makeTree(nums);
        Codec codec=new Codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        ITreeNode node = codec.deserialize(serialize);
        ArrayList<Integer> arrayList = ITreeNode.sequenceTraverse(node);
        ListUtil.arrayOne(arrayList);
    }

}

class Codec {

    List<String> list=new ArrayList<>();
    // Encodes a tree to a single string.
    public String serialize(ITreeNode root) {
        if (root==null)return null;
        StringBuilder builder=new StringBuilder();

        dfs(root);
        int n=list.size();
        for (int i = 0; i < n; i++) {
            builder.append(list.get(i));
            if (i!=n-1){
                builder.append(',');
            }
        }
        return builder.toString();
    }
    public void dfs(ITreeNode root){
        if (root==null)return;
        list.add(String.valueOf(root.val));
        dfs(root.left);
        dfs(root.right);
    }

    // Decodes your encoded data to tree.
    public ITreeNode deserialize(String data) {
        if (data==null)return null;
        String[] split = data.split(",");
        return reDfs(0,split.length-1,split);
    }
    public ITreeNode reDfs(int l,int r,String[] s){
        if (l>r){
            return null;
        }
        int j=l+1,value=Integer.parseInt(s[l]);
        ITreeNode root=new ITreeNode(value);
        while (j<=r&&Integer.parseInt(s[j])<=value){
            j++;
        }
        root.left=reDfs(l+1,j-1,s);
        root.right=reDfs(j,r,s);
        return root;
    }
}

