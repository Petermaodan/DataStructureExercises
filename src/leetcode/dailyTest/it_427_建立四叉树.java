package leetcode.dailyTest;

/**
 * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 *
 * 你需要返回能表示矩阵的 四叉树 的根结点。
 *
 * 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 *
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 *
 * val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
 * isLeaf: 当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 */
public class it_427_建立四叉树 {

    int[][] grid;
    public Node construct(int[][] grid) {
        this.grid=grid;
        return dfs(0,0,grid.length-1,grid[0].length-1);
    }

    private Node dfs(int a, int b, int c, int d) {
        boolean ok=true;
        int t=grid[a][b];
        for (int i = a; i <=c&&ok ; i++) {
            for (int j = b; j <=d&&ok ; j++) {
                if (t!=grid[i][j]){
                    ok=false;
                }
            }
        }
        if (ok){
            return new Node(t==1,true);
        }
        Node node=new Node(t==1,false);
        int dx=c-a+1,dy=d-b+1;
        node.topLeft=dfs(a,b,a+dx/2-1,b+dy/2-1);
        node.topRight=dfs(a,b+dy/2,a+dx/2-1,d);
        node.bottomLeft=dfs(a+dx/2,b,c,b+dy/2-1);
        node.bottomRight=dfs(a+dx/2,b+dy/2,c,d);
        return node;
    }

}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
