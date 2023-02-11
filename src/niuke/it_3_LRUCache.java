package niuke;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class it_3_LRUCache {

    public static void main(String[] args) {
        int[][] ints ={{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int k=3;

        int[] res=new it_3_LRUCache(k).LRU(ints,k);
        ListUtil.arrayOneNums(res);
    }

    public int[] LRU (int[][] operators, int k) {
        // write code here
        ArrayList<Integer> list=new ArrayList<>();
        it_3_LRUCache lru=new it_3_LRUCache(k);
        for (int[] operator : operators) {
            if (operator[0]==1){
                put(operator[1],operator[2]);
            }else {
                list.add(lru.get(operator[1]));
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;


    }


    //创建双向列表
    class DLinkedList{
        int key;
        int value;
        DLinkedList prev;
        DLinkedList next;
        public DLinkedList() {
        }
        public DLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,DLinkedList> Cache=new HashMap<>();
    private int size;
    private int capacity;
    //伪头部和伪尾部，这样就需要考虑边界条件
    private DLinkedList head,tail;


    public it_3_LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head=new DLinkedList();
        tail=new DLinkedList();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key){
        DLinkedList node=Cache.get(key);
        if (node==null){
            return -1;
        }
        //将node移到双向链表的头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key,int value){
        DLinkedList node=Cache.get(key);
        if (node==null){
            //new Node需要传入新的key与value值
            DLinkedList newNode=new DLinkedList(key,value);
            Cache.put(key,newNode);
            addToHead(newNode);
            ++size;
            if (size>capacity){
                //移除尾部,因为要删除value，所以要返回尾部节点
                DLinkedList tail = removeTail();
                Cache.remove(tail.key);
                --size;
            }
        }else {
            //修改value
            node.value=value;
            //移动到头部
            moveToHead(node);
        }
    }

    private DLinkedList removeTail() {
        DLinkedList res=tail.prev;
        //移除
        removeNode(res);
        return res;
    }

    private void moveToHead(DLinkedList node) {
        //既然是移动到头部，那必然要先删除再移动
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedList node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void addToHead(DLinkedList node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
