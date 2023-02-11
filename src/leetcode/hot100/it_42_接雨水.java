package leetcode.hot100;

public class it_42_接雨水 {
    public static void main(String[] args) {
        int[] nums={3,1,2,5,2,4};
        int res = new it_42_接雨水().trap3(nums);
        System.out.println(res);

    }

    //解法三，对动态规划进行优化，
    //max_left [ i ] 和 max_right [ i ] 数组中的元素我们其实只用一次，
    // 然后就再也不会用到了。所以我们可以不用数组，只用一个元素就行了。我们先改造下 max_left。

    //双指针改进
    public int trap3(int[] height){
        int sum=0;
        int maxLeft=0,maxRight=0;
        int left=1,right=height.length-2;
        while (left<=right) {
            if (height[left - 1] < height[right + 1]) {
                maxLeft = Math.max(maxLeft, height[left - 1]);
                int min = maxLeft;
                if (min > height[left]){
                    sum+=(min-height[left]);
                }
                left++;
            }else {
                maxRight=Math.max(maxRight,height[right+1]);
                int min=maxRight;
                if (min>height[right]){
                    sum+=(min-height[right]);
                }
                right--;
            }
        }
        return sum;
    }


    //解法二，时间换空间，动态规划保存之前已经遍历的最大高度
    //max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。
    // （一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的，和 leetcode 上边的讲的有些不同）
    public int trap2(int[] height){
        int sum=0;
        int[] maxLeft=new int[height.length];
        int[] maxRight=new int[height.length];
        for (int i = 1; i <height.length ; i++) {
            maxLeft[i]=Math.max(height[i-1],maxLeft[i-1]);
        }
        for (int i =height.length-2; i >=0; i--) {
            maxRight[i]=Math.max(height[i+1],maxRight[i+1]);
        }
        for (int i = 1; i < height.length-1; i++) {
            int min=Math.min(maxLeft[i],maxRight[i]);
            if (height[i]<min){
                sum+=min-height[i];
            }
        }
        return sum;
    }


    //解法一，大力出奇迹，两个for循环直接按每一列求出
    public int trap(int[] height){
        int sum=0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft=0;
            //找左边的最高柱子
            for (int j = i-1; j >=0 ; j--) {
                if (maxLeft<height[j]){
                    maxLeft=height[j];
                }
            }
            int maxRight=0;
            //找右边的最高柱子
            for (int j = i+1; j < height.length; j++) {
                if (maxRight<height[j]){
                    maxRight=height[j];
                }
            }
            int minHeight=Math.min(maxLeft,maxRight);
            if (minHeight>height[i]){
                sum+=minHeight-height[i];
            }
        }
        return sum;
    }
}
