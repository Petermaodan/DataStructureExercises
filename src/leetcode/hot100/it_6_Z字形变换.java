package leetcode.hot100;

import BaseUtil.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * * 请你实现这个将字符串进行指定行数变换的函数：
 * * string convert(string s, int numRows);
 *   * * 示例 1：
 *
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I

 */
public class it_6_Z字形变换 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
//        char[][] chars = new it_6_Z字形变换().outPutChar(s, numRows);
//        ListUtil.arrayTwoChar(chars);
        String convert = new it_6_Z字形变换().convert(s, numRows);
        System.out.println(convert);

    }
//    public char[][] outPutChar(String s,int numRows){
//        char[][] letters= new char[numRows][10];
//        int i=0,n=s.length();
//        int row=0,col=0;
//        boolean flag=true;
//        while (i<n){
//            if (flag){
//                while (i<n&&row<numRows){
//                    letters[row][col]=s.charAt(i);
//                    row++;
//                    i++;
//                }
//                row=numRows-2;
//                col++;
//                flag=false;
//            }else {
//                while (i<n&&row>=0){
//                    letters[row][col]=s.charAt(i);
//                    row--;
//                    i++;
//                }
//                row=1;
//                col++;
//                flag=true;
//            }
//        }
//        return letters;
//    }
    public String convert(String s, int numRows) {
        if (numRows<2)return s;
        int i=0,n=s.length();
        List<StringBuilder> list=new ArrayList<>();
        for (int j = 0; j < numRows; j++) {
            list.add(new StringBuilder());
        }
        int row=0;
        boolean flag=true;
        while (i<n){
            if (flag){
                while (i<n&&row<numRows){
                    list.get(row).append(s.charAt(i));
                    row++;
                    i++;
                }
                row=numRows-2;
                flag=false;
            }else {
                while (i<n&&row>=0){
                    list.get(row).append(s.charAt(i));
                    row--;
                    i++;
                }
                row=1;
                flag=true;
            }
        }
        StringBuilder builder=new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            builder.append(stringBuilder);
        }

        return builder.toString();
    }
}
