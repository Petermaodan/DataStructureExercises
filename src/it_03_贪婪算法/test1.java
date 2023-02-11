package it_03_贪婪算法;

import it_Base.Vertex1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class test1 {

    public static void main(String[] args) {
        List<Vertex1> list=getTestData();
        dijkstra(list);

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).toString());
//        }

        for (Vertex1 vertex1 : list) {
            System.out.println(vertex1.toString());
        }


    }

    private static void dijkstra(List<Vertex1> list) {
        List<Vertex1> copy=new LinkedList<>();
        copy.addAll(list);
        while (!copy.isEmpty()){
            Vertex1 vertex1=extractMin(copy);
            relax(vertex1);
        }

    }

    private static Vertex1 extractMin(List<Vertex1> list) {
        int index=0;
        for (int i=1;i<list.size();i++){
            if (list.get(index).getDistance()>list.get(i).getDistance()){
                index=i;
            }
        }
        return list.remove(index);
    }

    private static void relax(Vertex1 vertex1) {
        HashMap<Vertex1,Integer> map=vertex1.getNeighbors();
        for (Vertex1 neighbor : map.keySet()) {
            int distance=vertex1.getDistance()+map.get(neighbor);
            if (neighbor.getDistance()>distance){
                neighbor.setDistance(distance);
                neighbor.setPredecessor(vertex1);
            }
        }

    }


    public static List<Vertex1> getTestData() {
        Vertex1 s = new Vertex1('s');
        Vertex1 t = new Vertex1('t');
        Vertex1 x = new Vertex1('x');
        Vertex1 y = new Vertex1('y');
        Vertex1 z = new Vertex1('z');
        s.addNeighbor(t, 10); // s->t : 10
        s.addNeighbor(y, 5); // s->y : 5
        t.addNeighbor(x, 1); // t->x : 1
        t.addNeighbor(y, 2); // t->y : 2
        x.addNeighbor(z, 4); // x->z : 4
        y.addNeighbor(t, 3); // y->t : 3
        y.addNeighbor(x, 9); // y->x : 9
        y.addNeighbor(z, 2); // y->z : 2
        z.addNeighbor(x, 6); // z->x : 6
        z.addNeighbor(s, 7); // z->s : 7
        // 起始点离起始点距离为0
        s.setDistance(0);
        t.setDistance((int) (1f/0f));
        x.setDistance((int) (1f/0f));
        y.setDistance((int) (1f/0f));
        z.setDistance((int) (1f/0f));
        LinkedList<Vertex1> list = new LinkedList<>();
        list.add(s);
        list.add(t);
        list.add(x);
        list.add(y);
        list.add(z);
        return list;
    }

}
