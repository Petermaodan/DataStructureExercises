package leetcode.dailyTest;

public class it_622_设计循环队列 {

    class MyCircularQueue {

        int count;
        int he,ta;
        int[] nums;
        public MyCircularQueue(int k) {
            this.count=k;
            this.nums=new int[k];
            this.he=0;
            this.ta=0;
        }

        public boolean enQueue(int value) {
            if (isFull()){
                return false;
            }
            nums[ta%count]=value;
            ta++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()){
                return false;
            }
            he++;
            return true;
        }

        public int Front() {
            return isEmpty()?-1:nums[he%count];
        }

        public int Rear() {
            return isEmpty()?-1:nums[(ta-1)%count];
        }

        public boolean isEmpty() {
            return he==ta;
        }

        public boolean isFull() {
            return ta-he==count;
        }
    }
}
