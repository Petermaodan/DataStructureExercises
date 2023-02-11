package leetcode.hot100;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 *找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 *
 * 双指针解法，从两边向中间收缩
 * 移动短板，可能会使面积变大，移动长板，面积只能是不变或者变小
 * 向内移短板不会导致丢失最大面积
 */
public class it_11_乘最多水的容器 {
    public static void main(String[] args) {
        int[] height= {1,8,6,2,5,4,8,3,7};
        System.out.println(new it_11_乘最多水的容器().maxArea(height));

    }

    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int res=0;
        while (left<right){
            res= height[left]<height[right]?
                    Math.max(res,(right-left)*height[left++]):
                    Math.max(res,(right-left)*height[right--]);
        }
        return res;
    }
}
