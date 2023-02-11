package it_数据结构.it_2_cache;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseCache<T> {
    protected Map<T, Node> map;

    protected DoubleLinkList list;

    public BaseCache() {
        this.map = new HashMap<>();
        this.list = new DoubleLinkList();
    }

    public BaseCache(long capacity) {
        this.map = new HashMap<>();
        this.list = new DoubleLinkList(capacity);
    }

    public abstract T get(T key);

    public abstract void put(T key,T value);

    public String toString(){
        return this.list.toString();
    }
}
