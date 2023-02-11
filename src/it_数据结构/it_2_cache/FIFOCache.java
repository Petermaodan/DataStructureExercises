package it_数据结构.it_2_cache;

/**
 * 先进先出的页面置换算法
 */
public class FIFOCache<T> extends BaseCache<T> {

    public FIFOCache(long capacity) {
        super(capacity);
    }

    @Override
    public T get(T key) {
        if (!this.map.containsKey(key)){
            return null;
        }

        Node node=this.map.get(key);
        T value= (T) node.getValue();
        return value;
    }

    @Override
    public void put(T key, T value) {
        if (this.list.getCapacity()==0){
            return;
        }

        if (this.map.containsKey(key)){
            Node node=this.map.get(key);
            this.list.remove(node);
            node.setValue(value);

            this.list.append(node);
        }else {
            //判断是否超过设定容量
            if (this.list.getSize()==this.list.getCapacity()){
                Node node=this.list.pop();
                this.map.remove(node.getKey());
            }

            Node node=new Node(key,value);
            this.list.append(node);
            this.map.put(key,node);
        }
    }
}
