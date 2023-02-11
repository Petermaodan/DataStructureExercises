package it_数据结构.it_1_图;


import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * 图的抽象数据结构
 * @author xiaohui
 * 总而言之，邻接表是一个数组，数组的每个元素包含顶点信息和单链表的头指针两部分。
 * 而单链表的结构分成与顶点相邻的元素信息、边的信息和下一个与顶点相邻的元素指针。
 * 下面是图的邻接表Java代码实现：
 */
public  class Graph<E> implements IGraph<E> {

    //邻接表中中对应的链表的顶点
    private static class ENode{
        int adjvex;//邻接顶底序号
        int weight;//储存边或弧相关的信息，如权值
        ENode nextadj;//下一个邻接表节点

        public ENode(int adjvex, int weight) {
            this.adjvex = adjvex;
            this.weight = weight;
        }
    }

    //邻接表中表的顶点
    private static class VNode<E>{
      E data;//顶点信息
      ENode firstadj;//邻接表的第一个节点
    }

    private VNode<E>[] vexs;//顶点数组
    private int numOfVexs;//顶点的实际数量
    private int maxNumOfVexs;//顶点的最大数量
    private boolean[] visited;//判断顶点是否被访问过

    public Graph(VNode<E>[] vexs, int maxNumOfVexs) {
        this.vexs = (VNode<E>[]) Array.newInstance(VNode.class,maxNumOfVexs);
        this.maxNumOfVexs = maxNumOfVexs;
    }






    // 得到顶点的数目
    @Override
    public int getNumOfVertex() {
        return numOfVexs;
    }

    // 插入顶点
    @Override
    public boolean insertVex(E v) {
        if (numOfVexs>=maxNumOfVexs){
            return false;
        }
        VNode<E> vex=new VNode<>();
        vex.data=v;
        vexs[numOfVexs++]=vex;
        return true;
    }

    //删除顶点
    @Override
    public boolean deleteVex(E v) {
        //首先删除头节点
        for (int i = 0; i < numOfVexs; i++) {
            if (vexs[i].data.equals(v)){
                for (int j = i; j < numOfVexs-1 ; j++) {
                    vexs[j]=vexs[j+1];
                }
                vexs[numOfVexs-1]=null;
                numOfVexs--;
                //删除邻接表中的节点
                //双指针删除
                ENode current;
                ENode previous;
                //遍历邻接表中表的顶点
                for (int j = 0; j < numOfVexs; j++) {
                    //base case
                    if (vexs[j].firstadj==null)continue;
                    if (vexs[j].firstadj.adjvex==i){
                        vexs[j].firstadj=null;
                        continue;
                    }
                    //不再第一个节点
                    current=vexs[j].firstadj;
                    while (current!=null){
                        previous=current;
                        current=current.nextadj;
                        if (current!=null&&current.adjvex==i){
                            previous.nextadj=current.nextadj;
                            break;
                        }
                    }
                }
                //更新邻接表中的下标
                for (int j = 0; j < numOfVexs; j++) {
                    current=vexs[j].firstadj;
                    while (current!=null){
                        if (current.adjvex>i){
                            if (current.adjvex>i){
                                current.adjvex--;
                            }
                            //指针后移
                            current=current.nextadj;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    // 定位顶点的位置
    @Override
    public int indexOfVex(E v) {
        for (int i = 0; i < numOfVexs; i++) {
            if (vexs[i].data.equals(v)){
                return i;
            }
        }
        return -1;
    }

    // 定位指定位置的顶点
    @Override
    public E valueOfVex(int v) {
        if (v<0||v>=numOfVexs)return null;
        return vexs[v].data;
    }


    // 插入边
    @Override
    public boolean insertEdge(int v1, int v2, int weight) {
        if (v1<0||v2<0||v1>=numOfVexs||v2>=numOfVexs)
            throw new ArrayIndexOutOfBoundsException();

        //创建新的节点
        ENode vex1=new ENode(v2,weight);

        //索引为index1的顶点没有邻接顶点
        if (vexs[v1].firstadj==null){
            vexs[v1].firstadj=vex1;
        }
        // 索引为index1的顶点有邻接顶点,是由头==头插法
        else {
            vex1.nextadj=vexs[v1].firstadj;
            vexs[v1].firstadj=vex1;
        }

        ENode vex2 = new ENode(v1, weight);
        // 索引为index2的顶点没有邻接顶点
        if (vexs[v2].firstadj == null) {
            vexs[v2].firstadj = vex2;
        }
        // 索引为index1的顶点有邻接顶点
        else {
            vex2.nextadj = vexs[v2].firstadj;
            vexs[v2].firstadj = vex2;
        }
        return true;
    }

    @Override
    public boolean deleteEdge(int v1, int v2) {
        if (v1<0||v2<0||v1>=numOfVexs||v2>=numOfVexs){
            throw new ArrayIndexOutOfBoundsException();
        }
        // 删除索引为index1的顶点与索引为index2的顶点之间的边
        //双指针删除
        ENode current=vexs[v1].firstadj;
        ENode previous=null;

        while (current!=null&&current.adjvex!=v2){
            //更新双指针
            previous=current;
            current=current.nextadj;
        }
        if (current!=null){
            previous.nextadj=current.nextadj;
        }
        // 删除索引为index2的顶点与索引为index1的顶点之间的边
        current = vexs[v2].firstadj;
        while (current != null && current.adjvex != v1) {
            previous = current;
            current = current.nextadj;
        }
        if (current != null)
            previous.nextadj = current.nextadj;
        return true;

    }

    //得到边
    @Override
    public int getEdge(int v1, int v2) {

        if (v1 < 0 || v2 < 0 || v1 >= numOfVexs || v2 >= numOfVexs)
            throw new ArrayIndexOutOfBoundsException();
        ENode current = vexs[v1].firstadj;
        while (current != null) {
            if (current.adjvex == v2) {
                return current.weight;
            }
            current = current.nextadj;
        }
        return 0;
    }


    // 深度优先搜索遍历
    @Override
    public String depthFirstSearch(int v) {
        return null;
    }


    // 广度优先搜索遍历
    @Override
    public String breadFirstSearch(int v) {
        return null;
    }



    // 实现Dijkstra算法
    @Override
    public int[] dijkstra(int v) {
        return new int[0];
    }
}
