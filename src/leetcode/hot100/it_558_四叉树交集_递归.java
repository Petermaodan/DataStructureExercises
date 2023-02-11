package leetcode.hot100;

import javafx.application.Application;
import javafx.stage.Stage;

public class it_558_四叉树交集_递归  {

    public static void main(String[] args){

    }
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf&&quadTree2.isLeaf){
            //当 t1 和 t2 均为叶子节点数时，执行「或逻辑」，即若 t1 和 t2 任一值为 1 时，返回该节点，否则（两者均为 0），返回任一节点
            if (quadTree1.val){
                return quadTree1;
            }else if (quadTree2.val){
                return quadTree2;
            }else {
                return quadTree1;
            }
        }
        Node node=new Node();
        node.topLeft=intersect(quadTree1.isLeaf?quadTree1:quadTree1.topLeft,quadTree2.isLeaf?quadTree2:quadTree2.topLeft);
        node.topRight=intersect(quadTree1.isLeaf?quadTree1:quadTree1.topRight,quadTree2.isLeaf?quadTree2:quadTree2.topRight);
        node.bottomLeft=intersect(quadTree1.isLeaf?quadTree1:quadTree1.bottomLeft,quadTree2.isLeaf?quadTree2:quadTree2.bottomLeft);
        node.bottomRight=intersect(quadTree1.isLeaf?quadTree1:quadTree1.bottomRight,quadTree2.isLeaf?quadTree2:quadTree2.bottomRight);
        boolean a=node.topLeft.isLeaf&&node.topRight.isLeaf&&node.bottomLeft.isLeaf&&node.bottomRight.isLeaf;
        boolean b=node.topLeft.val&&node.topRight.val&&node.bottomLeft.val&&node.bottomRight.val;
        boolean c=node.topLeft.val||node.topRight.val||node.bottomLeft.val||node.bottomRight.val;

        //判定当前节点是否为叶子节点
        node.isLeaf=a&&(b||!c);
        node.val=node.topLeft.val;
        if (node.isLeaf){
            node.topLeft=null;
            node.topRight=null;
            node.bottomLeft=null;
            node.bottomRight=null;
        }
        return node;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

}

