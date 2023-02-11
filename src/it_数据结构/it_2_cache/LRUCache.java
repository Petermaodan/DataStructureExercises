package it_数据结构.it_2_cache;

//最近最少使用
public class LRUCache<T> extends BaseCache<T> {

    public LRUCache(long capacity) {
        super(capacity);
    }

    @Override
    public T get(T key) {
        if (this.map.containsKey(key)){
            Node node = this.map.get(key);
            //移除之后插到双向链表的最前面
            this.list.remove(node);
            this.list.appendFront(node);
            return (T) node.getValue();
        }else {
            return null;
        }
    }

    @Override
    public void put(T key, T value) {
        if (this.map.containsKey(key)){
            //移除老的节点
            Node oldNode=this.map.get(key);
            this.list.remove(oldNode);
            //更新新节点的值，同时插入链表头部

            oldNode.setValue(value);
            this.list.appendFront(oldNode);
        }else {
            Node newNode=new Node(key,value);
            //判断是否超过容量
            if (this.list.getSize()>=this.list.getCapacity()){
                Node node=this.list.remove();
                this.map.remove(node.getKey());
            }

            //将新的节点插入头部
            Node node=this.list.appendFront(newNode);
            this.map.put(key,node);
        }
    }
}
