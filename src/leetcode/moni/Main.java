package leetcode.moni;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public List<String> list=new LinkedList<>();
    public static void main(String[] args) {
        String s=new Scanner(System.in).nextLine();
        String res=new Main().caseTransform(s);
        System.out.println(res);


    }

    public String caseTransform(String s){
        StringBuilder S1=new StringBuilder();
        StringBuilder S2=new StringBuilder();
        StringBuilder S3=new StringBuilder();
        StringBuilder S4=new StringBuilder();

        int i=0,j=0;
        int len=s.length();
        String temp=null;
        while (i<len){
            if (Character.isUpperCase(s.charAt(i))){
                temp=s.substring(j,i);
                j=i;
                list.add(temp);
            }else if (i==len-1){
                temp=s.substring(j,i+1);
                j=i;
                list.add(temp);
            }
            i++;
        }
        list.remove(0);
        int size=list.size();
        S1.append(list.get(0).toLowerCase());
        for (int k = 1; k <size ; k++) {
            S1.append(list.get(k));
        }
        for (int k = 0; k < size-1; k++) {
            S2.append(list.get(k).toLowerCase()).append("_");
            S3.append(list.get(k).toLowerCase()).append("-");
        }
        S2.append(list.get(size-1).toLowerCase());
        S3.append(list.get(size-1).toLowerCase());

        return S4.append(s).append(" ").append(S1).append(" ").append(S2).append(" ").append(S3).toString();
    }
}
