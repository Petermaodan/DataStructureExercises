package leetcode.hot100;

import java.util.Arrays;

/**
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 *
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 *
 */
public class it_825_适龄的朋友 {
    public static void main(String[] args) {
        int[] ages = {20,30,100,110,120};
        int res = new it_825_适龄的朋友().numFriendRequests(ages);
        System.out.println(res);
    }

    //从三个不发送好友请求的条件来看，以 y 的角度来说，
    // 可总结为：年龄比我小的不考虑（同龄的可以），年龄比我大可以考虑，但是不能超过一定范围则不考虑。
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n=ages.length,ans=0;
        for (int i = 0,j=0,k=0; k < n; k++) {
           //实际上类似于滑动窗口
            while (i<k&&!check(ages[i],ages[k])){
                i++;
            }
            if (j<k){
                j=k;
            }
            while (j<n&&check(ages[j],ages[k])){
                j++;
            }
            if (j>i){
                //要减去自生
                ans+=j-i-1;
            }
        }
        return ans;
    }

    private boolean check(int x, int y) {
        if (y<=0.5*x+7)return false;
        if (y>x)return false;
        if (y>100&&x<100)return false;
        return true;
    }
}
