package it_01_digui;

import java.util.ArrayList;
import java.util.List;

public class SumTest {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);

        System.out.println(sumArr(list));
    }
    public static int sumArr(List<Integer> list){
        if (list.size()==0){
            return 0 ;
        }
        Integer i=list.get(0);
        list.remove(0);
        return i+sumArr(list);
    }
}
