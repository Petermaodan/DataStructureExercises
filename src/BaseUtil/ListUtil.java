package BaseUtil;
//test
import java.util.List;

public class ListUtil {
    public static void arrayOne(List<Integer> list){
        System.out.print("[ ");
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
        System.out.print(" ]");
    }
    public static void arrayOneNums(int[] nums){
        System.out.print("[ ");
        for (int i:nums) {
            System.out.print(i+" ");
        }
        System.out.print(" ]");
    }

    public static void arrayTwo(List<List<Integer>> lists){
        System.out.print("[ ");
        for (List<Integer> list : lists) {
            System.out.print("[ ");
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.print(" ]");
        }
        System.out.println(" ]");
    }

    public static void arrayTwoString(List<List<String>> lists){
        System.out.print("[ ");
        for (List<String> list : lists) {
            System.out.print("[ ");
            for (String str : list) {
                System.out.print(str+" ");
            }
            System.out.print(" ]");
        }
        System.out.println(" ]");
    }

    public static void arrayOneString(List<String> lists){
        System.out.print("[ ");

            for (String str : lists) {
                System.out.print(str+" ");
            }

        System.out.println(" ]");
    }

    public static void arrayTowNums(int[][] nums){
        System.out.print("[ ");
        for (int[] num : nums) {
            System.out.print("[ ");
            for (int i : num) {
                System.out.print(i+" ");
            }
            System.out.print(" ]");
            System.out.println();
        }
        System.out.println(" ]");
    }

    public static void arrayStringStr(String[] strings) {
        System.out.print("[ ");
        for (String i:strings) {
            System.out.print(i+" ");
        }
        System.out.print(" ]");
    }

    public static void arrayTwoChar(char[][] chars) {
        System.out.print("[ ");
        for (char[] aChar : chars) {
            System.out.print("[ ");
            for (char c : aChar) {
                System.out.print(c+" ");
            }
            System.out.print(" ]");
            System.out.println();
        }
        System.out.print("]");

    }
}
