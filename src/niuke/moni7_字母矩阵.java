package niuke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class moni7_字母矩阵 {
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        char[][] zimu=new char[n][m];
        for(int i = 0; i < n; i++){
            String temp=sc.nextLine();
            for (int j = 0; j < m; j++) {
                zimu[i][j]=temp.charAt(j);
            }
        }
        List<Character> sum=new ArrayList<>();
        int res=-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans=0;
//                res=dfs(zimu,i,j,k,sum,ans);
            }
        }


        System.out.println(res);
    }

//    private static int dfs(char[][] zimu, int i, int j, int k, List<Character> sum, int ans) {
//
//        if (sum.size()==k)return ans;
//
//        if (!isArea(zimu,i,j))return 0;
//    }

    private static boolean isArea(char[][] zimu, int i, int j) {
        return i>=0&&i<zimu.length&&j>=0&&j<zimu[0].length;
    }
}
