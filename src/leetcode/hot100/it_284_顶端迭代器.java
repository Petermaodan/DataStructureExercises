package leetcode.hot100;

import java.util.Iterator;

/**
 * 请你设计一个迭代器，除了支持 hasNext 和 next 操作外，还支持 peek 操作。
 *
 * 实现 PeekingIterator 类：
 *
 * PeekingIterator(int[] nums) 使用指定整数数组 nums 初始化迭代器。
 * int next() 返回数组中的下一个元素，并将指针移动到下个元素处。
 * bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。
 * int peek() 返回数组中的下一个元素，但 不 移动指针。
 */
public class it_284_顶端迭代器 {

    class PeekingIterator implements Iterator<Integer> {
        Iterator iterator;
        Integer next;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator=iterator;
            if (iterator.hasNext())next=iterator.next();

        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer ans=next;
            //指针要变
            next=iterator.hasNext()? (Integer) iterator.next() :null;
            return ans;
        }

        @Override
        public boolean hasNext() {
            return next!=null;
        }
    }
}
