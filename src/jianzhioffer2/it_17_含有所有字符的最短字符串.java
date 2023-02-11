package jianzhioffer2;

import java.util.HashMap;
import java.util.Map;

public class it_17_含有所有字符的最短字符串 {
    public static void main(String[] args) {
        String s = "kgfidhktkjhlkbgjkylgdracfzjduycghkomrbfbkoowqwgaurizliesjnveoxmvjdjaepdqftmvsuyoogobrutahogxnvuxyezevfuaaiyufwjtezuxtpycfgasburzytdvazwakuxpsiiyhewctwgycgsgdkhdfnzfmvhwrellmvjvzfzsdgqgolorxvxciwjxtqvmxhxlcijeqiytqrzfcpyzlvbvrksmcoybxxpbgyfwgepzvrezgcytabptnjgpxgtweiykgfiolxniqthzwfswihpvtxlseepkopwuueiidyquratphnnqxflqcyiiezssoomlsxtyxlsolngtctjzywrbvajbzeuqsiblhwlehfvtubmwuxyvvpwsrhutlojgwktegekpjfidgwzdvxyrpwjgfdzttizquswcwgshockuzlzulznavzgdegwyovqlpmnluhsikeflpghagvcbujeapcyfxosmcizzpthbzompvurbrwenflnwnmdncwbfebevwnzwclnzhgcycglhtbfjnjwrfxwlacixqhvuvivcoxdrfqazrgigrgywdwjgztfrbanwiiayhdrmuunlcxstdsrjoapntugwutuedvemyyzusogumanpueyigpybjeyfasjfpqsqotkgjqaxspnmvnxbfvcobcudxflmvfcjanrjfthaiwofllgqglhkndpmiazgfdrfsjracyanwqsjcbakmjubmmowmpeuuwznfspjsryohtyjuawglsjxezvroallymafhpozgpqpiqzcsxkdptcutxnjzawxmwctltvtiljsbkuthgwwbyswxfgzfewubbpowkigvtywdupmankbndyligkqkiknjzchkmnfflekfvyhlijynjlwrxodgyrrxvzjhoroavahsapdiacwjpucnifviyohtprceksefunzucdfchbnwxplhxgpvxwrmpvqzowgimgdolirslgqkyc";
        String t = "ABC";

        String result = new it_17_含有所有字符的最短字符串().minWindow(s, t);
        System.out.println(result);
    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> windows=new HashMap<>();
        Map<Character,Integer> needs=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c=t.charAt(i);
            needs.put(c,needs.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int valid=0;
        int start=0;
        int len=Integer.MAX_VALUE;
        while (right<s.length()){
            char c=s.charAt(right);
            right++;
            if (needs.containsKey(c)){
                windows.put(c,windows.getOrDefault(c,0)+1);
                if (needs.getOrDefault(c,0).equals(windows.getOrDefault(c,-1))){
                    valid++;
                }
            }
            while (valid==needs.size()){
                if (right-left<len){
                    len=right-left;
                    start=left;
                }
                char d=s.charAt(left);
                left++;
                if (needs.containsKey(d)){
                    if (needs.getOrDefault(d,0).equals(windows.getOrDefault(d,-1))){
                        valid--;
                    }
                    windows.put(d,windows.getOrDefault(d,0)-1);
                }
            }
        }
        return len==Integer.MAX_VALUE?"":s.substring(start,start+len);
    }
}
