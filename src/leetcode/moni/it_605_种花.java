package leetcode.moni;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false
 */
public class it_605_种花 {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,1,0,1,0,1};
        int n = 0;
        System.out.println(new it_605_种花().canPlaceFlowers(flowerbed,n));
    }

    //贪心，能种就种
    //从左到右遍历数组，如果某位置为0，并且其左右邻居位置也都为0，那么该位置可以种花，将其改为1，计数加一，对于起始位置和结束位置需特殊判断,其实和结尾位置，其左边或右边可以等价为0。
    // 比较计数值是否大于n，大于返回True，否则返回False


    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0){
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i]==0&&(i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0)){
                n--;
                if (n<=0){
                    return true;
                }
                flowerbed[i]=1;
            }
        }
        return false;
    }
}
