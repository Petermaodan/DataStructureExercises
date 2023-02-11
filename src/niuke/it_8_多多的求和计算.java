package niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class it_8_多多的求和计算 {

    Map<String,Integer> hashMap=new HashMap<>();
    int res=0;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int[] nums=new int[N];
        for (int i = 0; i < N; i++) {
            nums[i]=scanner.nextInt();
        }
        int res=new it_8_多多的求和计算().dp(nums,M,0,N-1);
        System.out.println(res);


    }
    public int dp(int[] nums,int M, int l, int h){
        if (l==h){
            if (nums[l]%M==0&!hashMap.containsKey(l+"#")){
                res++;
                hashMap.put(nums[l]+"#",1);
            }
            return res;
        }
        int temp=0;
        StringBuilder s=new StringBuilder();
        for (int i = l; i <=h ; i++) {
            temp+=nums[i];
            s.append(i).append("#");
        }
        if (temp%M==0&!hashMap.containsKey(s.toString())){
            res++;
            hashMap.put(s.toString(),1);
        }
        dp(nums,M,l+1,h);
        dp(nums,M,l,h-1);
        return res;
    }

//    Scanner input = new Scanner(System.in);
//    int n = input.nextInt();
//    int m = input.nextInt();
//    int[] arr = new int[n];
//        for(int i = 0; i<n; i++){
//        arr[i] = input.nextInt();
//    }
//    long res = 0;
//    int[] map = new int[m];
//    int sum=0;
//    // 出现m的倍数必然直接加一
//    map[0]=1;
//    // 规定终止点
//        for(int i = 0; i<n; i++){
//        sum = (sum+arr[i])%m;
//        // 出现相同余数时才加上前面出现的个数，表示不同起始点
//        res += (long) map[sum]++;
//    }
//
//        System.out.println(res);
}
