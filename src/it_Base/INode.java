package it_Base;

public class INode extends ITreeNode {
    public int val;
    public INode left;
    public INode right;

    public INode() {}

    public INode(int _val) {
        val = _val;
    }

    public INode(int _val,INode _left,INode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
