package jianzhioffer2;

public class it_67_最大的异或_字典树 {
    public static void main(String[] args) {
        int[] nums = {14,70,53,83,49,91,36,80,92,51,66,70};
        int res = new it_67_最大的异或_字典树().findMaximumXOR(nums);
        System.out.println(res);
    }

    TrieNode root=new TrieNode();
    public int findMaximumXOR(int[] nums) {
        int max=0;
        for (int num : nums) {
            insert(num);
            max=Math.max(max,num^search(num));
        }
        return max;

    }

    public void insert(int num){
        TrieNode cur=root;
        for (int i = 30; i >=0 ; i--) {
            // 题目范围为非负数，高31位移动到低1位只要右移30位
            int bit=(num>>i)&1;
            if (cur.next[bit]==null){
                cur.next[bit]=new TrieNode();
            }
            cur=cur.next[bit];
        }
    }

    public int search(int num){
        TrieNode cur=root;
        int ans=0;
        for (int i = 30; i >=0; i--) {
            int bit=(num>>i)&1;
            bit=cur.next[bit^1]==null?bit:bit^1;
            ans+=bit<<i;
            cur=cur.next[bit];
        }
        // 返回当前前缀树中与num做异或能够取得最大值的数字。取出后再在外部做异或运算。
        return ans;
    }

    class TrieNode{
        TrieNode[] next=new TrieNode[2];
    }

    public int findMaximumXOR2(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                res=Math.max(res,nums[i]^nums[j]);
            }
        }

        return res;
    }
}
