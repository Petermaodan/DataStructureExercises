package jianzhioffer;

import BaseUtil.ListUtil;

import java.util.*;

public class it_huawei_德州扑克 {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String s=sc.nextLine();
        String s="2H 8S 4D 8D BC";
        String pattern = findPattern(s);
        System.out.println(pattern);

    }
    public static String findPattern(String cardGroup){
        String[] split = cardGroup.split(" ");
        Map<String,Integer> colorMap=new HashMap<>();
        Map<String,Integer> numberTime=new HashMap<>();
        List<Integer> numberList=new ArrayList<>();
        Map<String,String> toNumber=new HashMap<>();
        toNumber.put("A","10");
        toNumber.put("B","11");
        toNumber.put("C","12");
        toNumber.put("D","13");
        for (String s : split) {
            if (s!=" "){
                String colorTemp=s.substring(1,2);
                String numberTemp=s.substring(0,1);
                colorMap.put(colorTemp,colorMap.getOrDefault(colorTemp,0)+1);
                if (toNumber.containsKey(numberTemp)){
                    numberList.add(Integer.valueOf(toNumber.get(numberTemp)));
                }else {
                    numberList.add(Integer.valueOf(numberTemp));
                }
                numberTime.put(numberTemp,numberTime.getOrDefault(numberTemp,0)+1);
            }
        }
        if (numberList.size()!=5)return "Unknown";

        Collections.sort(numberList);
        ListUtil.arrayOne(numberList);
        //LargestFlush&&StraightFlush&&Flush
        if (colorMap.size()==1){
            if (numberList.get(4)==13&&Integer.valueOf(numberList.get(4))-Integer.valueOf(numberList.get(0))==4){
                return "LargestFlush";
            }else if (Integer.valueOf(numberList.get(4))-Integer.valueOf(numberList.get(0))==4){
                return "StraightFlush";
            }else {
                return "Flush";
            }
        }

        //Straight&&OnePair
        if (colorMap.size()==4){
            if (Integer.valueOf(numberList.get(4))-Integer.valueOf(numberList.get(0))==4){
                return "Straight";
            }else if (numberTime.size()==4){
                return "OnePair";
            }
        }
        return "Unknown";
    }
}

