package leetcode.hot100;

/**
 * 句子仅由小写字母（'a' 到 'z'）、数字（'0' 到 '9'）、连字符（'-'）、标点符号（'!'、'.' 和 ','）以及空格（' '）组成。每个句子可以根据空格分解成 一个或者多个 token ，这些 token 之间由一个或者多个空格 ' ' 分隔。
 *
 * 如果一个 token 同时满足下述条件，则认为这个 token 是一个有效单词：
 *
 * 仅由小写字母、连字符和/或标点（不含数字）。
 * 至多一个 连字符 '-' 。如果存在，连字符两侧应当都存在小写字母（"a-b" 是一个有效单词，但 "-ab" 和 "ab-" 不是有效单词）。
 * 至多一个 标点符号。如果存在，标点符号应当位于 token 的 末尾 。
 * 这里给出几个有效单词的例子："a-b."、"afad"、"ba-c"、"a!" 和 "!" 。
 *
 * 给你一个字符串 sentence ，请你找出并返回 sentence 中 有效单词的数目 。
 *
 */
public class it_2047_句子中的有效单词书 {
    public static void main(String[] args) {
        String sentence =" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif ";
        int res = new it_2047_句子中的有效单词书().countValidWords(sentence);
        System.out.println(res);
    }

    public int countValidWords(String sentence) {
        int n=sentence.length();
        int i=0,j=0;
        int res=0;
        while (j<n){
            while (j<n&&sentence.charAt(j)!=' '){
                j++;
            }
            String tempS=sentence.substring(i,j);
            boolean flag=check(tempS);
            if (flag){
                res++;
            }
            while (j<n&&sentence.charAt(j)==' '){
                j++;
            }
            i=j;
        }
        return res;
    }

    private boolean check(String tempS) {
        int n=tempS.length();
        if (n==0)return false;
        int count1=0;
        int count2=0;
        for (int i = 0; i < n; i++) {
            char c = tempS.charAt(i);
            if (Character.isDigit(c)){
                return false;
            }
            if (c == '-' && ++count1 >= 0) {
                if (count1 > 1 || (i == 0 || i == n - 1)) return false;
                if (!Character.isLetter(tempS.charAt(i - 1)) || !Character.isLetter(tempS.charAt(i + 1))) return false;
            }
            if ((c=='!'||c=='.'||c==',')&&++count2>=0){
                if (count2>1||(i!=n-1)){
                    return false;
                }
            }

        }
        return true;
    }
}
