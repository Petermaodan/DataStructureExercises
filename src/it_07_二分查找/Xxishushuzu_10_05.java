package it_07_二分查找;

public class Xxishushuzu_10_05 {
    public int findString(String[] words, String s) {
        int left=0;
        int right=words.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int tmp=mid;
            while (mid<right&&words[mid].equals("")){
                mid++;
            }
            if (words[mid].equals("")){
                right=tmp-1;
                continue;
            }
            if (words[mid].equals(s)){
                return mid;
            }else if (words[mid].compareTo(s)>0){
                right=mid-1;
            }else if (words[mid].compareTo(s)<0){
                left=mid+1;

            }
        }
        return -1;

    }
}
