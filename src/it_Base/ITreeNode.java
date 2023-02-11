package it_Base;


import java.util.ArrayList;
import java.util.List;

public class ITreeNode {
    public int val;
    public ITreeNode left;
    public ITreeNode right;
    public ITreeNode(int x) { val = x; }
    public ITreeNode next;
    public List<ITreeNode> children;

    public ITreeNode() {
    }

    public ITreeNode(int val, ITreeNode left, ITreeNode right, ITreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
    public ITreeNode(int _val, List<ITreeNode> _children) {
        val = _val;
        children = _children;
    }

    public static ITreeNode makeTree(Integer[] trees) {
        if (trees.length == 0)
            return null;
        ITreeNode[] ITreeNodes = new ITreeNode[trees.length + 1];
        for (int i = 1; i < ITreeNodes.length; i++) {
            if (trees[i - 1] == null) {
                ITreeNodes[i] = null;
            } else {
                ITreeNodes[i] = new ITreeNode(trees[i - 1]);
            }
        }

        ITreeNode ITreeNode = null;
        //这个只适用于完全二叉树
//        for (int i = 1; i < ITreeNodes.length; i++) {
//            ITreeNode = ITreeNodes[i];
//            if (ITreeNode == null) continue;
//            if (2 * i < ITreeNodes.length)
//                ITreeNode.left = ITreeNodes[2 * i];
//            if (2 * i + 1 < ITreeNodes.length)
//                ITreeNode.right = ITreeNodes[2 * i + 1];
//        }
        for (int i = 1, index = 2; i < ITreeNodes.length && index < ITreeNodes.length; i++) {
            ITreeNode = ITreeNodes[i];
            if (ITreeNode == null) continue;
            ITreeNode.left = ITreeNodes[index];
            if (index + 1 < ITreeNodes.length)
                ITreeNode.right = ITreeNodes[index + 1];
            index += 2;
        }
        return ITreeNodes[1];
    }

    //中序遍历
    public static ArrayList<Integer> middleTraverse(ITreeNode ITreeNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (ITreeNode == null) {
            arrayList.add(null);
        }else if (ITreeNode.left == null && ITreeNode.right == null) {
            arrayList.add(ITreeNode.val);
        } else {
            arrayList.add(ITreeNode.val);
            arrayList.addAll(middleTraverse(ITreeNode.left));
            arrayList.addAll(middleTraverse(ITreeNode.right));
        }
        return arrayList;
    }

    //前序遍历
    public static ArrayList<Integer> beforeTraverse(ITreeNode ITreeNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (ITreeNode == null) {
            arrayList.add(null);
        }else if (ITreeNode.left == null && ITreeNode.right == null) {
            arrayList.add(ITreeNode.val);
        } else {
            arrayList.addAll(beforeTraverse(ITreeNode.left));
            arrayList.add(ITreeNode.val);
            arrayList.addAll(beforeTraverse(ITreeNode.right));
        }
        return arrayList;
    }

    //后序遍历
    public static ArrayList<Integer> afterTraverse(ITreeNode ITreeNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (ITreeNode == null) {
            arrayList.add(null);
        }else if (ITreeNode.left == null && ITreeNode.right == null) {
            arrayList.add(ITreeNode.val);
        } else {
            arrayList.addAll(afterTraverse(ITreeNode.right));
            arrayList.add(ITreeNode.val);
            arrayList.addAll(afterTraverse(ITreeNode.left));
        }
        return arrayList;
    }

    //层序遍历
    public static ArrayList<Integer> sequenceTraverse(ITreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<ITreeNode> ITreeNodes = new ArrayList<>();
        ITreeNodes.add(root);
        arrayList.add(root.val);
        while (ITreeNodes.size() > 0) {
            ArrayList<ITreeNode> subITreeNodes = new ArrayList<>();
            for (ITreeNode value : ITreeNodes) {
                if (value.left != null || value.right != null) {
                    if (value.left != null) {
                        subITreeNodes.add(value.left);
                        arrayList.add(value.left.val);
                    } else {
                        arrayList.add(null);
                    }
                    if (value.right != null) {
                        subITreeNodes.add(value.right);
                        arrayList.add(value.right.val);
                    } else {
                        arrayList.add(null);
                    }
                }
            }
            ITreeNodes = subITreeNodes;
        }
        return arrayList;
    }
}