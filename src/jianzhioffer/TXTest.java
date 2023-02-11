package jianzhioffer;

import BaseUtil.ListUtil;
import it_Base.IListNode;
import it_Base.ITreeNode;

import java.util.*;

public class TXTest {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=sc.nextInt();
        }
        int res=new TXTest().sumNums(nums);
        System.out.println(res);
    }

    List<List<Integer>> res=new ArrayList<>();
    List<Integer> track=new ArrayList<>();
    private int sumNums(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        backtrack(nums,0);
        for (List<Integer> re : res) {
            sum+=(re.get(0)^re.get(1)^re.get(2)^re.get(3));
        }
        return sum%1000000007;

    }

    private void backtrack(int[] nums, int idx) {
        if (track.size()==4){
            res.add(new ArrayList<>(track));
            return;
        }
        if (idx>=nums.length){
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i+1);
            track.remove(track.size()-1);
        }
    }


//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int m=sc.nextInt();
//        int[] numsA=new int[n];
//        int[] numsB=new int[m];
//        for (int i = 0; i < m; i++) {
//            numsA[i]=sc.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            numsB[i]=sc.nextInt();
//        }
//        int res=pkAB(numsA,numsB);
//    }
//
//    private static int pkAB(int[] numsA, int[] numsB) {
//
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        int res = new Test().allSum(nums);
//        System.out.println(res);
//    }
//
//    List<List<Integer>> res = new ArrayList<>();
//    List<Integer> track = new ArrayList<>();
//
//    private int allSum(int[] nums) {
//        int sum = 0;
//        backtrack(nums, 0);
//        for (List<Integer> re : res) {
//            Collections.sort(re);
//            if (re.size() < 1) {
//                continue;
//            } else
//                sum = sum + re.get(0)%1000000007 + re.get(re.size() - 1)%1000000007;
//
//        }
//        return sum%1000000007;
//
//    }
//
//    private void backtrack(int[] nums, int idx) {
//        res.add(new ArrayList<>(track));
//        if (idx >= nums.length) {
//            return;
//        }
//        for (int i = idx; i < nums.length; i++) {
//            track.add(nums[i]);
//            backtrack(nums, i + 1);
//            track.remove(track.size() - 1);
//        }
//    }


//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
//        int[] nums=new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i]=sc.nextInt();
//        }
//        int[] ints = twoNumsSqrt(nums);
//        for (int i : ints) {
//            if (i==-1){
//                System.out.println(-1);
//                break;
//            }
//            System.out.print(i+" ");
//        }
//
//
//    }
//
//    public static int[] twoNumsSqrt(int[] nums){
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = 1; j < nums.length; j++) {
//                if (nums[i]*nums[i]==nums[j]||nums[j]*nums[j]==nums[i]){
//                    return new int[]{nums[i],nums[j]};
//                }
//            }
//        }
//        return new int[]{-1,-1};
//    }


//    public static void main(String[] args) {
//        Integer[] nums={1,2,3,null,null,2,4,5};
//        ITreeNode root = ITreeNode.makeTree(nums);
//        ITreeNode res = new Test().deleteNodes(root);
//        ArrayList<Integer> arrayList = ITreeNode.sequenceTraverse(res);
//        ListUtil.arrayOne(arrayList);
//    }

//    public ITreeNode deleteNodes (ITreeNode root) {
//        // write code here
//        if (root==null)return null;
//        Set<Integer> set=new HashSet<>();
//        Queue<ITreeNode> queue=new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int curLen=queue.size();
//            for (int i = 0; i < curLen; i++) {
////                Set<Integer> tempSet=new HashSet<>();
//                ITreeNode node=queue.poll();
//                set.add(node.val);
//                if (node.left!=null){
//                    if (set.contains(node.left.val)){
//                        node.left=null;
//                        continue;
//                    }
//                    queue.add(node.right);
//                }
//                if (node.right!=null){
//                    if (set.contains(node.right.val)){
//                        node.right=null;
//                        continue;
//                    }
//                    queue.add(node.right);
//                }
//
//
//            }
//        }
//        return root;
//    }

//    public TreeNode deleteNodes (TreeNode root) {
//        // write code here
//        if (root==null)return null;
//        Set<Integer> set=new HashSet<>();
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()){
//            int curLen=queue.size();
//            for (int i = 0; i < curLen; i++) {
//                TreeNode node=queue.poll();
//                if (set.contains(node.val)){
//                    node.right=null;
//                    node.left=null;
//                }
//                set.add(node.val);
//                if (node.right!=null){
//                    queue.add(node.right);
//                }
//                if (node.left!=null){
//                    queue.add(node.right);
//                }
//
//            }
//        }
//        return root;
//    }

}
