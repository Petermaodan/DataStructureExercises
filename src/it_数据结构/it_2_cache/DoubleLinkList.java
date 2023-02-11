package it_数据结构.it_2_cache;

public class DoubleLinkList {

    private long capacity;

    //头节点和尾节点
    private Node head;

    private Node tail;

    private long size;

    public DoubleLinkList() {
        this.capacity = Long.MAX_VALUE;
        this.size = 0;
    }

    public DoubleLinkList(long capacity){
        this.capacity=capacity;
        this.size=0;
    }

    /**
     * 从头部添加
     */
    private Node addHead(Node node) {
        //头节点不存在
        if (this.head == null) {
            node.prev = null;
            node.next = null;
            this.head = node;
            this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            //更新head节点
            this.head = node;
            this.head.prev = null;
        }
        this.size += 1;
        //返回添加的节点
        return node;
    }

    /**
     * 从尾部添加
     */
    private Node addTail(Node node) {
        if (this.tail == null) {
            node.prev = null;
            node.next = null;
            this.head = node;
            this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
            this.tail.next = null;
        }
        this.size += 1;
        return node;
    }

    /**
     * 从头部删除
     */
    private Node delHead() {
        if (this.head == null) return null;
        Node node = this.head;
        if (this.head.next != null) {
            this.head.next.prev = null;
            this.head = this.head.next;
        } else {
            this.head = null;
            this.tail = null;
        }
        this.size -= 1;
        return node;
    }

    /**
     * 从尾部删除
     */
    private Node delTail() {
        if (this.tail == null) return null;
        Node node = this.tail;
        if (node.prev != null) {
            this.tail = node.prev;
            this.tail.next = null;
        } else {
            this.tail = null;
            this.head = null;
        }
        this.size -= 1;
        return node;
    }

    /**
     * 删除任意一个已知的节点
     */
    private Node _remove(Node node) {
        if (node == null) {
            node = this.tail;
        }
        if (node == this.head) {
            return this.delHead();
        }
        if (node == this.tail) {
            return this.delTail();
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
        this.size -= 1;
        return node;
    }

    public Node pop() {
        return this.delHead();
    }

    public Node append(Node node) {
        return this.addTail(node);
    }

    public Node appendFront(Node node) {
        return this.addHead(node);
    }

    public Node remove() {
        return this._remove(null);
    }

    public Node remove(Node node) {
        return this._remove(node);
    }

    public String toString(){
        Node node=this.head;
        StringBuffer buffer=new StringBuffer();
        long tmp=6;
        while (node!=null&&tmp>0){
            buffer.append(node.toString());
            node=node.next;
            if (node!=null){
                buffer.append("->");
            }
            tmp-=1;
        }
        return buffer.toString();
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
