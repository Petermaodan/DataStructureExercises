package it_Base;

import java.util.HashMap;

public class Vertex1 {
    private char id;//顶点的标识
    private HashMap<Vertex1,Integer> neighbors;// 当前顶点可直接达到的顶点及其长度(权重)
    private Vertex1 predecessor;//上一个顶点是谁（前驱），用来记录路径
    private int distance;//距离起始点的距离

    public Vertex1() {
    }

    public Vertex1(char id) {
        this.id = id;
        this.neighbors=new HashMap<>();
    }

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public void addNeighbor(Vertex1 vertex1,int weight){
        neighbors.put(vertex1,weight);
    }

    public void setNeighbors(HashMap<Vertex1, Integer> neighbors) {
        this.neighbors = neighbors;
    }

    public HashMap<Vertex1, Integer> getNeighbors() {
        return neighbors;
    }

    public Vertex1 getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex1 predecessor) {
        this.predecessor = predecessor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("Vertex1[%c]:distance is %d , predecessor is '%s'", id, distance,
                predecessor == null ? "null" : predecessor.id);
    }
}
