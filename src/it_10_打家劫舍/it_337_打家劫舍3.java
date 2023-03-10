package it_10_打家劫舍;
/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

 */

import it_Base.ITreeNode;

import java.util.HashMap;
import java.util.Map;

public class it_337_打家劫舍3 {
    public static void main(String[] args) {
        it_337_打家劫舍3 r=new it_337_打家劫舍3();
        Integer[] integers = {3, 2, 3, null, 3, null, 1};
        ITreeNode treeNode = ITreeNode.makeTree(integers);
        System.out.println(ITreeNode.middleTraverse(treeNode));
        int result=r.rob(treeNode);

        System.out.println(result);
        System.out.println("==========");
        System.out.println(r.rob2(treeNode));
    }
    Map<ITreeNode,Integer> memo=new HashMap<>();
    private  int rob(ITreeNode root) {
        if (root == null) return 0;
        // 利用备忘录消除重叠子问题
        if (memo.containsKey(root)){
            return memo.get(root);
        }
        //抢完这个只能抢下下个
        int do_it=root.val+(root.left==null?0:(rob(root.left.left)+rob(root.left.right)))+
                (root.right==null?0:(rob(root.right.left)+rob(root.right.right)));

        int not_do=rob(root.left)+rob(root.right);
        int res=Math.max(do_it,not_do);
        memo.put(root,res);
        return res;
    }

    private int rob2(ITreeNode root){
        int[] res=dp2(root);
        return Math.max(res[0],res[1]);
    }

    /* 返回一个大小为 2 的数组 arr
arr[0] 表示不抢 root 的话，得到的最大钱数
arr[1] 表示抢 root 的话，得到的最大钱数 */
    private int[] dp2(ITreeNode root) {
        if (root==null){
            return new  int[]{0,0};
        }
        int[] left=dp2(root.left);
        int[] right=dp2(root.right);
        // 抢，下家就不能抢了
        int do_it=root.val+left[0]+right[0];
        // 不抢，下家可抢可不抢，取决于收益大小
        int not_do=Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return new int[]{not_do,do_it};
    }
}
